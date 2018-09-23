package com.example.admin_m.permissionsandroid;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int UNIQUE_REQUEST_CODE = 125; // u can assign it to any number
    Button btnStoragePermission;
    ListView lvRSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStoragePermission = findViewById(R.id.btnStoragePermission);
        lvRSS = findViewById(R.id.lvRSS);


        btnStoragePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ask permission to perform the dangerous permission
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, UNIQUE_REQUEST_CODE);

                } else {
                    Toast.makeText(MainActivity.this, "Permission granted! Thank U!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == UNIQUE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Thank U!, Permission Granted", Toast.LENGTH_SHORT).show();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);

                    dialog.setMessage("This permission is important to save a file to your phone! Please permit it for the services to work property.")
                            .setTitle("Title: Important permission required!");

                    // this button is clicked when the user changes his/her mind and decides to allow the permission.
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // ask for permission again
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, UNIQUE_REQUEST_CODE);

                        }
                    });

                    // this button is clicked when the user stays stubborn!
                    dialog.setNegativeButton("No Thanks.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(MainActivity.this, "Cannot be done!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.show();
                }else {
                    Toast.makeText(MainActivity.this, "We will never show U this again", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}
