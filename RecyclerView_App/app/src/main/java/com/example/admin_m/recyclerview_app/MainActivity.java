package com.example.admin_m.recyclerview_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked{

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Susan", "Peters", "bus"));
                myAdapter.notifyDataSetChanged();
            }
        });


        layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<>();
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Chuck", "Norris", "flight"));
        people.add(new Person("Jules Maurice", "Mulisa", "bus"));

        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: "+ people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}
