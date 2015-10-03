package com.example.danny.class1mod5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {
    protected ImageLoader iml= ImageLoader.getInstance();
    private ImageView ivwImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivwImage = (ImageView)findViewById(R.id.ivwImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        iml.displayImage("http://i.ytimg.com/vi/8IMldy3Nz48/maxresdefault.jpg", ivwImage);
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
