package com.example.danny.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danny.mod1class6_2.R;
import com.example.danny.models.Cupon;
import com.example.danny.utils.Constantes;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by DArica on 12/10/2015.
 */
public class DetalleFragment extends Fragment {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private ImageView imageView;
    private TextView lblTitulo;
    private TextView lblPrecio;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        imageView = (ImageView) view.findViewById(R.id.ivImagen);
        lblTitulo = (TextView) view.findViewById(R.id.lblTitulo);
        lblPrecio = (TextView)view.findViewById(R.id.lblPrecio);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle bundle = getArguments();

        if (bundle.containsKey("position")){
            int position = bundle.getInt("position");
            Cupon item = Constantes.cuponArrayList.get(position);
            lblTitulo.setText(item.getTitle());
            lblPrecio.setText("12");
            imageLoader.displayImage(item.getUrl(),imageView);
        }
    }
}
