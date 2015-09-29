package com.example.danny.mod1class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llShow, llHide, llForm;
    private EditText txtEnterName;
    private Button btnExecute, btnShow;
    private Spinner spBeverages;
    private TextView lblSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llShow = (LinearLayout)findViewById(R.id.llShow);
        llHide = (LinearLayout)findViewById(R.id.llHide);
        llForm = (LinearLayout)findViewById(R.id.llForm);

        txtEnterName = (EditText)findViewById(R.id.txtEnterName);

        btnExecute = (Button)findViewById(R.id.btnExecute);
        btnShow = (Button)findViewById(R.id.btnShow);
        spBeverages = (Spinner)findViewById(R.id.spBeverages);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.beverages));
        spBeverages.setAdapter(adapter);

        lblSpinner = (TextView)findViewById(R.id.lblSpinner);
    }

    @Override
    protected void onResume(){
        super.onResume();
        llShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llForm.setVisibility(View.VISIBLE);
            }
        });
        llHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llForm.setVisibility(View.GONE);
            }
        });

        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = txtEnterName.getText().toString();
                Toast.makeText(MainActivity.this,  myName, Toast.LENGTH_SHORT).show();

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myChoose = spBeverages.getSelectedItem().toString();
                if (myChoose.compareToIgnoreCase(getResources().getString(R.string.main_default_spinner_choose))!=0){
                    Toast.makeText(MainActivity.this, myChoose, Toast.LENGTH_SHORT).show();
                }
            }
        });

        spBeverages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    lblSpinner.setText(parent.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
