package com.hintdesk.De_De_Dict.implementations.dao;

import android.content.ContentValues;
import android.database.Cursor;
import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;
import com.hintdesk.De_De_Dict.contract.vo.Word;
import com.hintdesk.De_De_Dict.interfaces.dao.IWordDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordDAO extends BaseDAO implements IWordDAO {
    @Override
    public List<Word> loadAll() {
        List<Word> result = new ArrayList<Word>();
        Cursor cursor = loadAll(Word.TABLE, Word.COLUMNS);
        if (cursor.moveToFirst()) {
            do {
                Word word = new Word();
                word.setID(cursor.getInt(cursor.getColumnIndex(Word._ID)));
                word.setName(cursor.getString(cursor.getColumnIndex(Word.NAME)));
                word.setType(WordType.valueOf(cursor.getString(cursor.getColumnIndex(Word.TYPE))));
                word.setPlural(cursor.getString(cursor.getColumnIndex(Word.PLURAL)));
                word.setMeaning(cursor.getString(cursor.getColumnIndex(Word.MEANING)));
                word.setSynonym(cursor.getString(cursor.getColumnIndex(Word.SYNONYM)));
                word.setExample(cursor.getString(cursor.getColumnIndex(Word.EXAMPLE)));
                result.add(word);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return result;
    }

    @Override
    public Word load(String name) {
        String selection = "NAME = ?";
        String[] args = {name};
        Cursor cursor = loadAll(Word.TABLE, Word.COLUMNS, selection, args);

        Word word = null;
        if (cursor.moveToFirst()) {

            word = new Word();
            word.setID(cursor.getInt(cursor.getColumnIndex(Word._ID)));
            word.setName(cursor.getString(cursor.getColumnIndex(Word.NAME)));
            word.setType(WordType.valueOf(cursor.getString(cursor.getColumnIndex(Word.TYPE))));
            word.setPlural(cursor.getString(cursor.getColumnIndex(Word.PLURAL)));
            word.setMeaning(cursor.getString(cursor.getColumnIndex(Word.MEANING)));
            word.setSynonym(cursor.getString(cursor.getColumnIndex(Word.SYNONYM)));
            word.setExample(cursor.getString(cursor.getColumnIndex(Word.EXAMPLE)));

        }
        return word;
    }

    @Override
    public void saveOrUpdate(Word word) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Word.NAME, word.getName());
        contentValues.put(Word.TYPE, word.getType().name());
        contentValues.put(Word.PLURAL, word.getPlural());
        contentValues.put(Word.MEANING, word.getMeaning());
        contentValues.put(Word.SYNONYM, word.getSynonym());
        contentValues.put(Word.EXAMPLE, word.getExample());
        if (word.getID()<=0)
            insert(Word.TABLE, contentValues);
        else
        {
            String selection = "_ID = ?";
            String[] args = {Integer.toString(word.getID())};
            update(Word.TABLE,contentValues,selection,args);
        }
    }
}
