package example.danny.com.aplication;

import android.app.Application;

import example.danny.com.sql.SqlManager;

/**
 * Created by DArica on 21/10/2015.
 */
public class Configuration extends Application{
    public static SqlManager sqlManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sqlManager = new SqlManager(getApplicationContext());
    }
}
