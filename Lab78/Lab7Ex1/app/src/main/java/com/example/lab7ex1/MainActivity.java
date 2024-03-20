package com.example.lab7ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // schimbarile bateriei
        IntentFilter batteryChangedIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        MyReceiver batteryChangedReceiver = new MyReceiver();
        registerReceiver(batteryChangedReceiver, batteryChangedIntentFilter);

        // nivelul bateriei
        IntentFilter batteryLowIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        MyReceiver batteryLowReceiver = new MyReceiver();
        registerReceiver(batteryLowReceiver, batteryLowIntentFilter);
        }
    }