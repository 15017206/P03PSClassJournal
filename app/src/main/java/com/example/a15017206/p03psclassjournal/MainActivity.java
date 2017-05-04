package com.example.a15017206.p03psclassjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int requestCodeForModule = 1;

    ListView lv1;
    ArrayAdapter aa;
    ArrayList<Modules> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById(R.id.lv1);

        //Create modules in Modules array
        module = new ArrayList<Modules>();
        module.add(new Modules("c300"));

        //Link activity row.xml to this
        aa = new ModuleAdapter(this, R.layout.row_activity1_listview, module);
        lv1.setAdapter(aa);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Modules selectedModule = module.get(position);

                Toast.makeText(MainActivity.this, ""+selectedModule.getModuleCode(), Toast.LENGTH_SHORT).show();
                String sendOver = selectedModule.getModuleCode();

                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("forZongHua", sendOver);

                startActivityForResult(i, requestCodeForModule);

            }
        });
    }
}
