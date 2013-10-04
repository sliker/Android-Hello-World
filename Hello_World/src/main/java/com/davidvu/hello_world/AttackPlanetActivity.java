package com.davidvu.hello_world;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by david.velasquez on 8/14/13.
 */
public class AttackPlanetActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);

        ImageButton bombButton = (ImageButton) findViewById(R.id.bombButton);
        Animation rotateBomb = AnimationUtils.loadAnimation(this, R.anim.anim_rot_bomb);
        bombButton.startAnimation(rotateBomb);
        bombButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Bomb away!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton invadeButton = (ImageButton) findViewById(R.id.invadeButton);
        Animation alphaInvade = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_invade);
        invadeButton.startAnimation(alphaInvade);
        invadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Troops send", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton infectButton = (ImageButton) findViewById(R.id.infectButton);
        Animation scaleVirus = AnimationUtils.loadAnimation(this, R.anim.anim_scale_virus);
        infectButton.startAnimation(scaleVirus);
        infectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Virus Spread", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton laserButton = (ImageButton) findViewById(R.id.laserButton);
        laserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Laser Fired!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton exitButton = (ImageButton) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
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
