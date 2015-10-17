package com.example.danny.mod2class1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danny.dataaccess.UserDataAccess;
import com.example.danny.models.User;
import com.example.danny.utils.Constants;

public class WelcomeActivity extends AppCompatActivity {
    private User myUser;
    private TextView txtUserName;
    private Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtUserName = (TextView)findViewById(R.id.txtWelcomeUserName);
        btnSignOut = (Button) findViewById(R.id.btnSignOut);
        myUser = Constants.userLogged;
        if (myUser != null){
            txtUserName.setText(myUser.getName().toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDataAccess userDataAccess = new UserDataAccess();
                userDataAccess.updateUserRemember(0);
                Toast.makeText(getApplicationContext(), "User signed out!!!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
