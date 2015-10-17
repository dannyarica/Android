package com.hintdesk.De_De_Dict.interfaces.dao;

import com.hintdesk.De_De_Dict.contract.vo.Word;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/31/13
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IWordDAO extends IBaseDAO {
    List<Word> loadAll();

    Word load(String name);

    void saveOrUpdate(Word word);
}
