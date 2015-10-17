package com.hintdesk.De_De_Dict.infrastructure;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.hintdesk.De_De_Dict.implementations.dao.WordDAO;
import com.hintdesk.De_De_Dict.implementations.viewmodel.AddWordActivityViewModel;
import com.hintdesk.De_De_Dict.implementations.viewmodel.MainActivityViewModel;
import com.hintdesk.De_De_Dict.interfaces.dao.IWordDAO;
import com.hintdesk.De_De_Dict.interfaces.viewmodel.IAddWordActivityViewModel;
import com.hintdesk.De_De_Dict.interfaces.viewmodel.IMainActivityViewModel;

/**
 * Created with IntelliJ IDEA.
 * User: ServusKevin
 * Date: 5/30/13
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOCModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(IMainActivityViewModel.class).to(MainActivityViewModel.class);
        binder.bind(IWordDAO.class).to(WordDAO.class);
        binder.bind(IAddWordActivityViewModel.class).to(AddWordActivityViewModel.class);
    }
}
