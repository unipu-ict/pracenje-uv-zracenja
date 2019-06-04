package com.example.mob;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        if(findViewById(R.id.FrameContainer) != null) {
            if(savedInstanceState != null) {
                return;
            }
            Ulaz prvi = new Ulaz();
            getSupportFragmentManager().beginTransaction().add(R.id.FrameContainer, prvi).commit();
        }
    }
}
