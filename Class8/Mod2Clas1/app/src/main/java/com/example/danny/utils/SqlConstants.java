package com.example.danny.utils;

/**
 * Created by DArica on 14/10/2015.
 */
public class SqlConstants {
    public static final String DB_NAME = "userLogin.db";
    public static final int DB_VERSION = 1;

    public static final String TBL_USUARIO = "tblUsers";

    public static final String COL_NAME = "name";
    public static final String COL_PWD = "password";
    public static final String COL_EMAIL = "email";

    //Create user tables

    public static final String SQLCommandCreateTable = "CREATE TABLE tblUser(name TEXT, email TEXT, pwd TEXT, remember INTEGER)";
    public static final String SQLCommandDropTable = "DROP TABLE tblUser";
}
