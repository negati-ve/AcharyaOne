package com.example.jokerlol.acharyaone;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class infoscreen extends AppCompatActivity {

    int a=-1 ;
    TextView tname , tp2 ,  te2;
    Getinfo gt;
    String number , email , webber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoscreen);
        imagesetter();
        Bundle extras = getIntent().getExtras();
        a = extras.getInt("Thisisposition");
        seteve();
    }
    public void imagesetter(){
        ImageView img1 , img2 ;
        img1 = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img1.setImageResource(R.drawable.phone);
        img2.setImageResource(R.drawable.email);
    }
    public void seteve(){
        tname = (TextView) findViewById(R.id.Teachersname);
        tp2 = (TextView) findViewById(R.id.Tp2);
        te2 = (TextView) findViewById(R.id.Te2);
        gt = new Getinfo();
        String[] teacher = gt.getnames();
        String[] nums = gt.getnums();
        String[] emails = gt.getemails();
        String[] toget = gt.knowmore();
        switch(a){
            case -1 :
                Intent i = new Intent(infoscreen.this , MainActivity.class);
                Toast.makeText(infoscreen.this , "Pick again" , Toast.LENGTH_SHORT);
                startActivity(i);
                break;
            case 0: tname.setText(teacher[0]); tp2.setText(nums[0]);te2.setText(emails[0]);
                number = nums[0];
                email = emails[0];
                webber = toget[0];
                break;
            case 1: tname.setText(teacher[1]); tp2.setText(nums[1]);te2.setText(emails[1]);
                number = nums[1];
                email = emails[1];
                webber = toget[1];
                break;
            case 2: tname.setText(teacher[2]); tp2.setText(nums[2]);te2.setText(emails[2]);
                number = nums[2];
                email = emails[2];
                webber = toget[2];
                break;
            case 3: tname.setText(teacher[3]); tp2.setText(nums[3]);te2.setText(emails[3]);
                number = nums[3];
                email = emails[3];
                webber = toget[3];
                break;
            case 4: tname.setText(teacher[4]); tp2.setText(nums[4]);te2.setText(emails[4]);
                number = nums[4];
                email = emails[4];
                webber = toget[4];
                break;
            case 5: tname.setText(teacher[5]); tp2.setText(nums[5]);te2.setText(emails[5]);
                number = nums[5];
                email = emails[5];
                webber = toget[5];
                break;
            case 6: tname.setText(teacher[6]); tp2.setText(nums[6]);te2.setText(emails[6]);
                number = nums[6];
                email = emails[6];
                webber = toget[6];
                break;
            case 7: tname.setText(teacher[7]); tp2.setText(nums[7]);te2.setText(emails[7]);
                number = nums[7];
                email = emails[7];
                webber = toget[7];
                break;
            case 8: tname.setText(teacher[8]); tp2.setText(nums[8]);te2.setText(emails[8]);
                number = nums[8];
                email = emails[8];
                webber = toget[8];
                break;
            case 9: tname.setText(teacher[9]); tp2.setText(nums[9]);te2.setText(emails[9]);
                number = nums[9];
                email = emails[9];
                webber = toget[9];
                break;
            case 10: tname.setText(teacher[10]); tp2.setText(nums[10]);te2.setText(emails[10]);
                number = nums[10];
                email = emails[10];
                webber = toget[10];
                break;
            case 11: tname.setText(teacher[11]); tp2.setText(nums[11]);te2.setText(emails[11]);
                number = nums[11];
                email = emails[11];
                webber = toget[11];
                break;
            case 12: tname.setText(teacher[12]); tp2.setText(nums[12]);te2.setText(emails[12]);
                number = nums[12];
                email = emails[12];
                webber = toget[12];
                break;
            case 13: tname.setText(teacher[13]); tp2.setText(nums[13]);te2.setText(emails[13]);
                number = nums[13];
                email = emails[13];
                webber = toget[13];
                break;
            case 14: tname.setText(teacher[14]); tp2.setText(nums[14]);te2.setText(emails[14]);
                number = nums[14];
                email = emails[14];
                webber = toget[14];
                break;
            case 15: tname.setText(teacher[15]); tp2.setText(nums[15]);te2.setText(emails[15]);
                number = nums[15];
                email = emails[15];
                webber = toget[15];
                break;
            case 16: tname.setText(teacher[16]); tp2.setText(nums[16]);te2.setText(emails[16]);
                number = nums[16];
                email = emails[16];
                webber = toget[16];
                break;
            case 17: tname.setText(teacher[17]); tp2.setText(nums[17]);te2.setText(emails[17]);
                number = nums[17];
                email = emails[17];
                webber = toget[17];
                break;
            case 18: tname.setText(teacher[18]); tp2.setText(nums[18]);te2.setText(emails[18]);
                number = nums[18];
                email = emails[18];
                webber = toget[18];
                break;
            case 19: tname.setText(teacher[19]); tp2.setText(nums[19]);te2.setText(emails[19]);
                number = nums[19];
                email = emails[19];
                webber = toget[19];
                break;
            case 20: tname.setText(teacher[20]); tp2.setText(nums[20]);te2.setText(emails[20]);
                number = nums[20];
                email = emails[20];
                webber = toget[20];
                break;
            case 21: tname.setText(teacher[21]); tp2.setText(nums[21]);te2.setText(emails[21]);
                number = nums[21];
                email = emails[21];
                webber = toget[21];
                break;
            case 22: tname.setText(teacher[22]); tp2.setText(nums[22]);te2.setText(emails[22]);
                number = nums[22];
                email = emails[22];
                webber = toget[22];
                break;
            case 23: tname.setText(teacher[23]); tp2.setText(nums[23]);te2.setText(emails[23]);
                number = nums[23];
                email = emails[23];
                webber = toget[24];
                break;
            case 24: tname.setText(teacher[24]); tp2.setText(nums[24]);te2.setText(emails[24]);
                number = nums[24];
                email = emails[24];
                webber = toget[24];
                break;
            case 25: tname.setText(teacher[25]); tp2.setText(nums[25]);te2.setText(emails[25]);
                number = nums[25];
                email = emails[25];
                webber = toget[25];
                break;
            case 26: tname.setText(teacher[26]); tp2.setText(nums[26]);te2.setText(emails[26]);
                number = nums[26];
                email = emails[26];
                webber = toget[26];
                break;
            default: Toast.makeText(infoscreen.this , "something went wrong " , Toast.LENGTH_SHORT).show();break;
        }
    }
    public void callplease(View view){
        String callto = "tel:+91"+number ;
        Intent callintent = new Intent(Intent.ACTION_DIAL , Uri.parse(callto));
        startActivity(callintent);
    }
    public void emailplease(View view){
        if(isNetworkAvailable()){
            String sendto = "mailto:"+email;
            Intent emailintent = new Intent(Intent.ACTION_SENDTO , Uri.parse(sendto));
            startActivity(emailintent);
        }
        else
            Toast.makeText(infoscreen.this , "Conneect To the internet please  " , Toast.LENGTH_SHORT).show();
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void iwannaknow(View view){
        if(isNetworkAvailable()){
            Intent webin = new Intent(Intent.ACTION_VIEW , Uri.parse(webber));
            startActivity(webin);
        }
        else
            Toast.makeText(infoscreen.this , "Conneect To the internet please  " , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

}
