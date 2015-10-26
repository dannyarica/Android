package pe.tutrago.dataaccess.gateway;

import android.util.Base64;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHeaders;
import pe.tutrago.models.User;
import pe.tutrago.shared.EndPoints;

/**
 * Created by DArica on 24/10/2015.
 */

public class AuthenticateGateway {

    private static AsyncHttpClient client = new AsyncHttpClient();

/*    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return EndPoints.APISERCICES_AUTHENTICATE_LOGIN + relativeUrl;
    }*/

    public AuthenticateGateway() {

    }

    public User Login(String userName, String password) {
        User userLogged = null;

        String userPwd = userName + ":" + password;
        byte[] data = userPwd.getBytes();
        String encode64 = Base64.encodeToString(data, Base64.NO_WRAP);
        client.setAuthenticationPreemptive(true);
        client.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + encode64);


        RequestHandle requestHandle = client.post(EndPoints.APISERVICES_AUTHENTICATE_LOGIN, new RequestParams(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                User userLogged = new User();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                int koky = 0;
            }

        });

        if (!requestHandle.isFinished()){

        }

        return null;
    }
}
