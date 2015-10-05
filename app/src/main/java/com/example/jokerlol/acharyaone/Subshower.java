package com.example.jokerlol.acharyaone;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Subshower extends AppCompatActivity {

    int a=0 , b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subshower);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().hide();
        TextView textView1 = (TextView) findViewById(R.id.this1);
        a = extras.getInt("FIRST");
        b = extras.getInt("SECOND");
        String yo = semselecter();
        textView1.setText(yo);
    }

    public String semselecter(){
        switch (a){
            case 1 : return sem3sel();
            case 2 : return sem4sel();
            case 3 : return sem5sel();
            case 4 : return sem6sel();
            case 5 : return sem7sel();
            case 6 : return sem8sel();
            default:return null;
        }
    }
    public String sem3sel(){
        sem3 sss = new  sem3();
        switch (b){
            case 1 : return sss.getSub1() ;
            case 2 : return sss.getSub2() ;
            case 3 : return sss.getSub3() ;
            case 4 : return sss.getSub4() ;
            case 5 : return sss.getSub5() ;
            case 6 : return sss.getSub6() ;
            case 7 : return sss.getSub7() ;
            case 8 : return sss.getSub8() ;
            case 21: return sss.getT1();
            case 22: return sss.getT2();
            case 23: return sss.getT3();
            case 24: return sss.getT4();
            case 25: return sss.getT5();
            case 26: return sss.getT6();
            default:return null;
        }
    }
    public String sem4sel(){
        sem4 sss = new  sem4();
        switch (b){
            case 1 : return sss.getSub1() ;
            case 2 : return sss.getSub2() ;
            case 3 : return sss.getSub3() ;
            case 4 : return sss.getSub4() ;
            case 5 : return sss.getSub5() ;
            case 6 : return sss.getSub6() ;
            case 7 : return sss.getSub7() ;
            case 8 : return sss.getSub8() ;
            case 21: return sss.getT1();
            case 22: return sss.getT2();
            case 23: return sss.getT3();
            case 24: return sss.getT4();
            case 25: return sss.getT5();
            case 26: return sss.getT6();
            default:return null;
        }
    }
    public String sem5sel(){
        sem5 sss = new  sem5();
        switch (b){
            case 1 : return sss.getSub1() ;
            case 2 : return sss.getSub2() ;
            case 3 : return sss.getSub3() ;
            case 4 : return sss.getSub4() ;
            case 5 : return sss.getSub5() ;
            case 6 : return sss.getSub6() ;
            case 7 : return sss.getSub7() ;
            case 8 : return sss.getSub8() ;
            case 21: return sss.getT1();
            case 22: return sss.getT2();
            case 23: return sss.getT3();
            case 24: return sss.getT4();
            case 25: return sss.getT5();
            case 26: return sss.getT6();
            default:return null;
        }
    }
    public String sem6sel(){
        sem6 sss = new  sem6();
        switch (b){
            case 1 : return sss.getSub1() ;
            case 2 : return sss.getSub2() ;
            case 3 : return sss.getSub3() ;
            case 4 : return sss.getSub4() ;
            case 5 : return sss.getSub5() ;
            case 6 : return sss.getSub6() ;
            case 7 : return sss.getSub7() ;
            case 8 : return sss.getSub8() ;
            case 9 : return sss.getSub9() ;
            case 10 : return sss.getSub10() ;
            case 11 : return sss.getSub11() ;
            case 12 : return sss.getSub12() ;
            case 13 : return sss.getSub13() ;
            case 21: return sss.getT1();
            case 22: return sss.getT2();
            case 23: return sss.getT3();
            case 24: return sss.getT4();
            case 25: return sss.getT5();
            case 26: return sss.getT6();
            case 27: return sss.getT7();
            case 28: return sss.getT8();
            case 29: return sss.getT9();
            case 30: return sss.getT10();
            case 31: return sss.getT11();
            default:return null;
        }
    }
    public String sem7sel(){
        sem7 sss = new  sem7();
        switch (b){
            case 1 : return sss.getSub1() ;
            case 2 : return sss.getSub2() ;
            case 3 : return sss.getSub3() ;
            case 4 : return sss.getSub4() ;
            case 5 : return sss.getSub5() ;
            case 6 : return sss.getSub6() ;
            case 7 : return sss.getSub7() ;
            case 8 : return sss.getSub8() ;
            case 21: return sss.getT1();
            case 22: return sss.getT2();
            case 23: return sss.getT3();
            case 24: return sss.getT4();
            case 25: return sss.getT5();
            case 26: return sss.getT6();
            default:return null;
        }
    }
    public String sem8sel(){
        sem8 sss = new  sem8();
        switch (b){
            case 1 : return sss.getSub1() ;
            case 2 : return sss.getSub2() ;
            case 3 : return sss.getSub3() ;
            case 4 : return sss.getSub4() ;
            case 5 : return sss.getSub5() ;
            case 6 : return sss.getSub6() ;
            case 7 : return sss.getSub7() ;
            case 8 : return sss.getSub8() ;
            case 9 : return sss.getSub1() ;
            case 10 : return sss.getSub2() ;
            case 11 : return sss.getSub3() ;
            case 12 : return sss.getSub4() ;
            case 13 : return sss.getSub5() ;
            case 14 : return sss.getSub6() ;
            case 21: return sss.getT1();
            case 22: return sss.getT2();
            case 23: return sss.getT3();
            case 24: return sss.getT4();
            case 25: return sss.getT5();
            case 26: return sss.getT6();
            case 27: return sss.getT7();
            case 28: return sss.getT8();
            case 29: return sss.getT9();
            case 30: return sss.getT10();
            case 31: return sss.getT11();
            case 32: return sss.getT12();
            case 33: return sss.getT13();
            case 34: return sss.getT14();
            default:return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subshower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
