package com.malidielhadad.lasalle;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by malidielhadad on 25/04/2017.
 */

public class LasalleApp extends Application {


    private RequestQueue requestQueue;

    //Singleton
    private static LasalleApp sharedInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(this);

        LasalleApp.sharedInstance = this;

    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static LasalleApp getSharedInstance() {
        return sharedInstance;
    }
}
