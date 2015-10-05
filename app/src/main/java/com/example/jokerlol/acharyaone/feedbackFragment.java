package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class feedbackFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public feedbackFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        final EditText comment = (EditText) view.findViewById(R.id.comment);
        Button feedback = (Button) view.findViewById(R.id.feedback);
        final Context context = getActivity();
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        feedback.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(context.CONNECTIVITY_SERVICE);
                        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                        if (networkInfo!=null&&networkInfo.isConnectedOrConnecting()){
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"acharyaonecs@gmail.com"});
                            i.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK");
                            i.putExtra(Intent.EXTRA_TEXT   , comment.getText().toString());
                            try {
                                startActivity(i);
                            } catch (android.content.ActivityNotFoundException ex) {
                                Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getActivity(), "I don't think internet is available on your phone", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
