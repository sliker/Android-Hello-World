package com.davidvu.hello_world;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by david.velasquez on 10/15/13.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "ALARM NOTIFICATION", Toast.LENGTH_SHORT).show();

    }
}
