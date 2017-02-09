package com.espino.com.sitiosrest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by espino on 9/02/17.
 */

public class NetworkController {

    public static final String APIREST = "https://andres.alumno.club/";

    private Context context;
    private INetworkView callback;

    public NetworkController(Context context){
        this.context = context;
        callback = (INetworkView) context;
    }

    public void getAll(){
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, APIREST + "sites", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            SitesRepository.getInstance().setList(Analyze.analyzeSites(response));
                        } catch (JSONException e) {
                            Log.e("JsonException", e.getMessage());
                            Toast.makeText(context,"Ha ocurrido un error",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HTTP-GET ERROR", error.getMessage());
                        Toast.makeText(context,"Ha ocurrido un error",Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(jsonRequest);

        jsonRequest.setTag(VolleySingleton.TAG);
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(3000, 1, 1));

    }

    public void get(){

    }

    public void post(){

    }

    public void put(){

    }

    public void delete(){

    }
}
