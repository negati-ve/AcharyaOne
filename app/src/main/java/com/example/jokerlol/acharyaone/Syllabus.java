package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Syllabus extends Fragment {

    private OnFragmentInteractionListener mListener;
    Spinner spinner , spinner2;
    View view;
    Button gotobooks,gotosyllabus;
    int pos1 = 999 , pos2 = 999 ;
    ArrayAdapter<String> adapter1 , adapter2,adapter3,adapter4,adapter5,adapter6,adapter7,adapter8 ;

    public Syllabus() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_syllabus, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        gotobooks = (Button) view.findViewById(R.id.button2);
        gotosyllabus = (Button) view.findViewById(R.id.button);
        String[] sems = {"sem", "3rd" ,"4th" , "5th" , "6th" , "7th" , "8th" };
        String[] subs = {"Subs" ,};
        String[] sub3 = {"Subs" ,"M3" , "EC" , "LD" , "DMS" , "DS" , "OOP" , "DSL" , "ECL"};
        String[] sub4 = {"Subs" ,"M4" , "GTC" , "DAA" , "USP" , "MP" , "CO" , "DLAB" , "MLAB"};
        String[] sub5 = {"Subs" ,"SE" , "SS" , "OS" , "DBMS" , "CN1" , "FLAT" , "SSL" , "DBL"};
        String[] sub6 = {"Subs" ,"M&E" , "USP" , "CD" , "CN2" , "CG" , "OR","S&S","DC","PR","SMA","PL" , "CGL" , "USPL"};
        String[] sub7 = {"Subs" ,"oomd" , "ECS" , "WEB" , "ACA" , "JAVA" , "C#" , "WEBL" , "LAB"};
        String[] sub8 = {"Subs" ,"SA" , "SMS" , "WN" , "W2.0" , "VLSI" , "NMS" , "INS" ,"MBS","AN", "ST","ABSD" ,"SOA" ,"CGC" ,"MAP" };
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner2.setEnabled(false);
        adapter1 = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_spinner_dropdown_item, sems);
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , subs);
        adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , sub3);
        adapter4 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , sub4);
        adapter5 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , sub5);
        adapter6 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , sub6);
        adapter7 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , sub7);
        adapter8 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , sub8);

        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new custom());
        spinner2.setAdapter(adapter2);
        gotobooks.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if( pos1 == 0 || pos2 == 0){
                            if(pos1 == 0)
                                Toast.makeText(getActivity().getBaseContext() , "Please select a semester" , Toast.LENGTH_LONG).show();
                            else if (pos2 == 0)
                                Toast.makeText(getActivity().getBaseContext(), "Please select a Subject", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(getActivity().getBaseContext()  , "Please select a Semester and Subject" , Toast.LENGTH_LONG).show();

                        }
                        else if(pos1 == 1 || pos1 == 2 || pos1 == 3 || pos1 == 5) {
                            if (pos2 == 7 || pos2 == 8)
                                Toast.makeText(getActivity(), "No Prescribed TextBooks for Labs ", Toast.LENGTH_LONG).show();

                            else
                                toshow();
                        }
                        else if (pos1 == 4 ) {
                            if (pos2 == 12 || pos2 == 13)
                                Toast.makeText(getActivity(), "No Prescribed TextBooks for Labs ", Toast.LENGTH_LONG).show();
                            else
                                toshow();
                        }
                        else
                            toshow();
                    }
                });
        gotosyllabus.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if (pos1 == 0 || pos2 == 0) {
                            if (pos1 == 0)
                                Toast.makeText(getActivity().getBaseContext(), "Please select a semester", Toast.LENGTH_LONG).show();
                            else if (pos2 == 0)
                                Toast.makeText(getActivity().getBaseContext(), "Please select a Subject", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(getActivity().getBaseContext(), "Please select a Semester and Subject", Toast.LENGTH_LONG).show();
                        } else {
                            Intent i = new Intent(getActivity(), Subshower.class);
                            i.putExtra("FIRST", pos1);
                            i.putExtra("SECOND", pos2);
                            Context context = getActivity();
                            SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("current", "syllabus");
                            editor.commit();
                            startActivity(i);
                        }
                    }
                });
        return view;
    }

    public class custom implements AdapterView.OnItemSelectedListener{

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            int posi = spinner.getSelectedItemPosition();
            pos1 = posi;
            TextView textView = (TextView) view.findViewById(R.id.textView);
            switch (posi){
                case 0 : spinner2.setEnabled(false);spinner2.setAdapter(adapter2); letsgo();break;
                default: Thissubject(posi); break;
            }


        }
    }

    public void Thissubject(int posti){
        spinner2.setEnabled(true);
        switch (posti){
            case 1 : spinner2.setAdapter(adapter3); letsgo();break;
            case 2 : spinner2.setAdapter(adapter4); letsgo();break;
            case 3 : spinner2.setAdapter(adapter5); letsgo();break;
            case 4 : spinner2.setAdapter(adapter6); letsgo();break;
            case 5 : spinner2.setAdapter(adapter7); letsgo();break;
            case 6 : spinner2.setAdapter(adapter8); letsgo();break;
        }

    }
    public void letsgo(){
        spinner2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                        pos2 = position;

                    }
                }
        );
    }

    public void toshow(){
        Intent i = new Intent(getActivity() , Subshower.class);
        i.putExtra("FIRST" , pos1);
        i.putExtra("SECOND" , pos2+20);
        Context context = getActivity();
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("current", "syllabus");
        editor.commit();
        startActivity(i);
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
