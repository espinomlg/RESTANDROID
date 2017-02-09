package com.espino.com.sitiosrest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements INetworkView{

    private ListView list;
    private TextView empty;
    private ProgressDialog dialog;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(android.R.id.list);
        empty = (TextView) findViewById(android.R.id.empty);

        NetworkController controller = new NetworkController(MainActivity.this);
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Conectando...");
        dialog.show();
    }

    @Override
    public void onFinish(){
        dialog.dismiss();
        adapter = new Adapter(MainActivity.this);
        list.setAdapter(adapter);
    }
}
