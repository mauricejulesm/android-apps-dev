package com.example.admin_m.thermometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalculate;
    TextView textViewResults;
    DecimalFormat formatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalculate = findViewById(R.id.btnCalculate);
        textViewResults = findViewById(R.id.textViewResults);

        textViewResults.setVisibility(View.GONE);

        String pattern = "#0.0";
        formatter = new DecimalFormat( pattern);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etChirps.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter a Number Above", Toast.LENGTH_SHORT).show();
                } else {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());
                    double temp = (chirps / 3.0) + 4;
                    String results = "The approximate temperature outside is: " +formatter.format(temp) + " degrees Celcius";
                    textViewResults.setText(results);
                    textViewResults.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
