package com.example.a15017206.p03psclassjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddData extends AppCompatActivity {

    TextView tvDG;
    Button btnSubmit;
    ArrayAdapter aa;
    RadioGroup radioG;
    String score = "";
    ArrayList<Weeks> weeks;

    String weekNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        tvDG = (TextView) findViewById(R.id.tvDG);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        radioG = (RadioGroup) findViewById(R.id.radioG);

        Intent i = getIntent();
        weekNo = i.getStringExtra("weekNo");
        Toast.makeText(AddData.this, weekNo, Toast.LENGTH_SHORT).show();

        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                              @Override
                                              public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                                                  if (checkedId == R.id.radioButtonA) {
                                                      score = "A";
                                                  } else if (checkedId == R.id.radioButtonB) {
                                                      score = "B";
                                                  } else if (checkedId == R.id.radioButtonC) {
                                                      score = "C";
                                                  } else if (checkedId == R.id.radioButtonD) {
                                                      score = "D";
                                                  } else if (checkedId == R.id.radioButtonF) {
                                                      score = "F";
                                                  } else if (checkedId == R.id.radioButtonX) {
                                                      score = "X";
                                                  }

                                                  btnSubmit.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View v) {
                                                          Intent i = new Intent();
                                                          Toast.makeText(AddData.this, "score" + score, Toast.LENGTH_SHORT).show();
                                                          i.putExtra("score", score);
                                                          i.putExtra("weekNo", weekNo);
                                                          setResult(RESULT_OK, i);
                                                          finish();
                                                      }
                                                  });


                                              }

                                          }
        );

    }
}