package com.balex.android.academymovielist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BGServiceActivity extends AppCompatActivity {

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
}
