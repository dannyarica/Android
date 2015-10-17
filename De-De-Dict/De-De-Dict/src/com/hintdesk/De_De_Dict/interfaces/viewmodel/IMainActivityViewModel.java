package com.hintdesk.De_De_Dict.interfaces.viewmodel;

import android.content.Context;
import com.hintdesk.De_De_Dict.MainActivity;
import com.hintdesk.De_De_Dict.contract.vo.Word;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/30/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMainActivityViewModel {

    List<String> getWords();

    void setLookUpWord(String lookUpWord);

    void search();

    Word getCurrentWord();

    void setContext(Context context);

}
