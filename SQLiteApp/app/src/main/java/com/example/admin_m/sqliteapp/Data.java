package com.example.admin_m.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Data extends AppCompatActivity {

    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvData = findViewById(R.id.tvData);

        ContactsDB db = new ContactsDB(this);
        db.open();

        //Setting data to the text view
        tvData.setText(db.getData());

        //close db
        db.close();
    }
}
