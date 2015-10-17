package com.example.danny.sqlLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.danny.utils.SqlConstants;

/**
 * Created by DArica on 14/10/2015.
 */
public class SqlLiteHelper extends SQLiteOpenHelper {

    public SqlLiteHelper(Context context) {
        super(context, SqlConstants.DB_NAME, null, SqlConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlConstants.SQLCommandCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SqlConstants.SQLCommandDropTable);
        onCreate(db);
    }
}
