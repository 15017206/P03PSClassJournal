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
        module.add(new Modules("C302", "Web Services"));
        module.add(new Modules("C347", "Android Programming II"));

        //Link activity row.xml to this
        aa = new ModuleAdapter(this, R.layout.row_activity1_listview, module);
        lv1.setAdapter(aa);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Modules selectedModule = module.get(position);

                Toast.makeText(MainActivity.this, ""+selectedModule.getModuleCode(), Toast.LENGTH_SHORT).show();
                String sendOverModuleCode = selectedModule.getModuleCode();
                String sendOverModuleName = selectedModule.getModuleName();

                Modules selectedModule2 = new Modules(sendOverModuleCode, sendOverModuleName);

                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("forZongHua", selectedModule2);

                startActivityForResult(i, requestCodeForModule);

            }
        });
    }
}
