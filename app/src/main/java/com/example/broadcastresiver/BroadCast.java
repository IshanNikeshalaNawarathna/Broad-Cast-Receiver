package com.example.broadcastresiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        boolean state = intent.getBooleanExtra("state",false);
        if(state){
            Intent newIntent = new Intent(context,BroadCastActivity.class);
            context.startActivity(newIntent);
        }

    }
}
