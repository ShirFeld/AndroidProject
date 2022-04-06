package com.example.finalandroidproject;

import android.widget.EditText;

import java.util.List;

public class Person {
    private String id;
    private String name;
    private String age;
    private String city;
    private String hasAnyOtherAnimals;
    private String phone;
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

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAge(){
        return this.age;
    }
    public String getCity(){
        return this.city;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getHasAnyOtherAnimals() {
        return this.id;
    }


    @Override
    public String toString() {
        return name + " ,  " + age + " , " +
                city + " , " + phone +
                " , " + hasAnyOtherAnimals;
    }

}