package com.davidvu.hello_world;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class NewPlanetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ImageView marsImage = (ImageView) findViewById(R.id.imageMars);
        marsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorldGen mars = new WorldGen("Mars", 642, 3.7);
                mars.setPlanetColonies(1);
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
