package com.neatlimited.userphonecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the outgoingcallreciver object
        OutgoingCallReceiver outgoingCallReceiver = new OutgoingCallReceiver();

        //creating the intent filter
        IntentFilter filter = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);

        //registering the broadcast
        registerReceiver(outgoingCallReceiver,filter);
    }
}