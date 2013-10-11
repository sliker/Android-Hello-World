package com.davidvu.hello_world;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by david.velasquez on 10/11/13.
 */
public class MusicService extends Service {

    MediaPlayer musicPlayer;

    @Override
    public void onCreate() {
        //super.onCreate();
        Toast.makeText(this, "Music service has been created", Toast.LENGTH_SHORT).show();
        musicPlayer = MediaPlayer.create(this, R.raw.music);
        musicPlayer.setLooping(true);
    }

    @Override
    public void onDestroy() {
        //super.onDestroy();
        Toast.makeText(this, "Music Servce has been Stopped", Toast.LENGTH_SHORT).show();
        musicPlayer.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Music Service is Started", Toast.LENGTH_SHORT).show();
        musicPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
