package com.example.danny.mod2class1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.danny.aplication.Configuration;
import com.example.danny.dataaccess.UserDataAccess;
import com.example.danny.models.User;
import com.example.danny.utils.Constants;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail, txtPwd;
    private CheckBox chkRememberMe;
    private Button btnLogin;
    private LinearLayout llSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPwd = (EditText)findViewById(R.id.txtPwd);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        chkRememberMe = (CheckBox) findViewById(R.id.chkRememberMe);
        llSignUp = (LinearLayout)findViewById(R.id.llSignUp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ValidateRemember();
        llSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:Validation
                UserDataAccess userDataAccess = new UserDataAccess();
                User userToValidate = new User();
                userToValidate.setEmail(txtEmail.getText().toString());
                userToValidate.setPwd(txtPwd.getText().toString());
                User userValidated = userDataAccess.getUser(userToValidate);
                if (userValidated != null){
                    //Ask if chkRemember was checked
                    if (chkRememberMe.isChecked()){
                        userDataAccess.updateUserRemember(1);
                    }
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Constants.userLogged = userValidated;
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"User / Pwd incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ValidateRemember() {
        UserDataAccess userDataAccess = new UserDataAccess();
        User userRemember = userDataAccess.getRememberUser();
        if (userRemember != null){
            Constants.userLogged = userRemember;
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
            finish();
        }
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
