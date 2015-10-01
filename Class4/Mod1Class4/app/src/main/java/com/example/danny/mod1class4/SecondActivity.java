package com.example.danny.mod1class4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DArica on 30/09/2015.
 */
public class SecondActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnSecondNext;
    private TextView lblTexto;
    String myValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSecondNext = (Button) findViewById(R.id.btnSecondNext);
        lblTexto = (TextView) findViewById(R.id.lblTexto);

        String myKeyExtra = "VALUE";
        if (getIntent().hasExtra(myKeyExtra)){
            myValue = getIntent().getStringExtra(myKeyExtra);
            lblTexto.setText(myValue);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSecondNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myThirdIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("VALUE", "Fuck you!!!");
                myThirdIntent.putExtras(myBundle);
                startActivity(myThirdIntent);
            }
        });
    }
}
