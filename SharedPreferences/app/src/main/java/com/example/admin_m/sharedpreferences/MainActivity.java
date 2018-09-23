package com.example.admin_m.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    EditText etName;
    Button btnSubmit;
    public static final String MY_PREFS_FILENAME = "com.example.admin_m.sharedpreferences.Names";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE);
        String user = prefs.getString("user", "Falcon 5 MJ");
        tvWelcome.setText("Hey " + user + ", Welcome to my App");


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                tvWelcome.setText("Hey " + name + ", Welcome to my App");

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME, MODE_PRIVATE).edit();
                editor.putString("user", name);
                editor.commit();
            }
        });
    }
}
