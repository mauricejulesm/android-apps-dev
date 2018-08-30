package com.example.admin_m.idcardapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etID = findViewById(R.id.editText);
        btnSubmit = findViewById(R.id.button);
        tvResults = findViewById(R.id.textView);

        tvResults.setVisibility(View.GONE);
        /**
         * getting user's inputs when they click submit button.
         */
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = etID.getText().toString().trim();
                String dob = idNumber.substring(0, 6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if(gender<5)
                    sGender = getString(R.string.female);
                else
                    sGender = getString(R.string.male);
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;
                if (nationality == 0)
                    sNationality = getString(R.string.sacitizen);
                else
                    sNationality = getString(R.string.permanentresident);

                String text = getString(R.string.dob) +" "+ dob + "\n"+
                        getString(R.string.gender) +" "+ sGender+ "\n" +
                        getString(R.string.nationality) +" "+ sNationality;
                tvResults.setText(text);

                tvResults.setVisibility(View.VISIBLE);

            }
        });
    }
}
