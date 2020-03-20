package com.example.bp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/*Broadcast Receiver Class
In deze class wordt een broadcast receiver gebruikt. Een broadcast receiver is maar voor een korte tijd,
daarom wordt er ook een Intent service gebruikt.
*/
public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, MyNewIntentService.class);
        context.startService(intent1);
    }
}