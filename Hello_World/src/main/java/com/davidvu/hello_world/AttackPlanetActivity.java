package com.davidvu.hello_world;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
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

    private SoundPool soundPoolFX;
    private SparseIntArray soundPoolMap;
    int sample1 = 1;
    int sample2 = 2;
    int sample3 = 3;
    int sample4 = 4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);

        soundPoolFX = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new SparseIntArray(4);

        soundPoolMap.append(sample1, soundPoolFX.load(this, R.raw.blast, 1));
        soundPoolMap.append(sample2, soundPoolFX.load(this, R.raw.transport, 1));
        soundPoolMap.append(sample3, soundPoolFX.load(this, R.raw.virus, 1));
        soundPoolMap.append(sample4, soundPoolFX.load(this, R.raw.laser, 1));

        ImageButton bombButton = (ImageButton) findViewById(R.id.bombButton);
        Animation rotateBomb = AnimationUtils.loadAnimation(this, R.anim.anim_rot_bomb);
        bombButton.startAnimation(rotateBomb);
        bombButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Bomb away!", Toast.LENGTH_SHORT).show();
                playSample(sample1, 1.0f);
            }
        });
        ImageButton invadeButton = (ImageButton) findViewById(R.id.invadeButton);
        Animation alphaInvade = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_invade);
        invadeButton.startAnimation(alphaInvade);
        invadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Troops send", Toast.LENGTH_SHORT).show();
                playSample(sample2, 1.0f);
            }
        });
        ImageButton infectButton = (ImageButton) findViewById(R.id.infectButton);
        Animation scaleVirus = AnimationUtils.loadAnimation(this, R.anim.anim_scale_virus);
        infectButton.startAnimation(scaleVirus);
        infectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Virus Spread", Toast.LENGTH_SHORT).show();
                playSample(sample3, 1.0f);
            }
        });
        ImageButton laserButton = (ImageButton) findViewById(R.id.laserButton);
        laserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AttackPlanetActivity.this, "Laser Fired!", Toast.LENGTH_SHORT).show();
                playSample(sample4, 1.0f);
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

    public void playSample(int sample, float pitchShift){
        AudioManager manageAudio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        float curSampleVolume = manageAudio.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxSampleVolume = manageAudio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float setSampleVolume = curSampleVolume / maxSampleVolume;
        soundPoolFX.play(soundPoolMap.get(sample), setSampleVolume, setSampleVolume, 0, 0, pitchShift);
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
