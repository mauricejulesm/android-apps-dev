package com.example.admin_m.textfiles_onandroid;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etName, etSurname;
    Button btnAdd, btnSave;
    TextView tvResults;
    String filename = "userdata.txt";

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        tvResults = findViewById(R.id.tvResults);

        people = new ArrayList<>();

        //load data existing in the file
        loadData();
//        setTextToTextView(); // calling this method here will make the app display immediately data that are already on the file
    }

    public void btnAddData(View view) {

        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();

        Person person = new Person(name, surname);
        people.add(person);

        setTextToTextView();
    }

    private void setTextToTextView() {
        String text = "";
        for (int i = 0; i < people.size(); i++) {
            text += people.get(i).getName() + " " + people.get(i).getSurname() + "\n";
        }
        tvResults.setText(text);
    }

    public  void loadData(){

        people.clear();
        File file = getApplicationContext().getFileStreamPath(filename);
        String lineFromFile;

        if (file.exists()){
            try {
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
                String readLine= bufferReader.readLine();
                while (readLine != null){
                    StringTokenizer tokens = new StringTokenizer(readLine, ",");
                    Person person = new Person(tokens.nextToken(), tokens.nextToken());
                    people.add(person);
                }
                bufferReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void btnSaveData(View view) {

        try {
            FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            for (int i = 0; i < people.size(); i++) {
                outputStreamWriter.write(people.get(i).getName() + "," + people.get(i).getSurname() + "\n");
            }

            outputStreamWriter.flush();
            outputStreamWriter.close();
            Toast.makeText(this, "Data Successfully Saved to the File, " + filename + "", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    // in inner class below

    public  class ProcessActivityInBackground extends AsyncTask<Integer, Integer, String>{

        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            return null;

            /*
            put here whatever you want to be done in the background
            usually stuff that will take long time and might make the app to stall.
            */

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
        }
    }
}
