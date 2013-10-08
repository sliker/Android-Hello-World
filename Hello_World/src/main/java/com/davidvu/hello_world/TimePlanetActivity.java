package com.davidvu.hello_world;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TimePlanetActivity extends Activity {

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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.time_planet, menu);
        return true;
    }
    
}
