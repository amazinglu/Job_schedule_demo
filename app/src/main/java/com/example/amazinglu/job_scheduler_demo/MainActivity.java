package com.example.amazinglu.job_scheduler_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_MY_SEND = "com.example.amazinglu.job_scheduler_demo_my_send";

    private MyBroadCastReceiver myBroadCastReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sendBroadCast = findViewById(R.id.send_broad_cast);
        myBroadCastReceiver = new MyBroadCastReceiver();

        registerLocalBroadCast();

        sendBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(new Intent(ACTION_MY_SEND));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(MainActivity.this).unregisterReceiver(myBroadCastReceiver);
    }

    private void registerLocalBroadCast() {
        IntentFilter intentFilter = new IntentFilter(ACTION_MY_SEND);
        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(myBroadCastReceiver, intentFilter);
    }
}
