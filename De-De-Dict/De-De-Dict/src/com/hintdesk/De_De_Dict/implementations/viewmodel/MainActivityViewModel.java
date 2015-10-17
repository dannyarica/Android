package com.hintdesk.De_De_Dict.implementations.viewmodel;

import android.content.Context;
import android.util.Log;
import com.google.inject.Inject;
import com.hintdesk.De_De_Dict.contract.vo.Word;
import com.hintdesk.De_De_Dict.interfaces.dao.IWordDAO;
import com.hintdesk.De_De_Dict.interfaces.viewmodel.IMainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/30/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainActivityViewModel implements IMainActivityViewModel {
    @Inject
    private IWordDAO wordDAO;

    private String lookUpWord;

    @Override
    public List<String> getWords() {
        List<String> result = new ArrayList<String>();
        for (Word word : wordDAO.loadAll()) {
            result.add(word.getName());
        }
        return result;
    }

    @Override
    public void setContext(Context context) {
        wordDAO.setContext(context);
    }

    @Override
    public void search() {
       wordDAO.load(lookUpWord);
    }

    public void setLookUpWord(String lookUpWord) {
        this.lookUpWord = lookUpWord;
    }

    @Override
    public Word getCurrentWord() {
        return wordDAO.load(lookUpWord);
    }
}
