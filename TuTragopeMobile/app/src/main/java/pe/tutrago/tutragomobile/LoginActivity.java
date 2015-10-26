package pe.tutrago.tutragomobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.tutrago.dataaccess.gateway.AuthenticateGateway;
import pe.tutrago.shared.Constants;

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.txtEmail)
    EditText _txtEmail;
    @Bind(R.id.txtPassword)
    EditText _txtPassword;
    @Bind(R.id.btnLogin)
    Button _btnLogin;
    @Bind(R.id.btnSignUp)
    Button _btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_click();
            }
        });

        _btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup_click();
            }
        });
    }

    private void login_click() {
        if (!validate()) {
            return;
        }
        _btnLogin.setEnabled(false);
/*        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Validating...");
        progressDialog.setTitle("Authentication");
        progressDialog.show();*/

        final String email = _txtEmail.getText().toString();
        final String password = _txtPassword.getText().toString();

/*        new Thread(new Runnable() {
            @Override
            public void run() {*/
        try {
            //go to services.tutrago.pe
            AuthenticateGateway authenticateGateway = new AuthenticateGateway();
            authenticateGateway.Login(email, password);
            //Intent welcomeIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
            //startActivity(welcomeIntent);
            //finish();
            //onLoginSuccess();
        } catch (Exception ex) {
            Log.e("Login", ex.getMessage());
        }
/*                progressDialog.dismiss();
            }
        }).start();*/
    }

    private boolean validate() {
        boolean valid = true;
        String email = _txtEmail.getText().toString();
        String password = _txtPassword.getText().toString();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _txtEmail.setError(Constants.errorEmailMessage);
            valid = false;
        } else {
            _txtEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < Constants.minCharactersPassword) {
            _txtPassword.setError(Constants.errorPasswordMessage);
            valid = false;
        } else {
            _txtPassword.setError(null);
        }

        return valid;
    }

    private void signup_click() {
        Intent signUpIntent = new Intent(LoginActivity.this, AccountActivity.class);
        startActivity(signUpIntent);
    }

    private void onLoginSuccess() {
        _btnLogin.setEnabled(true);
        //finish();
    }
}
