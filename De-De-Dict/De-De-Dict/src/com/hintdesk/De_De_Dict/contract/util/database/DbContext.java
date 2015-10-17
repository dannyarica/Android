package com.hintdesk.De_De_Dict.contract.util.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.hintdesk.De_De_Dict.contract.util.database.migrations.Migration_0001;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class DbContext extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Dictionary.db";
    public static final int DATABASE_VERSION = 1;

    public DbContext(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //To change body of implemented methods use File | Settings | File Templates.
        db.execSQL(new Migration_0001().getSQLQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //To change body of implemented methods use File | Settings | File Templates.
        switch (newVersion)
        {

        }
    }
}
