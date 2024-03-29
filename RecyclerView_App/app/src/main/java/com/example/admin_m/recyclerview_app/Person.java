package com.example.admin_m.recyclerview_app;

public class Person {
    private String name;
    private String surname;
    private String preference; // this person takes the bus on the plane.

    public Person(String name, String surname, String preference) {
        this.name = name;
        this.surname = surname;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
