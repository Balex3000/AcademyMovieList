package com.balex.android.academymovielist;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.balex.android.academymovielist.BGServiceActivity.BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION;

public class BGServiceActivity extends AppCompatActivity {

    private BackgroundProgressReceiver mBackgroundProgressReceiver;
    public boolean isDestroyed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg_service);

        TextView progressTextView = findViewById(R.id.tv_bg_serv_progress);
        TextView percCompleteTextView = findViewById(R.id.tv_bg_serv_perc_complete);

        Button intentServiceBtn = findViewById(R.id.btn_bg_serv_start_intent);
        Button serviceBtn = findViewById(R.id.btn_bg_serv_start_service);

        intentServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked on Intent Service", Toast.LENGTH_LONG).show();
            }
        });

        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked on Service Start", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), Service1.class);
                startService(intent);
            }
        });
    }

    protected void onHandleIntent (Intent intent) {
        isDestroyed = false;

        for (int i=0; i <= 100; i++) {
            SystemClock.sleep(100);
            Intent broadcastIntent = new Intent(BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION);
            broadcastIntent.putExtra(BackgroundProgressReceiver.PROGRESS_VALUE_KEY, i);
            sendBroadcast(broadcastIntent);
        }

    }

    private void subscribeForProgressUpdate() {
        if (mBackgroundProgressReceiver == null) {
            mBackgroundProgressReceiver = new BackgroundProgressReceiver();
        }

        IntentFilter progressUpdateActionFilter = new IntentFilter(PROGRESS_UPDATE_ACTION);
        registerReceiver(mBackgroundProgressReceiver, progressUpdateActionFilter);
    }

    public class BackgroundProgressReceiver extends BroadcastReceiver {

        public static final String PROGRESS_UPDATE_ACTION = "PROGRESS_UPDATE_ACTION";
        public static final String PROGRESS_VALUE_KEY = "PROGRESS_VALUE_KEY";
        public static final String SERVICE_STATUS = "SERVICE_STATUS";

        @Override
        public void onReceive(Context context, Intent intent) {
            int progress = intent.getIntExtra(PROGRESS_VALUE_KEY, -1);

            //TODO: parse progress value and update the mProgressValue TextView with relevant value
        }
    }
}
