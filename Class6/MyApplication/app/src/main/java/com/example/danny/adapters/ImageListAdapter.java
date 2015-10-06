package com.example.danny.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danny.mod1class6.R;
import com.example.danny.models.Images;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by DArica on 05/10/2015.
 */
public class ImageListAdapter extends BaseAdapter {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private Context _context;
    private ArrayList<Images> _imagesList;

    public ImageListAdapter(Context context, ArrayList<Images> imagesList) {
        this._context = context;
        this._imagesList = imagesList;
    }

    @Override
    public int getCount() {
        return _imagesList.size();
    }

    @Override
    public Object getItem(int position) {
        return _imagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _imagesList.get(position).getId();
    }

    static class ViewHolder {
        TextView lblTitle, lblContent, lblDateTime;
        ImageView imvPicture;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(_context).inflate(R.layout.item_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblTitle = (TextView) convertView.findViewById(R.id.lblTitle);
            viewHolder.lblContent = (TextView) convertView.findViewById(R.id.lblContent);
            viewHolder.lblDateTime = (TextView) convertView.findViewById(R.id.lblDateTime);
            viewHolder.imvPicture = (ImageView) convertView.findViewById(R.id.imvPicture);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Images item = (Images) getItem(position);
        viewHolder.lblTitle.setText(item.getTitle());
        viewHolder.lblContent.setText(item.getContent());
        viewHolder.lblDateTime.setText(item.getDate());

        if (item.getUrlImage().length()>0){
            imageLoader.displayImage(item.getUrlImage(), viewHolder.imvPicture);
            viewHolder.imvPicture.setVisibility(View.VISIBLE);
        }else {
            viewHolder.imvPicture.setVisibility(View.GONE);
        }
        return convertView;
    }
}
