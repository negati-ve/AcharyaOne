package com.example.jokerlol.acharyaone;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TimeTableDisplay extends AppCompatActivity {

    int[][] arrayweight ;
    TextView
            monday1,monday2,monday3,monday4,monday5,monday6,monday7,monday8,
            tuesday1,tuesday2,tuesday3,tuesday4,tuesday5,tuesday6,tuesday7,tuesday8,
            wednesday1,wednesday2,wednesday3,wednesday4,wednesday5,wednesday6,wednesday7,wednesday8,
            thursday1,thursday2,thursday3,thursday4,thursday5,thursday6,thursday7,thursday8,
            friday1,friday2,friday3,friday4,friday5,friday6,friday7,friday8,again;
    String[][] showtimetable;
    TextView[][] arraytextview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i,j,sem,sec;
        setContentView(R.layout.activity_time_table_display);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        textviewint();
        again = (TextView)findViewById(R.id.again);
        sem=getIntent().getIntExtra("sem",3);
        sec=getIntent().getIntExtra("sec",1);
        if(!((sem==5&&sec==2)||(sem==5&&sec==3))){
            again.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0, 0f));
        }
        arraytimetable att = new arraytimetable();
        showtimetable = att.choosetimetable(sem,sec);
        arrayweight = att.choosetimetableweight(sem,sec);
        for(i=0;i<5;i++){
            for(j=0;j<8;j++){
                if(arrayweight[i][j]==1){
                    arraytextview[i][j].setText(showtimetable[i][j]);
                }else if(arrayweight[i][j]==2){
                    arraytextview[i][j].setLayoutParams(new TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,2f));
                    arraytextview[i][j].setText(showtimetable[i][j]);
                }else if(arrayweight[i][j]==3){
                    arraytextview[i][j].setLayoutParams(new TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,3f));
                    arraytextview[i][j].setText(showtimetable[i][j]);
                }else{
                    arraytextview[i][j].setLayoutParams(new TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0f));
                }
            }
        }
    }

    public void textviewint() {
        monday1 = (TextView) findViewById(R.id.monday1);
        monday2 = (TextView) findViewById(R.id.monday2);
        monday3 = (TextView) findViewById(R.id.monday3);
        monday4 = (TextView) findViewById(R.id.monday4);
        monday5 = (TextView) findViewById(R.id.monday5);
        monday6 = (TextView) findViewById(R.id.monday6);
        monday7 = (TextView) findViewById(R.id.monday7);
        monday8 = (TextView) findViewById(R.id.monday8);
        tuesday1 = (TextView) findViewById(R.id.tuesday1);
        tuesday2 = (TextView) findViewById(R.id.tuesday2);
        tuesday3 = (TextView) findViewById(R.id.tuesday3);
        tuesday4 = (TextView) findViewById(R.id.tuesday4);
        tuesday5 = (TextView) findViewById(R.id.tuesday5);
        tuesday6 = (TextView) findViewById(R.id.tuesday6);
        tuesday7 = (TextView) findViewById(R.id.tuesday7);
        tuesday8 = (TextView) findViewById(R.id.tuesday8);
        wednesday1 = (TextView) findViewById(R.id.wednesday1);
        wednesday2 = (TextView) findViewById(R.id.wednesday2);
        wednesday3 = (TextView) findViewById(R.id.wednesday3);
        wednesday4 = (TextView) findViewById(R.id.wednesday4);
        wednesday5 = (TextView) findViewById(R.id.wednesday5);
        wednesday6 = (TextView) findViewById(R.id.wednesday6);
        wednesday7 = (TextView) findViewById(R.id.wednesday7);
        wednesday8 = (TextView) findViewById(R.id.wednesday8);
        thursday1 = (TextView) findViewById(R.id.thursday1);
        thursday2 = (TextView) findViewById(R.id.thursday2);
        thursday3 = (TextView) findViewById(R.id.thursday3);
        thursday4 = (TextView) findViewById(R.id.thursday4);
        thursday5 = (TextView) findViewById(R.id.thursday5);
        thursday6 = (TextView) findViewById(R.id.thursday6);
        thursday7 = (TextView) findViewById(R.id.thursday7);
        thursday8 = (TextView) findViewById(R.id.thursday8);
        friday1 = (TextView) findViewById(R.id.friday1);
        friday2 = (TextView) findViewById(R.id.friday2);
        friday3 = (TextView) findViewById(R.id.friday3);
        friday4 = (TextView) findViewById(R.id.friday4);
        friday5 = (TextView) findViewById(R.id.friday5);
        friday6 = (TextView) findViewById(R.id.friday6);
        friday7 = (TextView) findViewById(R.id.friday7);
        friday8 = (TextView) findViewById(R.id.friday8);
        arraytextview = new TextView[][] {{monday1,monday2,monday3,monday4,monday5,monday6,monday7,monday8},
                {tuesday1,tuesday2,tuesday3,tuesday4,tuesday5,tuesday6,tuesday7,tuesday8},
                {wednesday1,wednesday2,wednesday3,wednesday4,wednesday5,wednesday6,wednesday7,wednesday8},
                {thursday1,thursday2,thursday3,thursday4,thursday5,thursday6,thursday7,thursday8},
                {friday1,friday2,friday3,friday4,friday5,friday6,friday7,friday8}};
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
