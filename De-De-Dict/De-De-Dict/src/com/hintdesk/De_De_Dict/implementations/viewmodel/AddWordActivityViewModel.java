package com.hintdesk.De_De_Dict.implementations.viewmodel;

import android.content.Context;
import com.google.inject.Inject;
import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;
import com.hintdesk.De_De_Dict.contract.vo.Word;
import com.hintdesk.De_De_Dict.interfaces.dao.IWordDAO;
import com.hintdesk.De_De_Dict.interfaces.viewmodel.IAddWordActivityViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 6/1/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddWordActivityViewModel implements IAddWordActivityViewModel {
    private String Name;
    private WordType Type;
    private String Plural;
    private String Meaning;
    private String Synonym;
    private String Example;
    private List<String> Types;

    @Inject
    private IWordDAO wordDAO;

    public AddWordActivityViewModel() {
        Types = new ArrayList<String>();
        for (WordType wordType : WordType.values()) {
            Types.add(wordType.toString());
        }
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public WordType getType() {
        return Type;
    }

    public void setType(WordType type) {
        Type = type;
    }

    public String getPlural() {
        return Plural;
    }

    public void setPlural(String plural) {
        Plural = plural;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }

    public String getSynonym() {
        return Synonym;
    }

    public void setSynonym(String synonym) {
        Synonym = synonym;
    }

    public String getExample() {
        return Example;
    }

    public void setExample(String example) {
        Example = example;
    }

    public List<String> getTypes() {
        return Types;
    }

    @Override
    public void saveOrUpdate() {
        Word word = wordDAO.load(Name);
        if (word == null)
            word = new Word();
        word.setName(Name);
        word.setType(Type);
        word.setPlural(Plural);
        word.setMeaning(Meaning);
        word.setSynonym(Synonym);
        word.setExample(Example);
        wordDAO.saveOrUpdate(word);
    }

    @Override
    public void setContext(Context context) {
        wordDAO.setContext(context);
    }

    @Override
    public Word getWord(String lookupWord) {
        return wordDAO.load(lookupWord);
    }

}
