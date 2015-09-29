package com.example.danny.mod1class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llShow, llHide, llForm;
    private EditText txtEnterName;
    private Button btnExecute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llShow = (LinearLayout)findViewById(R.id.llShow);
        llHide = (LinearLayout)findViewById(R.id.llHide);
        llForm = (LinearLayout)findViewById(R.id.llForm);

        txtEnterName = (EditText)findViewById(R.id.txtEnterName);

        btnExecute = (Button)findViewById(R.id.btnExecute);
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
