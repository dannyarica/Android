package com.hintdesk.De_De_Dict.contract.util.database.migrations;

import com.hintdesk.De_De_Dict.contract.vo.Word;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Migration_0001 extends Migration {
    public Migration_0001() {
        steps.add("CREATE TABLE " + Word.TABLE + " (" + Word._ID + " INTEGER PRIMARY KEY, " + Word.NAME + " TEXT, " + Word.TYPE + " TEXT, " + Word.GENUS + " NUMERIC, " + Word.HYPHENATION + " TEXT, " + Word.PLURAL + " TEXT, " + Word.MEANING + " TEXT, " + Word.ORIGIN + " TEXT, " + Word.SYNONYM + " TEXT, " + Word.EXAMPLE + " TEXT)");
    }
}
