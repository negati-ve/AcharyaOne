package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class About extends Fragment {

    private OnFragmentInteractionListener mListener;
    MediaPlayer md1  , md2 ;

    public About() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_about, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        ImageView img1 , img2 , img3 , img4;
        md1 = MediaPlayer.create(getActivity() , R.raw.king);
        md2 = MediaPlayer.create(getActivity(), R.raw.bat);
        img1 = (ImageView) view.findViewById(R.id.imageView);
        img2 = (ImageView) view.findViewById(R.id.imageView2);
        img3 = (ImageView) view.findViewById(R.id.imageView3);
        img4 = (ImageView) view.findViewById(R.id.imageView4);
        img1.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View view){
                        mang(0 );
                    }
                }
        );
        img2.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View view){
                        mang(1);
                    }
                }
        );
        img4.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View view){
                        String nph = "tel:+918892434667";
                        Intent i = new Intent(Intent.ACTION_DIAL , Uri.parse(nph));
                        startActivity(i);
                    }
                }
        );
        img3.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View view){
                        String nph = "tel:+917676550018";
                        Intent i = new Intent(Intent.ACTION_DIAL , Uri.parse(nph));
                        startActivity(i);
                    }
                }
        );
        return view;
    }

    public void mang(int a ){
        if(a ==0){
            if(!md1.isPlaying()){
                playbatman();
            }
        }
        if(a==1)
            if(!md2.isPlaying())
                playbarb();
    }
    public void playbarb(){
        if(md1.isPlaying()){
            md1.release();
            md1 = MediaPlayer.create(getActivity() , R.raw.king);
            md1.start();
        }
        else
            md1.start();

    }
    public void playbatman(){
        if(md2.isPlaying()){
            md2.release();
            md2 = MediaPlayer.create(getActivity() , R.raw.bat);
            md2.start();
        }
        else
            md2.start();
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

    @Override
    public void onPause() {
        super.onPause();
    }


}
