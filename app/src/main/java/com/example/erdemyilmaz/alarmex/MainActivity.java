package com.example.erdemyilmaz.alarmex;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        int[] myDelays = {5000, 10000,15000,20000,25000};
        scheduleService(myDelays);
        Log.e("TAG--","Ordering services");


    }

    private void scheduleService(int[] delays) {

        Intent notificationIntent = new Intent(this, MyService.class);
        Log.e("TAG--","Created the intent");

        ArrayList<PendingIntent> PE = new ArrayList<PendingIntent>();



        long futureInMillis = SystemClock.elapsedRealtime();

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        for (int i=0;i<delays.length;i++) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, i, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            PE.add(pendingIntent);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis + delays[i], PE.get(i));
        }

        Log.e("TAG--","Set alarm manager");
    }



}
