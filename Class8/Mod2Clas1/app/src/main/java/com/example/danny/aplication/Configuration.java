package com.example.danny.aplication;

import android.app.Application;

import com.example.danny.sqlLite.SqlManager;

/**
 * Created by DArica on 14/10/2015.
 */
public class Configuration extends Application {

    public static SqlManager sqlManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sqlManager = new SqlManager(getApplicationContext());
    }
}
