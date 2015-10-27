package danny.com.localizacion;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danny.com.utils.GpsTracker;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private LocationListener locationListener;
    private Button btnObtener;
    private EditText txtLongitud, txtLatitud;
    private GpsTracker gpsTracker;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObtener = (Button) findViewById(R.id.btnObtener);
        txtLatitud = (EditText) findViewById(R.id.txtLatitud);
        txtLongitud = (EditText)findViewById(R.id.txtLongitud);

        gpsTracker = new GpsTracker(MainActivity.this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        /*if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = gpsTracker.getLocation();
                if(gpsTracker.canGetLocation()){
                    txtLatitud.setText(String.valueOf(location.getLatitude()));
                    txtLongitud.setText(String.valueOf(location.getLongitude()));
                }else{
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        txtLatitud.setText(String.valueOf(location.getLatitude()));
        txtLongitud.setText(String.valueOf(location.getLongitude()));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
