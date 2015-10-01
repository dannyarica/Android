package com.example.danny.mod1class4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.danny.adapters.ListAdapter;
import com.example.danny.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvwContacts;
    private ListAdapter contactAdapter;
    private ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvwContacts = (ListView)findViewById(R.id.lvwContacts);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Contact myContact = new Contact();
        myContact.Name ="Geraldine";
        myContact.LastName="Reyes";
        myContact.Age=24;
        contactArrayList.add(myContact);
        myContact = new Contact();
        myContact.Name ="Danny";
        myContact.LastName="Arica";
        myContact.Age=32;
        contactArrayList.add(myContact);
        contactAdapter = new ListAdapter(MainActivity.this, contactArrayList);
        lvwContacts.setAdapter(contactAdapter);
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
