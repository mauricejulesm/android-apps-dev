package com.example.admin_m.intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivMood, ivPhone, ivWeb, ivLocation;
    Button btnCreate;
    final int CREATE_CONTACT = 1;
    String name = "", number = "", location = "", web = "", mood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMood = findViewById(R.id.ivMood);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.ivLocation);
        btnCreate = findViewById(R.id.btnCreate);

        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.example.admin_m.intentschallenge.CreateContact.class);
                startActivityForResult(intent, CREATE_CONTACT);
            }
        });
        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);
            }
        });
        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q="+location));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_CONTACT) {
            if (resultCode == RESULT_OK) {
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                location = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                /*
                switch(mood){
                    case "happy":
                        ivMood.setImageResource(R.drawable.happy);
                        break;
                    case "sad":
                        ivMood.setImageResource(R.drawable.sad);
                        break;
                    case "ok":
                        ivMood.setImageResource(R.drawable.ok);
                        break;
                    default:
                        Toast.makeText(this, "Oops! No Data Passed Through !", Toast.LENGTH_SHORT).show();
                }
                */


                if (mood.equals("happy")) {
                    ivMood.setImageResource(R.drawable.happy);
                } else if (mood.equals("sad")) {
                    ivMood.setImageResource(R.drawable.sad);
                } else {
                    ivMood.setImageResource(R.drawable.ok);
                }
            } else {
                Toast.makeText(this, "Oops! No Data Passed Through!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
