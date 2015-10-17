package com.hintdesk.De_De_Dict.contract.vo;

import android.provider.BaseColumns;
import com.hintdesk.De_De_Dict.contract.constants.enumerations.WordType;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Word implements InfoItem {

    public static final String NAME = "Name";
    public static final String TYPE = "Type";
    public static final String GENUS = "Genus";
    public static final String HYPHENATION = "Hyphenation";
    public static final String PLURAL = "Plural";
    public static final String MEANING = "Meaning";
    public static final String ORIGIN = "Origin";
    public static final String SYNONYM = "Synonym";
    public static final String EXAMPLE = "Example";

    public static final String TABLE = "Words";
    public static final String[] COLUMNS = {_ID, NAME, TYPE, GENUS, HYPHENATION, PLURAL, MEANING, ORIGIN, SYNONYM, EXAMPLE};

    private int ID;
    private String Name;
    private WordType Type;
    private int Genus;
    private String Hyphenation;
    private String Plural;
    private String Meaning;
    private String Origin;
    private String Synonym;
    private String Example;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getGenus() {
        return Genus;
    }

    public void setGenus(int genus) {
        Genus = genus;
    }

    public String getHyphenation() {
        return Hyphenation;
    }

    public void setHyphenation(String hyphenation) {
        Hyphenation = hyphenation;
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

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
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
}
