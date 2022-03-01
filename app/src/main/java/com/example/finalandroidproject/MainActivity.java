package com.example.finalandroidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {
    //private TextView first;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first = findViewById(R.id.Welcome);
    }


    public void sendToOtherActivity(View view){
        Intent mainIntent = new Intent(this,MainActivity2.class);
        startActivity(mainIntent);
    }


















}