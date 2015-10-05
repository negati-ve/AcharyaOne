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
import android.widget.ListAdapter;
import android.widget.ListView;


public class Faculty extends Fragment {

    private OnFragmentInteractionListener mListener;
    int posi ;

    public Faculty() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        Getinfo obj = new Getinfo();
        String[] teacher = obj.getnames();
        ListView lister = (ListView) view.findViewById(R.id.listView);
        ListAdapter la = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_list_item_1 , teacher);
        lister.setAdapter(la);
        lister.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        posi = position;
                        Intent i = new Intent(getActivity(), infoscreen.class);
                        i.putExtra("Thisisposition" , position);
                        Context context = getActivity();
                        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("current","faculty");
                        editor.commit();
                        startActivity(i);
                    }
                }
        );
        return view;
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
