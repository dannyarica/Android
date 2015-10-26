package example.danny.com.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DArica on 21/10/2015.
 */
public class SqlLiteHelper extends SQLiteOpenHelper {

    public SqlLiteHelper(Context context) {
        super(context, SqlConstants.DB_NAME, null, SqlConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlConstants.SQLCommandCreateTableArticulos);
        db.execSQL(SqlConstants.SQLCommandCreateTableImagenes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SqlConstants.SQLCommandDropTableArticulos);
        db.execSQL(SqlConstants.SQLCommandDropTableImagenes);
        onCreate(db);
    }
}