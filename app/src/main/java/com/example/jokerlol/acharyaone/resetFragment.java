package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class resetFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    Button remember;
    RadioGroup radioGroup;
    Spinner spinner;
    int sem=0,sec=0;
    EditText editText;

    public resetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset, container, false);
        remember = (Button) view.findViewById(R.id.remember_reset);
        radioGroup = (RadioGroup) view.findViewById(R.id.section_reset);
        spinner = (Spinner) view.findViewById(R.id.sem_spinner_reset);
        editText = (EditText) view.findViewById(R.id.name_reset);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        remember.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        if(sec==0){
                            Toast.makeText(getActivity(), "Tell me your section buddy", Toast.LENGTH_SHORT).show();
                        }else if(editText.getText().toString().equals("")){
                            Toast.makeText(getActivity(), "Don't be shy tell me your name", Toast.LENGTH_SHORT).show();
                        }else if (sem==4||sem==6||sem==8){
                            Toast.makeText(getActivity(), "Select odd semester", Toast.LENGTH_SHORT).show();
                        } else if(sec==3&&sem==7){
                            Toast.makeText(getActivity(), "Dude i don't think 7th sem has C section", Toast.LENGTH_SHORT).show();
                        }else{
                            Context context = getActivity();
                            SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("check",true);
                            editor.putInt("sem", sem);
                            editor.putInt("sec",sec);
                            editor.putString("name", editText.getText().toString());
                            editor.commit();
                            Toast.makeText(getActivity(), "Got it buddy", Toast.LENGTH_SHORT).show();
                            Fragment fragment = new Home();
                            getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
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
        return  view;
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
