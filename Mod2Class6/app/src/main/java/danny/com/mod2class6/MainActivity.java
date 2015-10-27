package danny.com.mod2class6;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnObtener;
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObtener = (Button) findViewById(R.id.btnObtener);
        txtData = (TextView) findViewById(R.id.txtDatos);

        TelephonyManager phoneManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = phoneManager.getSimSerialNumber();

        String contenido = "";

        contenido += "Device" + Build.DEVICE + "\n";
        contenido += "Phone" + phoneNumber;
        txtData.setText(contenido);
    }
}
