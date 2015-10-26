package com.example.danny.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.danny.mod2class2.MainActivity;
import com.example.danny.mod2class2.R;

/**
 * Created by DArica on 19/10/2015.
 */
public class PagesFragment extends Fragment {
    private LinearLayout llMenu;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_pages,container,false);
        llMenu = (LinearLayout) root.findViewById(R.id.llMenu);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        llMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).toggle();
            }
        });
    }
}
