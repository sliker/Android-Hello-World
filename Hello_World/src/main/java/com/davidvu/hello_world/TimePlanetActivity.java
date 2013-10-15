package com.davidvu.hello_world;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TimePlanetActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_planet);

        final TransitionDrawable trans = (TransitionDrawable) getResources().getDrawable(R.drawable.trans_stars_galaxy);
        LinearLayout timePlanetScreen = (LinearLayout) findViewById(R.id.timePlanetScreen);
        timePlanetScreen.setBackground(trans);
        trans.startTransition(5000);

        Button returnFromTimeButton = (Button) findViewById(R.id.timeButton);
        returnFromTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        Button startMusicServiceButton = (Button) findViewById(R.id.startServiceButton);
        startMusicServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(TimePlanetActivity.this, MusicService.class));
            }
        });

        Button stopMusicServiceButton = (Button) findViewById(R.id.stopServiceButton);
        stopMusicServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(TimePlanetActivity.this, MusicService.class));
            }
        });

        Button startTimerButton = (Button) findViewById(R.id.startCounter);
        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer(view);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.time_planet, menu);
        return true;
    }

    public void startTimer(View view){
        EditText alarmText = (EditText) findViewById(R.id.setAlarm);
        int i = Integer.parseInt(alarmText.getText().toString());
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), alarmIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_SHORT).show();
    }
    
}
