package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends Activity {

    private int mseconds = 0; //секунды для секундомера
    private boolean running; //флаг работы секундомера

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }

    public void onClickStart(View view) {
        running = true; //запуск секундомера
    }
    public void onClickStop(View view) {
        running = false; //остановка секундомера
    }
    public void onClickReset(View view) {
        running = false;
        mseconds = 0;
    }
    public void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = mseconds/36000;
                int minutes = (mseconds%3600)/600;
                int secs = mseconds%600/10;
                int milsecs = mseconds%10;
               // String time = String.format(Locale.getDefault(),"%d:%02d:%02d:%02d", hours, minutes, secs,milsecs);
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d:%02d", hours, minutes, secs, milsecs);
                timeView.setText(time);
                if  (running) {
                    mseconds++;
                }
                handler.postDelayed(this, 100);
            }
        });

    }

}
