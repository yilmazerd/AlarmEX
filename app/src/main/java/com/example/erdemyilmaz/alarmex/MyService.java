package com.example.erdemyilmaz.alarmex;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import static android.app.Service.START_STICKY;

/**
 * Created by erdemyilmaz on 11/27/17.
 */

public class MyService extends BroadcastReceiver
{
    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";

    public void onReceive(Context context, Intent intent) {

        Log.e("TAG--","In the broadcast receiver");

    }
}
