package com.balex.android.academymovielist;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Toast;
import android.os.Process;

public class Service1 extends Service {

    private final static String TAG = "TAG";
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // To avoid CPU blocking we create a background handler to run our service
        // TODO verify what is the TAG
        HandlerThread thread = new HandlerThread(TAG, Process.THREAD_PRIORITY_BACKGROUND);

        // start the new Handler Thread
        thread.start();

        mServiceLooper = thread.getLooper();

        // start the service using the background handler
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

        Toast.makeText(getApplicationContext(), "Service1 onStartCommand", Toast.LENGTH_SHORT).show();

        // TODO isDestroyed = false;

        // call a new service handler, The service ID can be used to identify the service
        Message message = mServiceHandler.obtainMessage();

        message.arg1 = startId;
        mServiceHandler.sendMessage(message);

        return START_STICKY;

    }

    private final class ServiceHandler extends Handler {

        public ServiceHandler(Looper looper) {super(looper);}

        @Override
        public void handleMessage(Message msg) {

            // TODO add && !isDestroyed
            for (int i=0; i <= 100; i++) {
                SystemClock.sleep(100);
                Intent broadcastIntent = new Intent(BGServiceActivity.BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION);
                broadcastIntent.putExtra(BGServiceActivity.BackgroundProgressReceiver.PROGRESS_VALUE_KEY, i);
                sendBroadcast(broadcastIntent);
            }

            // the msg.arg1 is the startId used in the onStartCommand so we can track the running service here
            stopSelf(msg.arg1);

        }
    }
}
