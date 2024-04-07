package com.neatlimited.userphonecontrol;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SwitchPhoneOffService extends Service {
    private ServiceHandler serviceHandler;
    private Looper looper;
    private Context context;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Message message = serviceHandler.obtainMessage();
        message.arg1 = startId;
        serviceHandler.sendMessage(message);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        HandlerThread thread = new HandlerThread("reboot", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        looper = thread.getLooper();
        serviceHandler = new ServiceHandler(looper,context);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(context,"No longer running...",Toast.LENGTH_SHORT).show();
    }
}
