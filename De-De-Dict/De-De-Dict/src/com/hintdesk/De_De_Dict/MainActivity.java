package com.hintdesk.De_De_Dict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.inject.Inject;
import com.hintdesk.De_De_Dict.contract.constants.ConstantValues;
import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;
import com.hintdesk.De_De_Dict.contract.util.common.EnumUtil;
import com.hintdesk.De_De_Dict.contract.vo.Word;
import com.hintdesk.De_De_Dict.infrastructure.IOCModule;
import com.hintdesk.De_De_Dict.interfaces.viewmodel.IMainActivityViewModel;
import com.hintdesk.De_De_Dict.view.AddWordActivity;
import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class MainActivity extends RoboActivity {

    @InjectView(R.id.autoCompleteTextView)
    private AutoCompleteTextView autoCompleteTextView;
    @InjectView(R.id.imageButtonSearch)
    private ImageButton imageButtonSearch;
    @InjectView(R.id.textViewName)
    private TextView textViewName;
    @InjectView(R.id.textViewType)
    private TextView textViewType;
    @InjectView(R.id.textViewMeaning)
    private TextView textViewMeaning;
    @InjectView(R.id.textViewSynonym)
    private TextView textViewSynonym;
    @InjectView(R.id.textViewExample)
    private TextView textViewExample;

    @Inject
    private IMainActivityViewModel viewModel;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeComponent();
    }

    private void initializeComponent() {
        viewModel.setContext(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, viewModel.getWords());
        autoCompleteTextView.setAdapter(arrayAdapter);
        imageButtonSearch.setOnClickListener(imageButtonSearchOnClickListener);
    }

    private View.OnClickListener imageButtonSearchOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String lookUpWord = autoCompleteTextView.getText().toString();
            viewModel.setLookUpWord(lookUpWord);
            viewModel.search();
            Word word = viewModel.getCurrentWord();
            if (word != null) {
                textViewName.setText(word.getName());
                textViewType.setText(word.getType().toString());
                textViewMeaning.setText(word.getMeaning());
                textViewSynonym.setText(word.getSynonym());
                textViewExample.setText(word.getExample());
            } else {
                Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
                intent.putExtra(ConstantValues.EXTRA_WORD, lookUpWord);
                startActivity(intent);
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddWordActivity.class);

        switch (item.getItemId()) {
            case R.id.main_menu_add:
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
