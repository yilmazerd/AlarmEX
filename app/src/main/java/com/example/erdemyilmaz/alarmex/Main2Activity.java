package com.example.erdemyilmaz.alarmex;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        final Ringtone ringtoneSound = RingtoneManager.getRingtone(getApplicationContext(), ringtoneUri);

        int colorFrom = ContextCompat.getColor(this, R.color.lightGreen);
        int colorTo = ContextCompat.getColor(this, R.color.white);



        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(2500); // milliseconds
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        final TextView myTextView = (TextView)findViewById(R.id.textView4);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                myTextView.setBackgroundColor((int) animator.getAnimatedValue());
                if (ringtoneSound != null) {
                    ringtoneSound.play();
                }
            }

        });
        colorAnimation.start();

        Button myButton = (Button)(findViewById(R.id.button));

        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                colorAnimation.end();
                ringtoneSound.stop();

            }
        });



    }
}
