package pe.tutrago.tutragomobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity {

    @Bind(R.id.btnCreateAccount)
    Button _btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        _btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount_login();
            }
        });
    }

    private void createAccount_login(){
        Intent welcomeIntent = new Intent(AccountActivity.this, WelcomeActivity.class);
        startActivity(welcomeIntent);
        finish();
    }
}
