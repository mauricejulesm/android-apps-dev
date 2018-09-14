package com.example.admin_m.customedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etFirstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (AutoCompleteTextView)findViewById(R.id.etFirstName);
        String[] names = {"Jules", "Maurice", "Mulisa", "Adam", "james", "jupiter"};
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, R.layout.custom_design_autocomplete, names);
        etFirstName.setThreshold(1);
        etFirstName.setAdapter(arrayAdapter);
    }
}
