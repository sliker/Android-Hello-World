package com.davidvu.hello_world;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        EditText colonyText = (EditText) findViewById(R.id.editTextColonies);
        colonyText.setText("1", TextView.BufferType.EDITABLE);
        EditText colonistText = (EditText) findViewById(R.id.editTextColonist);
        colonistText.setText("100", TextView.BufferType.EDITABLE);
        EditText basesText = (EditText) findViewById(R.id.editTextBases);
        basesText.setText("1", TextView.BufferType.EDITABLE);
        EditText militaryText = (EditText) findViewById(R.id.editTextMilitary);
        militaryText.setText("1", TextView.BufferType.EDITABLE);
        EditText forcefieldOnText = (EditText) findViewById(R.id.editForceFieldOn);
        forcefieldOnText.setText("", TextView.BufferType.EDITABLE);
        EditText forcefieldOffText = (EditText) findViewById(R.id.editForceFieldOff);
        forcefieldOffText.setText("Forcefield is Off", TextView.BufferType.EDITABLE);
        Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button colonyButton = (Button) findViewById(R.id.coloniesButton);
        colonyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button colonistButton = (Button) findViewById(R.id.colonistButton);
        colonistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button baseButton = (Button) findViewById(R.id.basesButton);
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button militaryButton = (Button) findViewById(R.id.militaryButton);
        militaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button forceFieldOnButton = (Button) findViewById(R.id.ffonButton);
        forceFieldOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button forceFieldOffButton = (Button) findViewById(R.id.ffoffButton);
        forceFieldOffButton.setOnClickListener(new View.OnClickListener() {
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
