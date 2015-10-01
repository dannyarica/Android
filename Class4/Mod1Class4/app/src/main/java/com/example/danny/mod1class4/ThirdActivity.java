package com.example.danny.mod1class4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DArica on 30/09/2015.
 */
public class ThirdActivity extends AppCompatActivity {

    private Button btnBack;
    private Button btnHome;
    private TextView lblTexto;
    String myValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnHome = (Button)findViewById(R.id.btnHome);
        lblTexto = (TextView)findViewById(R.id.lblTexto);

        String myKey = "VALUE";
        Bundle myBundleRequest = getIntent().getExtras();
        if (getIntent().getExtras() != null){
            if (myBundleRequest.containsKey(myKey)){
                myValue = myBundleRequest.getString(myKey);
                lblTexto.setText(myValue);
            }
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
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myHome = new Intent(ThirdActivity.this,MainActivity.class);
                myHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                myHome.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(myHome);
                finish();
            }
        });
    }
}
