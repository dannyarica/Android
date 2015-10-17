package com.hintdesk.De_De_Dict.infrastructure;

import android.app.Application;
import roboguice.RoboGuice;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/30/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOCApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.
        RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, RoboGuice.newDefaultRoboModule(this), new IOCModule());

    }
}
