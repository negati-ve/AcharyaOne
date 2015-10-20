package com.example.jokerlol.acharyaone;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TimetableActivity extends AppCompatActivity {

    int sem,sec,currentdayint;
    LinearLayout linearLayout;
    String[][] showtimetable;
    float x1,x2;
    float y1, y2;
    private GestureDetector gestureDetector;
    ListView listdaysubjects;
    TextView holidaytimetable;
    String[] monthofyear = new String[] {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    String[] starttime = new String[] {"8:45","9:40","10:35","10:50","11:45","12:40","1:35","2:15","3:10","4:05"};
    String[] endtime = new String[] {"9:40","10:35","10:50","11:45","12:40","1:35","2:15","3:10","4:05","5:00"};

    arraytimetable att = new arraytimetable();
    TextView[] referenceofdays = new TextView[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        int i;
        Calendar calendar = Calendar.getInstance();
        final TextView currentday = (TextView) findViewById(R.id.calendertime);
        currentday.setText(calendar.get(Calendar.DAY_OF_MONTH) + "," + monthofyear[calendar.get(Calendar.MONTH)] + "," + calendar.get(Calendar.YEAR));
        listdaysubjects = (ListView) findViewById(R.id.listtimetable);
        holidaytimetable = (TextView) findViewById(R.id.holidaytimetable);
        referenceofdays[0] = (TextView) findViewById(R.id.sundaylist);
        referenceofdays[1] = (TextView) findViewById(R.id.mondaylist);
        referenceofdays[2] = (TextView) findViewById(R.id.tuesdaylist);
        referenceofdays[3] = (TextView) findViewById(R.id.wednesdaylist);
        referenceofdays[4] = (TextView) findViewById(R.id.thrusdaylist);
        referenceofdays[5] = (TextView) findViewById(R.id.fridaylist);
        referenceofdays[6] = (TextView) findViewById(R.id.saturdaylist);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        sem=getIntent().getIntExtra("sem", 3);
        sec=getIntent().getIntExtra("sec", 1);
        showtimetable = att.choosetimetable(sem, sec);
        currentdayint = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        displaytimetable(currentdayint);
        referenceofdays[0].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=0;
                        displaytimetable(currentdayint);
                    }
                }
        );
        referenceofdays[1].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=1;
                        displaytimetable(currentdayint);
                    }
                }
        );
        referenceofdays[2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=2;
                        displaytimetable(currentdayint);
                    }
                }
        );
        referenceofdays[3].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=3;
                        displaytimetable(currentdayint);
                    }
                }
        );
        referenceofdays[4].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=4;
                        displaytimetable(currentdayint);
                    }
                }
        );
        referenceofdays[5].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=5;
                        displaytimetable(currentdayint);
                    }
                }
        );
        referenceofdays[6].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentdayint=6;
                        displaytimetable(currentdayint);
                    }
                }
        );

    }

    public void displaytimetable(int pos) {
        int i,j;
        arraylistadaptertimetable adapter;
        ArrayList<ttobject> subjectstoshow = new ArrayList<ttobject>();
        if (pos == 0 || pos == 6) {
            listdaysubjects.setVisibility(View.GONE);
            holidaytimetable.setVisibility(View.VISIBLE);
            referenceofdays[pos].setTextColor(Color.WHITE);
            referenceofdays[pos].setBackgroundResource(R.color.background);
            for(i=0;i<7;i++){
                if(i!=currentdayint){
                    referenceofdays[i].setBackgroundResource(R.color.commonbackground);
                    referenceofdays[i].setTextColor(Color.BLACK);
                }
            }
        } else {
            listdaysubjects.setVisibility(View.VISIBLE);
            holidaytimetable.setVisibility(View.GONE);
            referenceofdays[pos].setTextColor(Color.WHITE);
            referenceofdays[pos].setBackgroundResource(R.color.background);
            for(i=0;i<7;i++){
                if(i!=currentdayint){
                    referenceofdays[i].setBackgroundResource(R.color.commonbackground);
                    referenceofdays[i].setTextColor(Color.BLACK);
                }
            }
            j=0;
            for (i=0;i<8;i++){
                if (i==2){
                    subjectstoshow.add(new ttobject(starttime[j],"TEA BREAK",endtime[j++]));
                }
                if (i==5){
                    subjectstoshow.add(new ttobject(starttime[j],"LUNCH BREAK",endtime[j++]));
                }
                if(showtimetable[pos-1][i]=="-"){

                }else{
                    subjectstoshow.add(new ttobject(starttime[j],fullform(showtimetable[pos-1][i]),endtime[j++]));
                }

            }
            adapter = new arraylistadaptertimetable(this,subjectstoshow);
            listdaysubjects.setAdapter(adapter);
        }
    }

    private void onLeftSwipe() {
        currentdayint--;
        if(currentdayint<0){
            currentdayint=6;
            displaytimetable(currentdayint);
        }
    }

    private void onRightSwipe() {
        currentdayint++;
        if(currentdayint>6){
            currentdayint=0;
            displaytimetable(currentdayint);
        }
    }


    public String fullform(String sub){
        switch (sub){
            case "M-III":
                return "Engineering Mathematics-III";
            case "EC":
                return "Electronic Circuits";
            case "LD":
                return "Logic Design";
            case "DMS":
                return "Discrete Mathematical Structures";
            case "DS":
                return "Data Structures";
            case "OOPS":
                return "Data StructuresObject Oriented Programming";
            case "M-IV":
                return "Engineering Mathematics-IV";
            case "GTC":
                return "Graph Theory & Combinatorics";
            case "DAA":
                return "Design & Analysis of Algorithms";
            case "UNIX":
                return "Unix & Shell Programming";
            case "MP":
                return "Microprocessors";
            case "CO":
                return "Computer Organization";
            case "SE":
                return "Software Engineering";
            case "SS":
                return "Systems Software";
            case "OS":
                return "Operating Systems";
            case "DBMS":
                return "Database Management Systems";
            case "CN-1":
                return "Computer Networks-I";
            case "FLAT":
                return "Formal Languages & Automata Theory";
            case "USP":
                return "Unix System Programming";
            case "CD":
                return "Compiler Design";
            case "CN-II":
                return "Computer Networks-II";
            case "CGV":
                return "Computer Graphics & Visualization";
            case "OR":
                return "Operations Research";
            case "SSYS":
                return "Signals & Systems";
            case "DC":
                return "Data Compression";
            case "PR":
                return "Pattern Recognition";
            case "SMA":
                return "Stochastic Models & Applications";
            case "PL":
                return "Programming Languages";
            case "OOMD":
                return "Object-Oriented Modeling & Design";
            case "ECS":
                return "Embedded Computing Systems";
            case "WEB":
                return "Programming the Web";
            case "ACA":
                return "Advanced Computer Architectures";
            case "ADMS":
                return "Advanced Database Management Systems ";
            case "DSP":
                return "Digital Signal Processing";
            case "JAVA":
                return "Java and J2EE";
            case "MC":
                return "Multimedia Computing";
            case "DWDM":
                return "Data Warehousing and Data Mining";
            case "NN":
                return "Neural Networks";
            case "C#":
                return "C# Programming and .Net";
            case "DIP":
                return "Digital Image Processing";
            case "GT":
                return "Game Theory";
            case "AI":
                return "Artificial Intelligence";
            case "SAN":
                return "Storage Area Networks";
            case "FL":
                return "Fuzzy Logic";
            case "SA":
                return "Software Architectures";
            case "SMS":
                return "System Modeling and Simulation";
            case "WNMC":
                return "Wireless Networks and Mobile Computing";
            case "WEB2":
                return "Web 2.0 and Rich Internet Applications";
            case "VLSI":
                return "VLSI Design and Algorithms";
            case "NMS":
                return "Network Management Systems";
            case "INS":
                return "Information and Network Security";
            case "MBS":
                return "Microcontroller-Based Systems";
            case "AN":
                return "Adhoc Networks";
            case "ST":
                return "Software Testing";
            case "ARM":
                return "ARM Based System Design";
            case "SOA":
                return "Services Oriented Architecture";
            case "CGC":
                return "Clouds, Grids and Clusters";
            case "MCAP":
                return "Multi-core Architecture and Programming";
            default:return sub;
        }
    }



}
