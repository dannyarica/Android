package example.danny.com.repasogeneral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.danny.com.database.ItemDataAccess;
import example.danny.com.models.RepasoItem;

public class MainActivity extends AppCompatActivity {

    final String[] spinnerValues = {"Seleccione", "0-10", "10-100", "100-500", "500-más"};
    ArrayAdapter<String> spinnerArrayAdapter = null;
    @Bind(R.id.txtTitulo)
    EditText _txtTitulo;

    @Bind(R.id.txtDescripcion)
    EditText _txtDescripcion;

    @Bind(R.id.cboRango)
    Spinner _cboRango;

    @Bind(R.id.btnRegistrar)
    Button _btnRegistrar;

    @Bind(R.id.btnListar)
    Button _btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        spinnerArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, spinnerValues);
        _cboRango.setAdapter(spinnerArrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        _btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar_click();
            }
        });

        _btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar_click();
            }
        });
    }

    private void registrar_click() {
        if (!validar()) {
            Toast.makeText(getApplicationContext(), "Por favor llene todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }
        ItemDataAccess itemDataAccess = new ItemDataAccess();
        RepasoItem repasoItem = new RepasoItem();
        repasoItem.set_titulo(_txtTitulo.getText().toString());
        repasoItem.set_descripcion(_txtDescripcion.getText().toString());
        repasoItem.set_rango(_cboRango.getSelectedItem().toString());
        itemDataAccess.insertItem(repasoItem);

        Toast.makeText(getApplicationContext(), "Articulo Registrado",Toast.LENGTH_SHORT).show();
        //Clean Up Controls
        _txtTitulo.setText("");
        _txtDescripcion.setText("");
    }

    private void listar_click(){
        Intent listarIntent = new Intent(MainActivity.this, ListasActivity.class);
        startActivity(listarIntent);
    }


    private Boolean validar() {
        String titulo = _txtTitulo.getText().toString();
        String descripcion = _txtDescripcion.getText().toString();

        if (titulo.isEmpty() || descripcion.isEmpty()) {
            return false;
        }

        if (_cboRango.getSelectedItemPosition() == 0) {
            return false;
        }
        return true;
    }
}