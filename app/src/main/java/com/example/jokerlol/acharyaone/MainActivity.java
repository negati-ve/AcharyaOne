package com.example.jokerlol.acharyaone;




import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity implements helpFragment.OnFragmentInteractionListener,notificationFragment.OnFragmentInteractionListener,feedbackFragment.OnFragmentInteractionListener,resetFragment.OnFragmentInteractionListener,BeginFragment.OnFragmentInteractionListener,Home.OnFragmentInteractionListener,TimeTable.OnFragmentInteractionListener,About.OnFragmentInteractionListener,Syllabus.OnFragmentInteractionListener,Faculty.OnFragmentInteractionListener {

    private  String[] mOptions;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    public ActionBarDrawerToggle mDrawerToggle;
    ActionBar actionBar;

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mOptions = getResources().getStringArray(R.array.nav_drawer_items);
        actionBar = getSupportActionBar();
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("check",false)==true){
            if(sharedPreferences.getString("current", "")=="faculty"){
                Fragment fragment = new Faculty();
                getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            }else if (sharedPreferences.getString("current", "")=="syllabus"){
                Fragment fragment = new Syllabus();
                getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            }else {
                Fragment fragment = new Home();
                getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            }
        }else {
            Fragment fragment = new BeginFragment();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
        }
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mOptions));
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);

            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position){
        Fragment fragment = null;
        switch(position){
            case 0 :
                fragment = new Home();
                break;
            case 1 :
                fragment = new TimeTable();
                break;
            case 2 :
                fragment = new Faculty();
                break;
            case 3 :
                fragment = new Syllabus();
                break;
            case 4 :
                fragment = new resetFragment();
                break;
            case 5 :
                fragment = new notificationFragment();
                break;
            case 6:
                fragment = new feedbackFragment();
                break;
            case 7:
                fragment = new helpFragment();
                break;
            case 8:
                fragment = new About();
                break;
            default:
                break;
        }
        if(fragment!=null){
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();
            mDrawerList.setItemChecked(position, true);
            setTitle(mOptions[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }else {
            finish();
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        actionBar.setTitle(title);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("current","home");
        editor.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        boolean again = sharedPreferences.getString("current","home")=="faculty";
        if(sharedPreferences.getString("current","home")=="faculty"){
            Fragment fragment = new Faculty();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            getSupportActionBar().setTitle("FACULTY");
        }else if (sharedPreferences.getString("current","home")=="syllabus"){
            Fragment fragment = new Syllabus();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            getSupportActionBar().setTitle("SYLLABUS");
        }else if (sharedPreferences.getString("current","home")=="home"){
            Fragment fragment = new Home();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            getSupportActionBar().setTitle("HOME");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        boolean again = sharedPreferences.getString("current","home")=="faculty";
        if(sharedPreferences.getString("current","home")=="faculty"){
            Fragment fragment = new Faculty();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            getSupportActionBar().setTitle("FACULTY");
        }else if (sharedPreferences.getString("current","home")=="syllabus"){
            Fragment fragment = new Syllabus();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            getSupportActionBar().setTitle("SYLLABUS");
        }else if (sharedPreferences.getString("current","home")=="home"){
            Fragment fragment = new Home();
            getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
            getSupportActionBar().setTitle("HOME");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}


