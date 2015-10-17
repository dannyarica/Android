package com.example.danny.mod1class6_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.danny.adapter.GridAdapter;
import com.example.danny.models.Cupon;
import com.example.danny.utils.Constantes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gvwCupon);
        populate();
        gridAdapter = new GridAdapter(MainActivity.this, Constantes.cuponArrayList);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void populate() {
        for (int i = 1; i < 10; i++) {
            Constantes.cuponArrayList.add(new Cupon(
                    "Title #" + String.valueOf(i + 1),
                    "https://www.grouponworks.com/best-merchants-of-2012/img/badge-1500x1500.png"
            ));
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
