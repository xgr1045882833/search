package com.arron.searchdemo;

import android.app.Application;
import android.app.IntentService;
import android.app.job.JobService;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test01
        //test02
        //test03
        //test04
        //test05
        Binder binder;
        IntentService service;
        //service.startForegroundService(new Intent());
        JobService jobService;
        Application application = getApplication();
        Context applicationContext = getApplicationContext();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}
