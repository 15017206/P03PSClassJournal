package com.example.a15017206.p03psclassjournal;

import android.content.Context;
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

public class ModuleAdapter extends ArrayAdapter<Modules> {
    private ArrayList<Modules> modules;
    private Context context;
    private TextView tvModuleCode;

    public ModuleAdapter(Context context, int resource, ArrayList<Modules> objects) {
        super(context, resource, objects);
        modules = objects;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row_activity1_listview, parent, false);

        // Get the TextView object - in row.xml
        tvModuleCode = (TextView) rowView.findViewById(R.id.tvRowTemplate);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Modules currentModule = modules.get(position);
        // Set the TextView to show the food
        tvModuleCode.setText(currentModule.getModuleCode());

        return rowView;
//        return super.getView(position, convertView, parent);
    }
}
