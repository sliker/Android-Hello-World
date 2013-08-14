package com.davidvu.hello_world;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TravelPlanetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.travel_planet, menu);
        return true;
    }
    
}
