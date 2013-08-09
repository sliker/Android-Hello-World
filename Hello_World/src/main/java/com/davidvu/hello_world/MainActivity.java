package com.davidvu.hello_world;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
    WorldGen earth = new WorldGen("Earth", 5973, 9.78);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStartUpWorldValues();
        setStartUpScreenText();
    }
    protected void setStartUpWorldValues() {
        earth.setPlanetColonies(1);
        earth.setPlanetMilitary(1);
        earth.setColonyImmigration(1000);
        earth.setBaseProtection(100);
        earth.turnForceFieldOn();
    }
    private void setStartUpScreenText() {
        TextView planetNameValue = (TextView)findViewById(R.id.dataView1);
        planetNameValue.setText(earth.planetName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
