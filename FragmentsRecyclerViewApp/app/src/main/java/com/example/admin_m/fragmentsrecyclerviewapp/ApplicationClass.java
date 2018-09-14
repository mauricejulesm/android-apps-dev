package com.example.admin_m.fragmentsrecyclerviewapp;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application{

    public  static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<>();
        people.add(new Person("Chuck Norris", "+2305664787"));
        people.add(new Person("Jules Maurice", "+258778562"));
        people.add(new Person("Ndoli Vincent", "+1(484)51274"));
    }
}
