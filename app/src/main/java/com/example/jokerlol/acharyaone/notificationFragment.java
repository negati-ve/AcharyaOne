package com.example.jokerlol.acharyaone;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class notificationFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView notification;
    Button againbutton;
    public static final String TAG = "abhi&neel";
    StringRequest stringRequest;
    RequestQueue queue;

    public notificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        Context context = getActivity();
        notification = (TextView) view.findViewById(R.id.notification);
        againbutton = (Button) view.findViewById(R.id.againbutton);
        notification.setMovementMethod(new ScrollingMovementMethod());
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==false){
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        again();
        againbutton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        again();
                    }
                });
        return  view;
    }

    public void again(){
        Context context = getActivity();
        ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnectedOrConnecting()){
            queue = Volley.newRequestQueue(getActivity());
            String url ="https://acharyaonecs.wordpress.com";
            stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            notification.setText(""+ response.substring(response.indexOf("***")+3,response.indexOf("***",response.indexOf("***")+3)));
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    notification.setText("That didn't work!");
                }
            });
            stringRequest.setTag(TAG);
            queue.add(stringRequest);
        } else {
            notification.setText("I don't think internet is available on your phone");
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

    @Override
    public void onStop () {
        super.onStop();
        if (queue != null) {
            queue.cancelAll(TAG);
        }
    }

}
