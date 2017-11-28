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
        scheduleService(5000);
        Log.e("TAG--","Ordering services");


    }

    private void scheduleService(int delay) {

        Intent notificationIntent = new Intent(this, MyService.class);
        Log.e("TAG--","Created the intent");

        ArrayList<PendingIntent> PE = new ArrayList<PendingIntent>();
        int[] myDelays = {5000, 10000};

        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //PE.add(pendingIntent);
        //PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //pendingIntent = PendingIntent.getBroadcast(this, 1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //PE.add(pendingIntent);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        for (int i=0;i<2;i++) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, i, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            PE.add(pendingIntent);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis + myDelays[i], PE.get(i));
        }

        Log.e("TAG--","Set alarm manager");
    }



}
