package com.example.admin_m.recyclerviewfragmentschallenge;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public  static ArrayList<Car> cars;
    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<>();
        cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "+2154525148"));
        cars.add(new Car("Mercedes", "E235", "Jules Maurice", "+1454544665"));
        cars.add(new Car("Nissan", "Almera", "Emmy Twag", "+98452644512"));
    }
}
