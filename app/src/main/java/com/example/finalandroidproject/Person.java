package com.example.finalandroidproject;

import android.widget.EditText;

import java.util.List;

public class Person {
    public String id;
    public String name;
    public String age;
    public String city;
    public String hasAnyOtherAnimals;
    public String phone;
    public static int counter = 0;

    public Person(){}

    public Person(String id , String name, String age, String city, String hasAnyOtherAnimals, String phone) {
        this.id =id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.hasAnyOtherAnimals = hasAnyOtherAnimals;
        this.phone = phone;
        Person.counter++;
    }

    @Override
    public String toString() {
        return name + " ,  " + age + " , " +
                city + " , " + phone +
                " , " + hasAnyOtherAnimals;
    }

}