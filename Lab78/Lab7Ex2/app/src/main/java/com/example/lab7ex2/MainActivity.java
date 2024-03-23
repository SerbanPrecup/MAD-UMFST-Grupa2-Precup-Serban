package com.example.lab7ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

//    private TextView txtTime;
//    private Button startStopButton;
//
//    private boolean start = false;
//    private Intent serviceIntent;
//    private double time = 0.0;
//    private final BroadcastReceiver updateTime = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            System.out.println("In update time main activity!");
//            time = intent.getDoubleExtra("TIME_EXTRA");
//            txtTime.setText(getTimeStringFromDouble(time));
//            System.out.println("Finished updating time!");
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        txtTime = findViewById(R.id.txtTime);
//        startStopButton = findViewById(R.id.startStopButton);
//        Button resetButton = findViewById(R.id.resetButton);
//
//        startStopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startStopTimer();
//            }
//        });
//        resetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                resetTimer();
//            }
//        });
//
//        try {
//            serviceIntent = new Intent(getApplicationContext(), TimerService.class);
//            LocalBroadcastManager.getInstance(this).registerReceiver(updateTime, new IntentFilter(TimerService.TIMER_UPDATED));
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//    }
//
//    private void resetTimer() {
//        stopTimer();
//        time = 0.0;
//        txtTime.setText(getTimeStringFromDouble(time));
//    }
//
//    private void startStopTimer() {
//        if (start)
//            stopTimer();
//        else
//            startTimer();
//    }
//
//    private void startTimer() {
//        serviceIntent.putExtra(TimerService.TIME_EXTRA, time);
//        startService(serviceIntent);
//        startStopButton.setText("Stop");
//
//        start = true;
//    }
//
//    private void stopTimer() {
//        stopService(serviceIntent);
//        startStopButton.setText("Start");
//
//        start = false;
//    }
//
//    private String getTimeStringFromDouble(double time) {
//        DecimalFormat formatter = new DecimalFormat("00");
//        int resultInt = (int) Math.round(time);
//        int hours = resultInt % 86400 / 3600;
//        int minutes = resultInt % 86400 % 3600 / 60;
//        int seconds = resultInt % 86400 % 3600 % 60;
//        return makeTimeString(formatter.format(hours), formatter.format(minutes), formatter.format(seconds));
//    }
//
//    private String makeTimeString(String hour, String min, String sec) {
//        return hour + ":" + min + ":" + sec;
//    }
//}
    TextView txtTime;
    Button resetButton,startstopButton;
    int seconds, minutes, milliSeconds;
    long millisecond, startTime, timeBuff, updateTime = 0L;
    Handler handler;
    private boolean start = false;
    private final Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            millisecond = SystemClock.uptimeMillis() - startTime;
            updateTime = timeBuff + millisecond;
            seconds = (int) (updateTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliSeconds = (int) (updateTime % 1000);

            txtTime.setText(MessageFormat.format("{0}:{1}:{2}", minutes, String.format(Locale.getDefault(), "%02d", seconds),String.format(Locale.getDefault(),"%02d", milliSeconds)));
            handler.postDelayed(this, 0);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);
        resetButton = findViewById(R.id.resetButton);
        startstopButton = findViewById(R.id.startStopButton);

        handler = new Handler(Looper.getMainLooper());

        startstopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start)
                    stopTimer();
                else
                    startTimer();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                millisecond = 0L;
                startTime = 0L;
                timeBuff = 0L;

                updateTime = 0L;
                seconds = 0;
                minutes = 0;
                milliSeconds = 0;
                txtTime.setText("00:00:00");
            }
        });

    }
    void startTimer()
    {
        startTime = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
        resetButton.setEnabled(false);
        start=true;
        startstopButton.setText("Stop");
    }

    void stopTimer(){
        timeBuff += millisecond;
        handler.removeCallbacks(runnable);
        resetButton.setEnabled(true);
        start=false;
        startstopButton.setText("Start");
    }

}