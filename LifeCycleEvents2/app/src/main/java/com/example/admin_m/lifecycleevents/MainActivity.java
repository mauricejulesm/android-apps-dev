package com.example.admin_m.lifecycleevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Life Cycle Event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String msg = "In OnCreate()";
        Log.d( TAG, msg);
    }

    @Override
    protected void onStop() {
        super.onStop();

        String msg = "In OnStop()";
        Log.d(TAG, msg);
    }
}
