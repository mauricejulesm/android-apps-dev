package com.example.admin_m.fakephone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = findViewById(R.id.tvMessage);
        if (getIntent().getData() != null){
            tvMessage.setText("I'm going to call this phone number "+
                    getIntent().getData().toString());
        }else {
            tvMessage.setText("Oops! No Data Was Sent to Me!");
        }
    }
}
