package com.example.danny.mod2class2;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;


public class MainActivity extends Activity {
    @Bind(R.id.txvHello)
    TextView txvHello;

    @BindString(R.string.Hello)
    String hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txvHello.setText(hello);
    }
}
