package com.example.danny.mod1class6_2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.danny.adapter.ViewPagerAdapter;
import com.example.danny.views.DepthPageTransformer;

public class MostrarActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        viewPager = (ViewPager) findViewById(R.id.vprView);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
    }

    @Override
    protected void onResume() {
        super.onResume();
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        Bundle bundle = getIntent().getExtras();
        int position= bundle.getInt("posicion");
        viewPager.setCurrentItem(position);
    }
}
