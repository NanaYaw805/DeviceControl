package com.neatlimited.userphonecontrol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Objects;

public class OutgoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Objects.equals(intent.getAction(), Intent.ACTION_NEW_OUTGOING_CALL)){
                String theNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
                if (theNumber=="0504165849" || theNumber=="+233504165849"){
                    Intent killPhone = new Intent(context, SwitchPhoneOffService.class);
                    context.startActivity(killPhone);
                }
        }
    }
}
