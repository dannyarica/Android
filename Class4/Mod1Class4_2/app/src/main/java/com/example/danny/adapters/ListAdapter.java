package com.example.danny.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.danny.mod1class4_2.R;
import com.example.danny.models.Contact;

import java.util.ArrayList;

/**
 * Created by DArica on 30/09/2015.
 */
public class ListAdapter extends BaseAdapter {

    private Context _context;
    private ArrayList<Contact> _contactArrayList;

    public ListAdapter(Context context, ArrayList<Contact> contactArrayList){
        _context = context;
        _contactArrayList = contactArrayList;
    }
    @Override
    public int getCount() {
        return _contactArrayList.size();
    }

    @Override
    public Contact getItem(int position) {
        return _contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(_context).inflate(R.layout.item_list, parent,false);
            //ViewHolder.SetIntance(convertView);
            //convertView.setTag();
        }
        TextView lblName = (TextView)convertView.findViewById(R.id.lblName);
        TextView lblLastName = (TextView)convertView.findViewById(R.id.lblLastName);
        TextView lblAge = (TextView)convertView.findViewById(R.id.lblAge);

        Contact myContact = getItem(position);
        lblName.setText(myContact.getName());
        lblLastName.setText(myContact.getLastName());
        lblAge.setText(String.valueOf(myContact.getAge()));

        return convertView;
    }
}
