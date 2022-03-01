package com.example.finalandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView txt1 , txt2 , txt3 ,txt4 , txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        getItem();
    }


    public void init(){
        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);
        txt5 = findViewById(R.id.textView5);

    }

    private void getItem(){
        Intent intent = getIntent();
        if (intent != null){
            txt1.setText(intent.getStringExtra("user_name"));
            txt2.setText(intent.getStringExtra("user_age"));
            txt3.setText(intent.getStringExtra("user_city"));
            txt4.setText(intent.getStringExtra("user_phone"));
            txt5.setText(intent.getStringExtra("user_animals"));

        }
    }


}