package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class TimeTable extends Fragment {

    private OnFragmentInteractionListener mListener;
    Button showtimetable;
    RadioGroup radioGroup;
    Spinner spinner;
    int sem=0,sec=0;


    public TimeTable() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_table, container, false);
        showtimetable = (Button) view.findViewById(R.id.showtimetable);
        radioGroup = (RadioGroup) view.findViewById(R.id.section);
        spinner = (Spinner) view.findViewById(R.id.sem_spinner);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        showtimetable.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if(sec==0){
                            Toast.makeText(getActivity(), "Please select your section", Toast.LENGTH_SHORT).show();
                        }else{
                            String sample = Integer.toString(sem)+Integer.toString(sec);
                            if(sample.equals("41")||sample.equals("42")||sample.equals("43")||sample.equals("61")||sample.equals("62")||sample.equals("63")||sample.equals("81")||sample.equals("82")||sample.equals("83")||sample.equals("73")){
                                Toast.makeText(getActivity(), "Timetable not available", Toast.LENGTH_SHORT).show();
                            }else{
                                Intent intent = new Intent(getActivity(), TimetableActivity.class);
                                intent.putExtra("sem", sem);
                                intent.putExtra("sec",sec);
                                startActivity(intent);
                            }
                        }
                    }
                }
        );
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.A:
                                sec=1;
                                break;
                            case R.id.B:
                                sec=2;
                                break;
                            case R.id.C:
                                sec=3;
                                break;
                        }
                    }
                }
        );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.sem_details,R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new customspinneritemlistener());
        return view;
    }

    public class customspinneritemlistener implements AdapterView.OnItemSelectedListener{

        public customspinneritemlistener() {

        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sem = position + 3;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

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
