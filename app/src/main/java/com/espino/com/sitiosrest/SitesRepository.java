package com.espino.com.sitiosrest;

import java.util.ArrayList;

/**
 * Created by espino on 9/02/17.
 */
public class SitesRepository {
    private ArrayList<Site> list;
    private static SitesRepository instance;

    public static SitesRepository getInstance() {
        if(instance == null)
            instance = new SitesRepository();

        return instance;
    }

    private SitesRepository() {
    }

    public ArrayList<Site> getList(){
        return list;
    }
    public void setList(ArrayList<Site> list){
        this.list = list;
    }

}
