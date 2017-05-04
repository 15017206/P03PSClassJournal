package com.example.a15017206.p03psclassjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddData extends AppCompatActivity {

    TextView tvDG;
    ImageView ivBook;
    Button btnSubmit;
    ArrayAdapter aa;
    ArrayList<Weeks> weeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        weeks = new ArrayList<Weeks>();
        tvDG = (TextView)findViewById(R.id.tvDG);
       for(int i = 0; i < weeks.size(); i++){
           tvDG.setText("Week" + i);
       }
    }

    public void onButtonClick(View v) {
        switch (v.getId()) {
                case R.id.radioButtonA:
                  // handle button A click;
                  btnSubmit.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {

                      }
                  });
                break;
                case R.id.radioButtonB:
                  // handle button B click;
                break;
            case R.id.radioButtonC:
                // handle button B click;
                break;
            case R.id.radioButtonD:
                // handle button B click;
                break;
            case R.id.radioButtonF:
                // handle button B click;
                break;
            case R.id.radioButtonX:
                // handle button B click;
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }
}
