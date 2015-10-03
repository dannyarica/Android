package com.example.danny.mod1class4_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.danny.Singleton.Helper;
import com.example.danny.adapters.ListAdapter;
import com.example.danny.models.Contact;

import java.util.ArrayList;

/**
 * Created by DArica on 02/10/2015.
 */
public class ListaActivity extends AppCompatActivity {
    private ListView lvwContacts;
    private ListAdapter contactAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lvwContacts = (ListView)findViewById(R.id.lvwContacts);
        contactAdapter = new ListAdapter(ListaActivity.this, Helper.ContactArrayList);
        lvwContacts.setAdapter(contactAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvwContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaActivity.this, MainActivity.class);
                intent.putExtra("#POSITION", position);
                startActivity(intent);
            }
        });
    }
}
