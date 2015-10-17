package com.hintdesk.De_De_Dict.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.inject.Inject;
import com.hintdesk.De_De_Dict.R;
import com.hintdesk.De_De_Dict.contract.constants.ConstantValues;
import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;
import com.hintdesk.De_De_Dict.contract.util.common.EnumUtil;
import com.hintdesk.De_De_Dict.contract.vo.Word;
import com.hintdesk.De_De_Dict.interfaces.viewmodel.IAddWordActivityViewModel;
import com.hintdesk.core.utils.StringUtil;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 6/1/13
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddWordActivity extends RoboActivity {

    @InjectView(R.id.editTextName) private EditText editTextName;
    @InjectView(R.id.editTextPlural) private EditText editTextPlural;
    @InjectView(R.id.editTextMeaning) private EditText editTextMeaning;
    @InjectView(R.id.editTextSynonym) private EditText editTextSynonym;
    @InjectView(R.id.editTextExample) private EditText editTextExample;
    @InjectView(R.id.spinnerType) private Spinner spinnerType;
    @Inject private IAddWordActivityViewModel viewModel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addword);

        initializeComponent();

        Intent intent = getIntent();
        String lookupWord = intent.getStringExtra(ConstantValues.EXTRA_WORD);
        if (!StringUtil.isNullOrWhitespace(lookupWord))
        {
            Word word =  viewModel.getWord(lookupWord);
            if (word == null)
            {
                editTextName.setText(lookupWord);
            }
            else
            {
                editTextName.setText(word.getName());
                editTextPlural.setText(word.getPlural());
                editTextMeaning.setText(word.getMeaning());
                editTextSynonym.setText(word.getSynonym());
                editTextExample.setText(word.getExample());
                spinnerType.setSelection(viewModel.getTypes().indexOf(word.getType().toString()));
            }
        }
    }

    private void initializeComponent() {
        viewModel.setContext(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,viewModel.getTypes());
        spinnerType.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuaddword,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.addword_menu_save:
                viewModel.setName(editTextName.getText().toString());
                viewModel.setType((WordType) EnumUtil.getValue(spinnerType.getSelectedItem().toString(), WordType.class));
                viewModel.setPlural(editTextPlural.getText().toString());
                viewModel.setMeaning(editTextMeaning.getText().toString());
                viewModel.setSynonym(editTextSynonym.getText().toString());
                viewModel.setExample(editTextExample.getText().toString());
                viewModel.saveOrUpdate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}