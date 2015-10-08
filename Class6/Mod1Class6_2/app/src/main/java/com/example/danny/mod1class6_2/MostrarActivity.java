package com.example.danny.mod1class6_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danny.helper.Constantes;
import com.example.danny.models.Cupon;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by darica on 07/10/2015.
 */
public class MostrarActivity extends Activity {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private ImageView imageView;
    private TextView lblTitulo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        imageView = (ImageView)findViewById(R.id.ivImagen);
        lblTitulo = (TextView)findViewById(R.id.lblTitulo);

        if (getIntent().hasExtra("position")){
            int position = getIntent().getIntExtra("position",-1);
            Cupon item = Constantes.cuponArrayList.get(position);
            imageLoader.displayImage(item.getUrl(),imageView);
            lblTitulo.setText(item.getTitle());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}