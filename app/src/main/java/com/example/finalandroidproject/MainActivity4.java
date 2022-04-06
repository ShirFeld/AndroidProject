

 package com.example.finalandroidproject;

 import androidx.appcompat.app.AlertDialog;
 import androidx.appcompat.app.AppCompatActivity;

 import android.annotation.SuppressLint;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.content.SharedPreferences;
 import android.os.Bundle;
 import android.os.Handler;
 import android.util.Log;
 import android.view.View;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.CompoundButton;
 import android.widget.ImageButton;
 import android.widget.Toast;

 import com.google.android.material.snackbar.BaseTransientBottomBar;
 import com.google.android.material.snackbar.Snackbar;

 public class MainActivity4 extends AppCompatActivity {

     private Button alretBtton;
     private CheckBox c1;
     private CheckBox c2;
     private CheckBox c3;
     private CheckBox c4;
     private CheckBox c5;
     private CheckBox c6;



     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main4);
         this.c1 = findViewById(R.id.checkBox);
         this.c2 = findViewById(R.id.checkBox2);
         this.c3 = findViewById(R.id.checkBox3);
         this.c4 = findViewById(R.id.checkBox4);
         this.c5 = findViewById(R.id.checkBox5);
         this.c6 = findViewById(R.id.checkBox6);

         this.alretBtton = this.findViewById(R.id.imageButton_main4);

         buttonStartThread = findViewById(R.id.imageButton_main4);

         // message to user & check the checkbox
         alretBtton.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view){
                 startThread(view);
                 //shared preferences will store all checkbox state
                 @SuppressLint("CommitPrefEdits")

                 SharedPreferences.Editor editor=getSharedPreferences("PREFERENCE1",MODE_PRIVATE).edit();
                 editor.putBoolean("C1",c1.isChecked());
                 editor.putBoolean("C2",c2.isChecked());
                 editor.putBoolean("C3",c3.isChecked());
                 editor.putBoolean("C4",c4.isChecked());
                 editor.putBoolean("C5",c5.isChecked());
                 editor.putBoolean("C6",c6.isChecked());
                 editor.apply();
//        Toast.makeText(MainActivity4.this,"CK STATE SAVED",Toast.LENGTH_SHORT).show();
                 Snackbar mySnackbar = Snackbar.make(view, "Thank you for your time ", BaseTransientBottomBar.LENGTH_LONG);
                 mySnackbar.show();

             }
         });

//        // Retrieve the checkbox state value from shared-preference and apply it to checkboxes

         SharedPreferences sharedPreferences=getSharedPreferences("PREFERENCE1",MODE_PRIVATE);
         //get values
         boolean c1_state=sharedPreferences.getBoolean("C1",false);
         boolean c2_state=sharedPreferences.getBoolean("C2",false);
         boolean c3_state=sharedPreferences.getBoolean("C3",false);
         boolean c4_state=sharedPreferences.getBoolean("C4",false);
         boolean c5_state=sharedPreferences.getBoolean("C5",false);
         boolean c6_state=sharedPreferences.getBoolean("C6",false);

         //set values
         c1.setChecked(c1_state);
         c2.setChecked(c2_state);
         c3.setChecked(c3_state);
         c4.setChecked(c4_state);
         c5.setChecked(c5_state);
         c6.setChecked(c6_state);
     }

     private static final String TAG = "MainActivity4";
     private Button buttonStartThread;

     private Handler mainHandler = new Handler();



     // When the button is pressed the countdown will begin
     public void startThread(View view){
         ExampleRunnable runnable = new ExampleRunnable(6);
         new Thread(runnable).start();
     }

     class ExampleRunnable implements Runnable{

         ExampleRunnable(int seconds){
             this.seconds=seconds;
         }
         int seconds;
         @Override
         public void run() {
             for (int i = 0; i < seconds; i++) {
                 if(i == 0){
                     mainHandler.post(new Runnable() {
                         @Override
                         public void run() {
                             buttonStartThread.setText("5");
                         }
                     });
                 }
                 if(i == 1){
                     mainHandler.post(new Runnable() {
                         @Override
                         public void run() {
                             buttonStartThread.setText("4");
                         }
                     });
                 }
                 if(i == 2){
                     mainHandler.post(new Runnable() {
                         @Override
                         public void run() {
                             buttonStartThread.setText("3");
                         }
                     });
                 }
                 if(i == 3){
                     mainHandler.post(new Runnable() {
                         @Override
                         public void run() {
                             buttonStartThread.setText("2");
                         }
                     });
                 }
                 if(i == 4){
                     mainHandler.post(new Runnable() {
                         @Override
                         public void run() {
                             buttonStartThread.setText("1");
                         }
                     });
                 }
                 if(i == 5){
                     mainHandler.post(new Runnable() {
                         @Override
                         public void run() {
                             buttonStartThread.setText("0");
                         }
                     });
                     Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                     startActivity(intent);
                 }

                 Log.d(TAG, "startThread: "+i);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

 }


/*
We had saved checkbox values in the devices' internal storage with the help of SharedPreference.
So If the user completely closes the app and restarts the app then also all checkbox values will
be in the saved state.

 */