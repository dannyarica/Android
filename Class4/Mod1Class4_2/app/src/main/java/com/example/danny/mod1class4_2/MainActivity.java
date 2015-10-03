package com.example.danny.mod1class4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.danny.Singleton.Helper;
import com.example.danny.adapters.ListAdapter;
import com.example.danny.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtName, txtLastName, txtAge;
    private Button btnSave, btnShowContacts;
    private int myPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText) findViewById(R.id.txtName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtAge = (EditText) findViewById(R.id.txtAge);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnShowContacts = (Button) findViewById(R.id.btnShowContacts);
        myPosition = 0;
        Intent myIntent = getIntent();
        if (myIntent != null) {
            if (myIntent.hasExtra("#POSITION")) {
                myPosition = myIntent.getIntExtra("#POSITION", -1);
                if (myPosition > -1) {
                    Contact myContact = Helper.ContactArrayList.get(myPosition);
                    populateData(myContact);
                    btnSave.setText("Update");
                    Toast.makeText(MainActivity.this, "Contact loaded", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void populateData(Contact myContact) {
        txtName.setText(myContact.getName().toString());
        txtLastName.setText(myContact.getLastName().toString());
        txtAge.setText(String.valueOf(myContact.getAge()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnSave.getText() == "Save") {
                    Helper.ContactArrayList.add(getContact(txtName.getText().toString(),
                            txtLastName.getText().toString(),
                            Integer.parseInt(txtAge.getText().toString())));
                    cleanForm();
                    txtName.requestFocus();
                    Toast.makeText(MainActivity.this, "Contact saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Helper.ContactArrayList.get(myPosition).setName(txtName.getText().toString());
                    Helper.ContactArrayList.get(myPosition).setLastName(txtLastName.getText().toString());

                }
            }
        });

        btnShowContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });
    }

    private Contact getContact(String name, String lastName, int age) {
        return new Contact(name, lastName, age);
    }

    private void cleanForm(){
        txtName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
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
