package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Home extends Fragment {

    int day;
    TextView textView,textView1,textView2;
    int sem,sec;
    Button again;
    String name;
    View view;
    SimpleDateFormat sdf;
    Calendar calendar;
    String[][] timetable;
    Date start,headstart,period1end,period2end,teabreakend,period3end,period4end,period5end,lunchbreakend,period6end,period7end,period8end,mid,night;
    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        Context context = getActivity();
        textView = (TextView) view.findViewById(R.id.mycurrentperiod);
        textView1 = (TextView) view.findViewById(R.id.myname);
        textView2 = (TextView) view.findViewById(R.id.mynextperiod);
        again = (Button) view.findViewById(R.id.check);
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        sem=sharedPreferences.getInt("sem",3);
        sec=sharedPreferences.getInt("sec",3);
        name = sharedPreferences.getString("name","you");
        textView1.setText("Hi,"+name);
        arraytimetable att = new arraytimetable();
        timetable = att.choosetimetable(sem,sec);
        sdf = new SimpleDateFormat("HH:mm");
        try{
            mid = sdf.parse("23:59");
            headstart = sdf.parse("06:45");
            start = sdf.parse("08:45");
            period1end = sdf.parse("09:40");
            period2end = sdf.parse("10:35");
            teabreakend = sdf.parse("10:50");
            period3end = sdf.parse("11:45");
            period4end = sdf.parse("12:40");
            period5end = sdf.parse("13:35");
            lunchbreakend = sdf.parse("14:15");
            period6end = sdf.parse("15:10");
            period7end = sdf.parse("16:05");
            period8end = sdf.parse("17:00");
            night = sdf.parse("22:00");
        }catch (ParseException e){
            textView.setText("ERROR");
        }
        refresh();
        again.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        refresh();
                        Toast.makeText(getActivity(), "I have checked the TimeTable", Toast.LENGTH_SHORT).show();
                    }
                });
        return view;
    }

    public void refresh(){
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);
        if(day==1||day==7){
            textView.setText("have fun you don't have college today");

        }else{
            String currenttime=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);
            String currentperiod="",nextperiod="";
            Date currenttimedate;
            boolean then=false;
            try {
                currenttimedate = sdf.parse(currenttime);
                if (currenttimedate.before(headstart)) {
                    currentperiod="Sleep tight";
                    then=true;
                } else if (currenttimedate.before(start)) {
                    currentperiod="Get ready for college";
                    nextperiod="and you have "+timetable[day - 2][0]+" next";
                } else if (currenttimedate.before(period1end)) {
                    currentperiod="now you have "+timetable[day - 2][0];
                    nextperiod="and you have "+timetable[day - 2][1]+" next";
                } else if (currenttimedate.before(period2end)) {
                    currentperiod="now you have "+timetable[day - 2][1];
                    nextperiod="and you have Tea Break next";
                } else if (currenttimedate.before(teabreakend)) {
                    currentperiod="now you have Tea Break";
                    nextperiod="and you have "+timetable[day - 2][2]+" next";
                } else if (currenttimedate.before(period3end)) {
                    currentperiod="now you have "+timetable[day - 2][2];
                    nextperiod="and you have "+timetable[day - 2][3]+" next";
                } else if (currenttimedate.before(period4end)) {
                    currentperiod="now you have "+timetable[day - 2][3];
                    nextperiod="and you have "+timetable[day - 2][4]+" next";
                } else if (currenttimedate.before(period5end)) {
                    currentperiod="now you have "+timetable[day - 2][4];
                    nextperiod="and you have Lunch Break next";
                } else if (currenttimedate.before(lunchbreakend)) {
                    currentperiod="now you have Lunch Break";
                    if (timetable[day - 2][5].equals("-")) {
                        nextperiod="and it looks like you don't have any class next";
                    }else {
                        nextperiod="and you have "+timetable[day - 2][5]+" next";
                    }
                } else if (currenttimedate.before(period6end)) {
                    if (timetable[day - 2][5].equals("-")) {
                        currentperiod="it looks like you don't have any class now";
                    }else {
                        currentperiod="now you have "+timetable[day - 2][5];
                    }
                    if (timetable[day - 2][6].equals("-")) {
                        nextperiod="and it looks like you don't have any class next";
                    }else {
                        nextperiod="And you have "+timetable[day - 2][6]+" next";
                    }
                } else if (currenttimedate.before(period7end)) {
                    if (timetable[day - 2][6].equals("-")) {
                        currentperiod="it looks like you don't have any class now";
                    }else {
                        currentperiod="now you have "+timetable[day - 2][6];
                    }
                    if (timetable[day - 2][7].equals("-")) {
                        nextperiod="and it looks like you don't have any class next";
                    }else {
                        nextperiod="And you have "+timetable[day - 2][7]+" next";
                    }
                } else if (currenttimedate.before(period8end)) {
                    if (timetable[day - 2][7].equals("-")) {
                        currentperiod="it looks like you don't have any class now";
                    }else {
                        currentperiod="now you have "+timetable[day - 2][7];
                    }
                    then=true;
                } else if (currenttimedate.before(night)) {
                    currentperiod="college is over have fun";
                    then=true;
                } else if (currenttimedate.after(night)||currenttimedate.equals(night)) {
                    currentperiod="good night";
                    then=true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            if (then){
                textView.setText(currentperiod);
                textView2.setText("");
            }else {
                textView.setText(currentperiod);
                textView2.setText(nextperiod);
            }

        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }


}
