package com.example.danny.dataaccess;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.danny.aplication.Configuration;
import com.example.danny.models.User;

/**
 * Created by DArica on 14/10/2015.
 */
public class UserDataAccess implements IUserDataAccess {

    private SQLiteDatabase sqLiteDatabase;

    public UserDataAccess() {

    }

    public void insertUser(User user) {
        sqLiteDatabase = Configuration.sqlManager.getWritable();
        String sqlCommand = "INSERT INTO tblUser(name,email,pwd, remember) VALUES ('@NAME','@EMAIL','@PWD', 0)";
        String toExecute = sqlCommand.replace("@NAME", user.getName()).
                            replace("@EMAIL", user.getEmail()).
                            replace("@PWD", user.getPwd());
        sqLiteDatabase.execSQL(toExecute);
    }

    public User getUser(User user) {
        sqLiteDatabase = Configuration.sqlManager.getReadable();
        User userToReturn = null;
        String sqlCommand = "SELECT * FROM tblUser WHERE email='@EMAIL' and pwd='@PWD'";
        String toExecute = sqlCommand.replace("@EMAIL", user.getEmail()).
                replace("@PWD", user.getPwd());
        Cursor cursor= sqLiteDatabase.rawQuery(toExecute, null);
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                userToReturn = new User();
                userToReturn.setName(cursor.getString(cursor.getColumnIndex("name")));
                userToReturn.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            }while (cursor.moveToNext());
        }
        return userToReturn;
    }

    public void updateUserRemember(int remember) {
        sqLiteDatabase = Configuration.sqlManager.getWritable();
        String sqlCommand = "UPDATE tblUser SET remember = @REMEMBER";
        String toExecute = sqlCommand.replace("@REMEMBER", String.valueOf(remember));
        sqLiteDatabase.execSQL(toExecute);
    }

    public User getRememberUser(){
        sqLiteDatabase = Configuration.sqlManager.getReadable();
        User userToReturn = null;
        String sqlCommand = "SELECT * FROM tblUser WHERE remember='1'";
        Cursor cursor= sqLiteDatabase.rawQuery(sqlCommand, null);
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                userToReturn = new User();
                userToReturn.setName(cursor.getString(cursor.getColumnIndex("name")));
                userToReturn.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            }while (cursor.moveToNext());
        }
        return userToReturn;
    }
}