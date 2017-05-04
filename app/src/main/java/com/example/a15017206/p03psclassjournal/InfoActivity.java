package com.example.a15017206.p03psclassjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    Button btnInfo;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Info> modules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().setTitle("Info for C347");

        btnInfo = (Button) findViewById(R.id.infoButton);
        lv=(ListView)findViewById(R.id.lvInfo);

        LayoutInflater myinflater = getLayoutInflater();
        ViewGroup myHeader = (ViewGroup)myinflater.inflate(R.layout.activity_info, lv, false);
        lv.addHeaderView(myHeader, null, false);


        modules = new ArrayList<Info>();
        modules.add(new Info("B", true));
        modules.add(new Info("C", true));
        modules.add(new Info("A", true));



        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

    }

}
