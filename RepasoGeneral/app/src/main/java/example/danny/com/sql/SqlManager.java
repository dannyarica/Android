package example.danny.com.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DArica on 21/10/2015.
 */
public class SqlManager {
    SqlLiteHelper sqlLiteHelper;

    public SqlManager(Context context){
        sqlLiteHelper = new SqlLiteHelper(context);
    }

    public SQLiteDatabase getWritable(){
        return sqlLiteHelper.getWritableDatabase();
    }

    public SQLiteDatabase getReadable(){
        return sqlLiteHelper.getReadableDatabase();
    }
}
