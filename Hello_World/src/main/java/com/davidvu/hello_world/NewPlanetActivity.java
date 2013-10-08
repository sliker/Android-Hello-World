package com.davidvu.hello_world;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewPlanetActivity extends Activity {

    private MediaPlayer marsPlayer = null;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        marsPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mars);

        final TransitionDrawable transitionDrawable = (TransitionDrawable) getResources().getDrawable(R.drawable.trans_stars_galaxy);
        RelativeLayout newPlanetScreen = (RelativeLayout) findViewById(R.id.new_planet_screen);
        newPlanetScreen.setBackground(transitionDrawable);


        ImageView marsImage = (ImageView) findViewById(R.id.imageMars);
        marsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorldGen mars = new WorldGen("Mars", 642, 3.7);
                mars.setPlanetColonies(1);
                Toast.makeText(NewPlanetActivity.this, "Mars Created", Toast.LENGTH_SHORT).show();
                transitionDrawable.startTransition(5000);
                marsPlayer.start();
                /*
                Toast myToast = Toast.makeText(NewPlanet.this, "Mars Created", Toast.LENGTH_SHORT);
                myToast.show();
                 */
                
            }
        });

        Button doneButton = (Button) findViewById(R.id.doneAddingButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_X){
            finish();
            return true;
        }
        return false;
    }
}
