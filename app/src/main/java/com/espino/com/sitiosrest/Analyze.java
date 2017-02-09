package com.espino.com.sitiosrest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by espino on 9/02/17.
 */

public class Analyze {

    public static ArrayList<Site> analyzeSites(JSONObject response) throws JSONException{
        ArrayList<Site> list = new ArrayList<>();
        Site site = new Site();
        if(response.getBoolean("code")){
            JSONArray sites = response.getJSONArray("sites");

            for(int i = 0; i < sites.length(); i++){
                JSONObject item = sites.getJSONObject(i);
                site.setId(String.valueOf(item.getString("id")));
                site.setName(String.valueOf(item.getString("name")));
                site.setLink(String.valueOf(item.getString("link")));
                site.setEmail(String.valueOf(item.getString("email")));
                list.add(site);
                site = new Site();
            }
        }else
            list = null;

        return list;
    }
}
