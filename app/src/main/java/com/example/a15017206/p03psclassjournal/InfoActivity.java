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
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.id.message;

public class InfoActivity extends AppCompatActivity {
    Button btnInfo, btnEmail;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Weeks> weeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Get the intent
        Intent i = getIntent();

        // Get the Hero object first activity put in Intent
        Modules passedOverModule = (Modules) i.getSerializableExtra("forZongHua");

        String moduleCode = passedOverModule.getModuleCode();
        String moduleName = passedOverModule.getModuleName();

        //set title for others
        getSupportActionBar().setTitle("Info for " + moduleName);

        btnInfo = (Button) findViewById(R.id.infoButton);
        btnEmail = (Button) findViewById(R.id.emailButton);
        lv = (ListView) findViewById(R.id.lvInfo);

        weeks = new ArrayList<Weeks>();
        weeks.add(new Weeks("Week 1", "A"));
        weeks.add(new Weeks("Week 2", "C"));
        weeks.add(new Weeks("Week 3", "B"));


        aa = new WeekAdapter(this, R.layout.info_for_module_row, weeks);
        lv.setAdapter(aa);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg/Full_Time_Courses/04_Infocomm/Diploma_in_Mobile_Software_Development_(R47).aspx"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"15017082@myrp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Remarks so far");
                Toast.makeText(InfoActivity.this, "" + weeks.size(), Toast.LENGTH_SHORT).show();

                String message = "";
                message = "Hi faci, I am...\n";
                message += "Please see my remarks so far, thank you!";
                for (int i = 0; i < weeks.size(); i++) {

                    message += "" + weeks.get(i).getWeekNo() + ": DG: " + weeks.get(i).getWeekGrade()+ "\n";
                    email.putExtra(Intent.EXTRA_TEXT, message);
                }


                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

    }

}
