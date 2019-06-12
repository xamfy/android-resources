package com.xamfy.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private boolean headsetConnected = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null) {
            String toastMessage = context.getString(R.string.unknow_intent_message);
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = context.getString(R.string.power_connected_message);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = context.getString(R.string.power_disconnected_message);
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = context.getString(R.string.custom_broadcast_message);
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    if(intent.hasExtra("state")){
                        if(headsetConnected && intent.getIntExtra("state", 0) == 0) {
                            headsetConnected = false;
                            toastMessage = context.getString(R.string.headset_unplugged_message);
                        } else  if (!headsetConnected && intent.getIntExtra("state", 0)==1) {
                            headsetConnected = true;
                            toastMessage = context.getString(R.string.headset_plugged_message);
                        }
                    }
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
