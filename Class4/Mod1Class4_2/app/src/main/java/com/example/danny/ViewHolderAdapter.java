package com.example.danny;

import android.widget.TextView;

/**
 * Created by DArica on 02/10/2015.
 */
public class ViewHolderAdapter {

    private static ViewHolderAdapter instance = null;
    private TextView lblName;
    private TextView lblLastName;
    private TextView lblAge;

    protected ViewHolderAdapter(){

    }

    public static ViewHolderAdapter getInstance() {
        if(instance == null) {
            instance = new ViewHolderAdapter();
        }
        return instance;
    }

    public static void SetIntance(){

    }
}
