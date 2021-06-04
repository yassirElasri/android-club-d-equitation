package com.example.projet_mobil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SeanceAdapter extends ArrayAdapter<Seance> {
    public SeanceAdapter(@NonNull Context context, @NonNull List<Seance> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View newItem;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        newItem = layoutInflater.inflate(R.layout.seance_item, parent, false);
        TextView startDate = newItem.findViewById(R.id.startDateText);
        TextView duration = newItem.findViewById(R.id.durationText);
        startDate.setText(getItem(position).getStartDate());
        duration.setText(getItem(position).getDuration() +" min");
        if(getItem(position).getIsDone() == 1)
            newItem.setBackgroundResource(R.drawable.rounded_corners_lightgreen);
        else
            newItem.setBackgroundResource(R.drawable.rounded_corners_lightred);

        return newItem;
    }
}
