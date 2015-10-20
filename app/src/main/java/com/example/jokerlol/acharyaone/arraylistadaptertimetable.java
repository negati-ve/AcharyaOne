package com.example.jokerlol.acharyaone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joker LOL on 10/16/2015.
 */
public class arraylistadaptertimetable extends ArrayAdapter<ttobject> {

    public arraylistadaptertimetable(Context context, ArrayList<ttobject> subjects) {
        super(context,R.layout.custom_list_view_time_table, subjects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customview = inflater.inflate(R.layout.custom_list_view_time_table, parent, false);
        ttobject tto = getItem(position);
        TextView starttime = (TextView) customview.findViewById(R.id.starttimetimetable);
        TextView endtime = (TextView) customview.findViewById(R.id.endtimetimetable);
        TextView showsubject = (TextView) customview.findViewById(R.id.subjecttimetable);
        starttime.setText(tto.getStarttime());
        endtime.setText(tto.getEndtime());
        showsubject.setText(tto.getSubject());
        return customview;
    }
}
