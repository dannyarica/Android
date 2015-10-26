package example.danny.com.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import example.danny.com.aplication.Configuration;
import example.danny.com.models.RepasoItem;

/**
 * Created by DArica on 21/10/2015.
 */
public class ItemDataAccess {
    private SQLiteDatabase sqLiteDatabase;

    public ItemDataAccess() {

    }

    public void insertItem(RepasoItem item) {
        sqLiteDatabase = Configuration.sqlManager.getWritable();
        String sqlCommand = "INSERT INTO tblItem(titulo,descripcion,rango) VALUES ('@titulo','@descripcion','@rango')";
        String toExecute = sqlCommand.replace("@titulo", item.get_titulo()).
                replace("@descripcion", item.get_descripcion()).
                replace("@rango", item.get_rango());
        sqLiteDatabase.execSQL(toExecute);
    }

    public ArrayList<RepasoItem> getAll() {
        sqLiteDatabase = Configuration.sqlManager.getReadable();
        RepasoItem itemToReturn;
        ArrayList<RepasoItem> result = null;
        String sqlCommand = "SELECT * FROM tblItem";
        Cursor cursor= sqLiteDatabase.rawQuery(sqlCommand, null);
        if (cursor != null && cursor.getCount()>0){
            result = new ArrayList<RepasoItem>();
            cursor.moveToFirst();
            do {
                itemToReturn = new RepasoItem();
                itemToReturn.set_titulo(cursor.getString(cursor.getColumnIndex("titulo")));
                itemToReturn.set_descripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
                itemToReturn.set_rango(cursor.getString(cursor.getColumnIndex("rango")));
                result.add(itemToReturn);
            }while (cursor.moveToNext());
        }
        return result;
    }

    // Factory method to convert an array of JSON objects into a list of objects
    // User.fromJson(jsonArray);
    public ArrayList<RepasoItem> fromJson(JSONArray jsonObjects) {
        ArrayList<RepasoItem> items = new ArrayList<RepasoItem>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                items.add(new RepasoItem(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}
