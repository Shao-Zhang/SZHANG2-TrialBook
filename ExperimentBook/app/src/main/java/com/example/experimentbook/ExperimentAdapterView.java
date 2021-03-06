package com.example.experimentbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExperimentAdapterView extends ArrayAdapter<Experiment> {
    private Context context;

    public ExperimentAdapterView(@NonNull Context context, @NonNull ArrayList<Experiment> experiments) {
        super(context, 0, experiments);
        this.context = context;

    }

    // Reference from @301TA
    // Lab03
    // https://eclass.srv.ualberta.ca/pluginfile.php/6713985/mod_resource/content/1/Lab%203%20instructions%20-%20CustomList.pdf
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        String name = getItem(position).getName();
        String date = getItem(position).getDate();
        String description = getItem(position).getDescription();

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_view_layout, parent, false);
        }

        TextView experimentName = view.findViewById(R.id.expName);
        TextView experimentDate = view.findViewById(R.id.expDate);
        TextView experimentDescription = view.findViewById(R.id.expDescription);

        experimentName.setText(name);
        experimentDate.setText(date);
        experimentDescription.setText(description);


        return view;
    }
}
