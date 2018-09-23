package com.example.admin_m.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
    }

    public void btnSubmit(View view) {

        String name = etName.getText().toString().trim();
        String phone = etNumber.getText().toString().trim();

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();

            //populating the database
            db.createEntry(name, phone);
            db.close();
            Toast.makeText(this, "Data Successfully Saved to the Database", Toast.LENGTH_SHORT).show();

            etName.setText(""); // to clear it
            etNumber.setText("");   // to clear it
        } catch (android.database.SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    public void btnShowData(View view) {

        startActivity(new Intent(this, Data.class));
    }

    public void btnEditData(View view) {
        ContactsDB db = new ContactsDB(this);
        db.open();
        db.updateEntry("1", "Johan Jurrius", "+27842568455");
        db.close();
        Toast.makeText(this, "Database Successfully Updated", Toast.LENGTH_SHORT).show();

    }

    public void btnDeleteData(View view) {
        ContactsDB db = new ContactsDB(this);
        db.open();
        db.deleteEntry("1");
        db.close();
        Toast.makeText(this, "Database Successfully Deleted", Toast.LENGTH_SHORT).show();
    }

}
