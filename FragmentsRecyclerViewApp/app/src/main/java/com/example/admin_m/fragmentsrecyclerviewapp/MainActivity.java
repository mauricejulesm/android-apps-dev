package com.example.admin_m.fragmentsrecyclerviewapp;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked{

    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAdd;

    ListFrag listFrag;
    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        etTel = findViewById(R.id.etTel);
        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etName.getText().toString().isEmpty() || etTel.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Please fill both Fields", Toast.LENGTH_SHORT).show();
                }else{
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etTel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Contact Successfully Added", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etTel.setText(null);
                    listFrag.notifyDataChanged();
                }
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        tvName.setText(ApplicationClass.people.get(index).getName());
        tvTel.setText(ApplicationClass.people.get(index).getTelNumber());
    }
}
