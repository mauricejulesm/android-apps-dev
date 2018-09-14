package com.example.admin_m.recyclerviewfragmentschallenge;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked{

    Button btnCarInfo, btnOwnerInfo;
    ImageView ivMake;
    TextView tvModel, tvName, tvTel;

    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.Fragment buttonFrag;
    android.support.v4.app.Fragment listFrag;
    android.support.v4.app.Fragment carInfoFrag;
    android.support.v4.app.Fragment ownerInfoFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);
        ivMake = findViewById(R.id.ivMake);
        tvModel = findViewById(R.id.tvModel);
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carInfoFrag)
                .hide(ownerInfoFrag)
                .commit();


        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(ownerInfoFrag)
                        .commit();
            }
        });
        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(ownerInfoFrag)
                        .commit();
            }
        });

        // show the first item on the list
        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(ApplicationClass.cars.get(index).getOwnerName());
        tvModel.setText(ApplicationClass.cars.get(index).getModel());
        tvTel.setText(ApplicationClass.cars.get(index).getOwnerTel());

        if(ApplicationClass.cars.get(index).getMake().equals("Volkswagen")){
            ivMake.setImageResource(R.drawable.volkswagen);
        }else if(ApplicationClass.cars.get(index).getMake().equals("Nissa")){
            ivMake.setImageResource(R.drawable.nissan);
        }else {
            ivMake.setImageResource(R.drawable.mercedes);
        }
    }
   }
