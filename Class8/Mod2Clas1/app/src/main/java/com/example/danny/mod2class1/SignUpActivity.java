package com.example.danny.mod2class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danny.dataaccess.UserDataAccess;
import com.example.danny.models.User;

public class SignUpActivity extends AppCompatActivity {
    private EditText txtUserName, txtUserEmail, txtUserPwd;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtUserEmail = (EditText) findViewById(R.id.txtUserEmail);
        txtUserPwd = (EditText)findViewById(R.id.txtUserPwd);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validations
                InsertUserToDataBase();
            }
        });
    }

    private void InsertUserToDataBase(){
        User user = new User(txtUserName.getText().toString().trim(),
                txtUserEmail.getText().toString().trim(),
                txtUserPwd.getText().toString().trim());
        UserDataAccess userDataAccess = new UserDataAccess();
        userDataAccess.insertUser(user);
        Toast.makeText(getApplicationContext(),"User saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}