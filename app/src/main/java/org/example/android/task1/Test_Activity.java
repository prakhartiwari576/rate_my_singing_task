package org.example.android.task1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;

public class Test_Activity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    ValueEventListener eventListener;
    String name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_frontend);
        reference = FirebaseDatabase.getInstance().getReference().child("User");
        Log.e("prakhar",reference.toString());
        final ArrayList<Custom_Container> words = new ArrayList<Custom_Container>();
//        words.add(new Custom_Container("Vasu", "20"));
//        words.add(new Custom_Container("Mukesh", "57"));
//        words.add(new Custom_Container("Pallav", "26"));
//        words.add(new Custom_Container("Vishal", "18"));
//        words.add(new Custom_Container("Nishant", "23"));
//        words.add(new Custom_Container("Eshan", "9"));
//        words.add(new Custom_Container("Suyash", "29"));
//        words.add(new Custom_Container("Pramod", "45"));
//        words.add(new Custom_Container("Naman", "12"));
//        words.add(new Custom_Container("Prakhar", "20"));
        final Custom_Adapter adapter = new Custom_Adapter(this, words);
        RecyclerView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    String str = snapshot.getKey();

                    for(DataSnapshot snapshot1:snapshot.getChildren()){

                        if(snapshot1.getKey().equals("name")){
                            name = snapshot1.getValue().toString();
                            Log.e("name",name);
                        }
                        if(snapshot1.getKey().equals("age")){
                            age = snapshot1.getValue().toString();
                            Log.e("age",age);
                        }
                    }
                    words.add(new Custom_Container(name,age));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
