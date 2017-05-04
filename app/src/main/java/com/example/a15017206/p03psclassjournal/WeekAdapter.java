package com.example.a15017206.p03psclassjournal;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017206 on 04/05/2017.
 */

public class WeekAdapter extends ArrayAdapter<Weeks> {

    private ArrayList<Weeks> weeks;
    private Context context;
    private TextView tvWeekNo;
    private  TextView tvGrade;

    public WeekAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Weeks> objects) {
        super(context, resource, objects);
        weeks = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.info_for_module_row, parent, false);

        // Get the TextView object - in row.xml
        tvWeekNo = (TextView) rowView.findViewById(R.id.tvWeekNo);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);

        Weeks currentWeek = weeks.get(position);

        tvWeekNo.setText(currentWeek.getWeekNo());
        tvGrade.setText(currentWeek.getWeekGrade());




        return rowView;
    }
}
