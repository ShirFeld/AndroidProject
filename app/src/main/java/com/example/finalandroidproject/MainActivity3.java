package com.example.finalandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    private Button btn;


    private EditText txt1 , txt3 , txt4 , txt5;
    private String finalRadioButton;
    private DatabaseReference mDatabase;
    private String PERSON_KEY = "Person";



    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked){
                    finalRadioButton = "yes I have";
                    // yes
                    break;
                }

            case R.id.radioButton2:
                if (checked){
                    finalRadioButton = "no I dont have";
                    // no
                    break;
                }

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }
    public void init(){
        txt1 = findViewById(R.id.inputTextM2);  // name
        txt3 = findViewById(R.id.inputTextM14); // age
        txt4 = findViewById(R.id.inputTextM3);  // city
        txt5 = findViewById(R.id.inputTextM12); // phone
        btn = (Button) findViewById(R.id.buttonMain3);
        mDatabase = FirebaseDatabase.getInstance().getReference(PERSON_KEY);
    }



    public void onClickSave(View view) {
        String id = mDatabase.getKey();
        String name = txt1.getText().toString();
        String age =  txt3.getText().toString();
        String city = txt4.getText().toString();
        String phone = txt5.getText().toString();
        String animals = finalRadioButton;
        Person newPerson = new Person(id,name,age,city,animals , phone );


        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(city)
                && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(animals)){   // check if user insert all the data
            mDatabase.push().setValue(newPerson); // insert the user details to database
            Toast.makeText(this,"Your details saved" , Toast.LENGTH_SHORT).show();

            Intent intent =new Intent(MainActivity3.this , MainActivity2.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"You didn't insert all the fields" , Toast.LENGTH_SHORT).show();
        }


    }

}





