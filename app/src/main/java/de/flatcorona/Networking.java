package de.flatcorona;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Networking {

    private static Networking instance;
    private Context context;
    private RequestQueue requestQueue;

    private Networking(Context context){
        this.context = context.getApplicationContext();
    }

    public static synchronized Networking getInstance(Context context){
        if(instance == null){
            instance = new Networking(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null){
            // TODO: verify caching is handled correctly (use explicit constructor with NoCache?)
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    /**
     * Shorthand to add a request directly to the request queue without getting the request queue first.
     * @param req Request to add
     * @param <T> Request type
     */
    public <T> void addRequest(Request req){
        getRequestQueue().add(req);
    }
}
