package com.hintdesk.De_De_Dict.implementations.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.hintdesk.De_De_Dict.contract.util.database.DbContext;
import com.hintdesk.De_De_Dict.contract.vo.InfoItem;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseDAO {
    protected DbContext db;

    public Cursor loadAll(String table,String[] columns) {
        return db.getReadableDatabase().query(table,columns,null,null,null,null,null);
    }

    public void setContext(Context context) {
        db = new DbContext(context);
    }

    public Cursor loadAll(String table, String[] columns, String selection, String[] args) {
        return db.getReadableDatabase().query(table,columns,selection,args,null,null,null);
    }

    public void insert(String table,ContentValues contentValues)
    {
       db.getWritableDatabase().insert(table,null,contentValues);
    }

    public void update(String table, ContentValues contentValues,String selection, String[] args) {
        db.getWritableDatabase().update(table,contentValues,selection,args);
    }
}
