package com.hintdesk.De_De_Dict.interfaces.viewmodel;

import android.content.Context;
import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;
import com.hintdesk.De_De_Dict.contract.vo.Word;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 6/1/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IAddWordActivityViewModel {

    void setName(String name);

    void setType(WordType type);

    void setPlural(String plural);

    void setMeaning(String meaning);

    void setSynonym(String synonym);

    void setExample(String example);

    List<String> getTypes();

    void saveOrUpdate();

    void setContext(Context context);

    Word getWord(String lookupWord);
}
