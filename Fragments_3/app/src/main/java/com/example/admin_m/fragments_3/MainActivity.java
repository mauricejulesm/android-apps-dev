package com.example.admin_m.fragments_3;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvDescription;
    String [] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDiscriptioin);

        descriptions = getResources().getStringArray(R.array.descriptions);

        // the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
        // the phone is in landscape mode
        if (findViewById(R.id.layout_land) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    // when a user selects an item on the list
    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);

        //phone is in portrait mode
        if (findViewById(R.id.layout_portrait) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
