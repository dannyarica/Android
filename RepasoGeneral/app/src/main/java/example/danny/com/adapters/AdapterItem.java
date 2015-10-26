package example.danny.com.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.danny.com.models.RepasoItem;
import example.danny.com.repasogeneral.R;

/**
 * Created by DArica on 21/10/2015.
 */
public class AdapterItem extends ArrayAdapter<RepasoItem> {

    // View lookup cache
    private static class ViewHolder {
        TextView titulo;
        TextView descripcion;
        TextView rango;
    }

    public AdapterItem(Context context, int resource, ArrayList<RepasoItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            //LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //v = inflater.inflate(R.layout.item_grilla, null);

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_grilla, null);
            viewHolder.titulo = (TextView) convertView.findViewById(R.id.lblTitulo);
            viewHolder.descripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            viewHolder.rango = (TextView) convertView.findViewById(R.id.lblRango);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        RepasoItem i = getItem(position);

        if (i != null) {
            viewHolder.titulo.setText(i.get_titulo());
            viewHolder.descripcion.setText(i.get_descripcion());
            viewHolder.rango.setText(i.get_rango());
        }
        return convertView;
    }
}
