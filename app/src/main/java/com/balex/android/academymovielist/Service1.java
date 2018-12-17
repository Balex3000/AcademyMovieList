package com.balex.android.academymovielist;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Service1 extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

        Toast.makeText(getApplicationContext(), "Service1 onStartCommand", Toast.LENGTH_SHORT).show();

        return START_STICKY;

    }
}
