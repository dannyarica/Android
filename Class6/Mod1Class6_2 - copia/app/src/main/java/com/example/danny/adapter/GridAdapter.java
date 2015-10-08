package com.example.danny.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danny.mod1class6_2.R;
import com.example.danny.models.Cupon;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DArica on 05/10/2015.
 */
public class GridAdapter extends ArrayAdapter<Cupon> {
    protected ImageLoader imageLoader= ImageLoader.getInstance();
    private Context _context;
    private ArrayList<Cupon> _cuponList;

    public GridAdapter(Context context,  ArrayList<Cupon> objects) {
        super(context, 0, objects);
        this._context = context;
        this._cuponList = objects;
    }

    static class ViewHolder{
        TextView lblTitle;
        ImageView ivProduct;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(_context).inflate(R.layout.item_grid,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.lblTitle = (TextView) convertView.findViewById(R.id.lblTitle);
            viewHolder.ivProduct = (ImageView) convertView.findViewById(R.id.ivProduct);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        Cupon item = _cuponList.get(position);
        viewHolder.lblTitle.setText(item.getTitle());
        imageLoader.displayImage(item.getUrl(),viewHolder.ivProduct);

        return convertView;
    }
}
