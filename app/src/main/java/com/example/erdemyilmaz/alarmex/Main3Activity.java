package com.example.erdemyilmaz.alarmex;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.util.Calendar;

import static android.icu.text.DateFormat.HOUR;
import static android.icu.text.DateFormat.MINUTE;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // This activity runs an alarm at a given certain time

        /** Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY,
                Integer.getInteger(HOUR, 16),
                Integer.getInteger(MINUTE, 10));

        Intent intent = new Intent(this, MyService.class);
        PendingIntent alarmIntentRTC;
        alarmIntentRTC = PendingIntent.getBroadcast(this, AlarmManager.RTC_WAKEUP, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManagerRTC;
        alarmManagerRTC = (AlarmManager)this.getSystemService(ALARM_SERVICE);
        alarmManagerRTC.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntentRTC); */


        AlarmManager alarmMgr;
        Log.e("TAG--","Set the alarm manager");
        Intent intent = new Intent(this, MyService.class);

        PendingIntent alarmIntentRTC;

        //alarmIntentRTC = PendingIntent.getBroadcast(this, AlarmManager.RTC_WAKEUP, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmIntentRTC = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmMgr = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE,4);

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000*60*60*24, alarmIntentRTC);
        Log.e("TAG--","Set repeating alarm");

    }
}
