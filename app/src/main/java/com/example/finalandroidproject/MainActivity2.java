package com.example.finalandroidproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {


    public  ListView listView;
    public  ArrayAdapter<String> adapter;
    private List<String> listData;          // Main Page of the Database ----> Names of the objects
    private List<Person> listTemp;          // Another page of Database ----> with all the details of the objects

    private DatabaseReference mDatabase;
    private String PERSON_KEY = "Person";

    private static final int sign_in_from_create = 1; // Status code for sign-in activity





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        getDataFromDB();
        setOnClickItem();




        if(FirebaseAuth.getInstance().getCurrentUser()==null) {  // We check here if the user is logged-in
            /*
            The user is not sign-in.
            option 1 - sign in
            option 2 - register
             */
            Intent signToWebsite = AuthUI.getInstance().createSignInIntentBuilder().build();  // intent is created
            startActivityForResult(signToWebsite,sign_in_from_create);
        }
    }


    // This method will work after onCreate is finished
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == sign_in_from_create) {
            if (resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),"Your in!",Toast.LENGTH_LONG).show();
            }
        }
        /*
       If we log in to else it means that the user could not log in or register and he will not be able to log in to the app
        */
        else{
            Toast.makeText(getApplicationContext(),"Your Sign-in / Sign-up  was unsuccessful",Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void init(){
        listView = findViewById(R.id.am2_list);
        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData); // simple_list_item_1 --> Provides a standard look in the list
        listView.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference(PERSON_KEY);  // Reference to our data base
        listTemp = new ArrayList<>();
    }


    private void getDataFromDB(){
        if (listData.size() > 0) listData.clear();  // If we already have information in the list we will delete it so that we get the updated information again
        if (listTemp.size() > 0) listTemp.clear();
        ValueEventListener vListener = new ValueEventListener() {   // This part talks about Firebase with server and security
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {  // DataSnapshot --> Contains data from our database
                for (DataSnapshot ds : snapshot.getChildren()) {        // Extract specific information
                    Person person = ds.getValue(Person.class);            // Here we will get the information about each user
                    assert person != null ;
                    listData.add(person.getName());
                    listTemp.add(person);
                }

                //We will update our adapter that the information has changed
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        mDatabase.addValueEventListener(vListener);
    }



    // In this function we can click the name of the object and then we will get the rest of the details.
    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person= listTemp.get(position);

                Intent intent = new Intent(MainActivity2.this , ShowActivity.class);
                intent.putExtra("user_name", person.getName());
                intent.putExtra("user_age", person.getAge());
                intent.putExtra("user_city", person.getCity());
                intent.putExtra("user_phone", person.getPhone());
                intent.putExtra("user_animals", person.getHasAnyOtherAnimals());
                startActivity(intent);
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    // menu options
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  // Ae go to the item while the program is running
        if (item.getItemId()==R.id.Feedback)
            Feedback();
        if(item.getItemId()==R.id.Last_page)
            LastPage();
        if (item.getItemId()==R.id.log_out_item)
            logOut();
        return true;
    }



    // menu methods
    private void logOut() { //Task = Asynchronously
        AuthUI.getInstance().signOut(this) // AuthUI.getInstance() -> gives us this user  , this = who to logout
                .addOnCompleteListener(task ->{
                    Toast.makeText(MainActivity2.this,"Logged-out",Toast.LENGTH_LONG).show();  //(where the message will be , what the message is , how much time)
                    MainActivity2.this.finish();
                });

    }

    // video
    private void LastPage() {
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }

    // feed back
    private void Feedback() {
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }

    // move to insert details
    public void sendToProfile(View view){
        Intent mainIntent2 = new Intent(this,MainActivity3.class);
        startActivity(mainIntent2);
    }




}
