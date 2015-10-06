package com.example.danny.mod1class6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.danny.adapters.ImageListAdapter;
import com.example.danny.models.Images;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView _lvLista;
    private ImageListAdapter _adapter;
    private ArrayList<Images> _dataSource = new ArrayList<Images>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _lvLista = (ListView)findViewById(R.id.lvwImages);
        populateImageList();
        _adapter = new ImageListAdapter(MainActivity.this, _dataSource);
        _lvLista.setAdapter(_adapter);
    }

    private void populateImageList(){
        _dataSource.add(new Images(1,"http://www.drink-shop.ch/383-home_default/fanta-fruit-twist-330-ml-uk.jpg", "Fanta", "", "10/11/2015"));
        _dataSource.add(new Images(2,"http://www.corksandcans.co.uk/96-142-home/casillero-del-diablo-sauvignon-blanc.jpg", "Casillero del diablo", "", "10/12/2015"));
        _dataSource.add(new Images(3,"http://www.drink-shop.ch/688-home_default/corona-light-355-ml-42-mexiko.jpg", "Cerveza Corona", "", "03/10/2015"));
        _dataSource.add(new Images(4,"http://www.disevil.com/tienda/536-home_default/whisky-johnnie-walker-black-label.jpg", "JW Red", "", "15/10/2015"));
        _dataSource.add(new Images(5,"http://www.vinasur.com/454-home_default/whisky-johnnie-walker-blue-label.jpg", "JW Blue", "", "10/10/2015"));
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
