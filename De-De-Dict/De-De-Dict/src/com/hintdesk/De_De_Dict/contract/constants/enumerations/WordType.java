package com.hintdesk.De_De_Dict.contract.constants.enumerations;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 6/2/13
 * Time: 7:36 AM
 * To change this template use File | Settings | File Templates.
 */
public enum WordType {
    Substantive("Substantiv"),
    Adjective("Adjektiv"),
    Adverb("Adverb"),
    Article("Artikel");

    private String description;
    private int value;

    private WordType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
