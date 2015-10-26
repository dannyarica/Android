package example.danny.com.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DArica on 21/10/2015.
 */
public class RepasoItem {
    private String _titulo;
    private String _descripcion;
    private String _rango;
    private String _url;

    public RepasoItem(String _titulo, String _descripcion, String _rango, String _url) {
        this._titulo = _titulo;
        this._descripcion = _descripcion;
        this._rango = _rango;
        this._url = _url;
    }

    public RepasoItem(JSONObject object){
        try {
            this._titulo = object.getString("titulo");
            this._descripcion= object.getString("descripcion");
            this._rango= object.getString("rango");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public RepasoItem() {
    }

    public String get_titulo() {
        return _titulo;
    }

    public void set_titulo(String _titulo) {
        this._titulo = _titulo;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String get_rango() {
        return _rango;
    }

    public void set_rango(String _rango) {
        this._rango = _rango;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
