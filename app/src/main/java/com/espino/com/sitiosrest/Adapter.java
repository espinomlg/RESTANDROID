package com.espino.com.sitiosrest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by espino on 9/02/17.
 */

public class Adapter extends ArrayAdapter<Site> {


    public Adapter(Context context) {
        super(context, R.layout.listitem_site, SitesRepository.getInstance().getList());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_site,parent,false);

            holder.name = (TextView) convertView.findViewById(R.id.siteitem_name);
            convertView.setTag(holder);
        }
        else
            holder = (Holder) convertView.getTag();

        holder.name.setText(getItem(position).getName());

        return convertView;
    }

    private static class Holder{
        private TextView name;
    }
}
