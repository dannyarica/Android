package example.danny.com.repasogeneral;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import example.danny.com.adapters.AdapterItem;
import example.danny.com.database.ItemDataAccess;
import example.danny.com.models.RepasoItem;

public class ListasActivity extends ListActivity {
    private ArrayList<RepasoItem> m_parts = new ArrayList<>();
    private Runnable viewParts;
    private AdapterItem adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        //adapter = new AdapterItem(this, R.layout.item_grilla, m_parts);
        //setListAdapter(adapter);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiInfo = connectivityManager.getActiveNetworkInfo();
        String name = wifiInfo.getTypeName();
        // here we are defining our runnable thread.
        viewParts = new Runnable(){
            public void run(){
                handler.sendEmptyMessage(0);
            }
        };

        Thread thread =  new Thread(null, viewParts, "MagentoBackground");
        thread.start();
    }

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {

            ItemDataAccess itemDataAccess = new ItemDataAccess();

            m_parts=itemDataAccess.getAll();

            adapter = new AdapterItem(ListasActivity.this, R.layout.item_grilla, m_parts);

            // display the list.
            setListAdapter(adapter);
            Toast.makeText(getApplicationContext(),"Hay " +  m_parts.size() + "Articulos", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onResume() {
        super.onResume();

    }
}
