package com.neatlimited.userphonecontrol;





import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ServiceHandler extends Handler{
    Context context;
    public ServiceHandler(@NonNull Looper looper,Context context) {
        super(looper);
        this.context = context;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        rebootPhone(context);





    }

    public void rebootPhone(Context context){
        this.context = context;

        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        powerManager.reboot("Restarting the phone...");
    }


}


