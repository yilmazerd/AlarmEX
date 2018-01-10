package com.example.erdemyilmaz.alarmex;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityAlarmTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_time);
        final SharedPreferences sp = getSharedPreferences("label",0);
        final SharedPreferences.Editor editor = sp.edit();




        Button myButton = (Button)(findViewById(R.id.BUTTON_SAVE_ALARMT));

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView tvHour = (TextView)(findViewById(R.id.textSetHour));
                TextView tvMinute = (TextView)(findViewById(R.id.textSetMinute));

                String aHour = tvMinute.getText().toString();
                String aMinute = tvHour.getText().toString();

                int Hour = Integer.parseInt(aHour);
                int Minute = Integer.parseInt(aMinute);

                String[] ns = new String[2];
                ns[0]="ETTE";
                ns[1]="EKKE";

                //final String msString = mPrefs.getString("tag1","Load default");

                //SharedPreferences sp = getSharedPreferences("AlarmTimes", Activity.MODE_PRIVATE);


                String mm = sp.getString("turgut","Load default");
                Log.e("TAG--",mm);

                editor.putString("turgut","palla");

                mm = sp.getString("turgut","Load default");
                Log.e("TAG--",mm);

                //editor.putInt("RecordMinute", Minute);
                //editor.putInt("MinuteCounter", Minute);
                //editor.putInt("RecordHour", Hour);
                //editor.commit();
            }
        });


    }

    public String generateKeyName (String key, int k) {
        String pass1 = "Key:" + key + "-" + String.valueOf(k);
        return  pass1;
    };

    public  Integer getKeyNumber (String keyName) {
        String example = keyName.substring((keyName.lastIndexOf("-") + 1 ));
        return Integer.parseInt(example);
    }

    public void  enterNewValue (String tag, int newVal, SharedPreferences shp) {
        // TODO GET THE NUMBER OF ENTRIES IN THE EXISTING TAG
        int numOfEntries = getKeyNumber(tag);
        Log.e("KSS-",String.valueOf(numOfEntries));

        // ANOTHER VARIABLE WILL BE IF THE EXISTING TAG IS ENTERED BEFORE

        // TODO INCREASE THE NUMBER OF ENTRIES IN THE LOG, MAKE THE ENTRY
    }

    public ArrayList<String> getTheValue (String tag, SharedPreferences shp) {
        ArrayList<String> ar = new ArrayList<String>();
        //
        // TODO use the tag, get the size of the array in the database, write the database into arraylist
        //
        int numOfEntries = getKeyNumber(tag);
        for (int i=0;i<numOfEntries;i++) {
            String nmn = generateKeyName(tag,i);
            String msString = shp.getString(nmn,"Load default");
            ar.add(msString);
            Log.e("KSS-",msString);
        }
        return ar;
    }


}

