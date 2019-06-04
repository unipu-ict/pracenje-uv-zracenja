package com.example.mob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class Glavni extends Fragment {
    Long rez;
    public Glavni() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate( R.layout.fragment_glavni, container, false );

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference();
        DatabaseReference hotelRef = reff.child("rez");


        reff = FirebaseDatabase.getInstance().getReference( "Jacina" );
        reff.addValueEventListener( new ValueEventListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    rez = ds.getValue(Long.class);
                    Integer rezultat = getArguments().getInt( "rezultat" );

                    TextView textView = (TextView) v.findViewById( R.id.textView4 );
                    TextView textViewdod = (TextView) v.findViewById( R.id.textViewdod);
                    TextView textViewspf = (TextView) v.findViewById( R.id.textViewspf);
                    TextView textViewboja = (TextView) v.findViewById( R.id.textViewboja);
                    Button nazad = (Button) v.findViewById( R.id.buttonnazad );
                    nazad.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Fragment fra = new Ulaz();
                            FragmentManager fma = getFragmentManager();
                            FragmentTransaction fta = fma.beginTransaction();
                            Bundle args = new Bundle();
                            fra.setArguments(args);
                            fta.replace(R.id.FrameContainer, fra);
                            fta.commit();
                        }
                    } );
                    if ((rez >= 0 && rez <= 50) && rezultat == 1 ){
                        textView.setText( " " + 1);
                        textViewdod.setText( "Naočale" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Jako svijetla koža" );
                    }
                    if ((rez >= 0 && rez <= 50) && rezultat == 2 ){
                        textView.setText( " " + 1 );
                        textViewdod.setText( "Naočale" );
                        textViewspf.setText( "15 SPF" );
                        textViewboja.setText( "Svijetla koža" );
                    }
                    if ((rez >= 0 && rez <= 50) && rezultat == 3 ){
                        textView.setText( " " + 1 );
                        textViewdod.setText( "Naočale" );
                        textViewspf.setText( "15 SPF" );
                        textViewboja.setText( "Srednje svijetla koža" );
                    }
                    if ((rez >= 0 && rez <= 50) && rezultat == 4 ){
                        textView.setText( " " + 1 );
                        textViewdod.setText( "Naočale" );
                        textViewspf.setText( "8-14 SPF" );
                        textViewboja.setText( "Tamna koža" );
                    }
                    if ((rez >= 0 && rez <= 50) && rezultat == 5 ){
                        textView.setText( "" + 1 );
                        textViewdod.setText( "Naočale" );
                        textViewspf.setText( "8-14 SPF" );
                        textViewboja.setText( "Jako tamna koža" );
                    }


                    if ((rez >= 51 && rez <= 100) && rezultat == 1 ){
                        textView.setText( " " + 2 );
                        textViewdod.setText( "Naočale i šešir" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Jako svijetla koža" );
                    }
                    if ((rez >= 51 && rez <= 100 ) && rezultat == 2 ){
                        textView.setText( " " + 2 );
                        textViewdod.setText( "Naočale i šešir" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Svijetla koža" );
                    }
                    if ((rez >= 51 && rez <= 100 ) && rezultat == 3 ){
                        textView.setText( " " + 2 );
                        textViewdod.setText( "Naočale i šešir" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Srednje svijetla koža" );
                    }
                    if ((rez >= 51 && rez <= 100) && rezultat == 4 ){
                        textView.setText( " " + 2 );
                        textViewdod.setText( "Naočale i šešir" );
                        textViewspf.setText( "15 SPF" );
                        textViewboja.setText( "Tamna koža" );
                    }
                    if ((rez >= 51 && rez <= 100) && rezultat == 5 ){
                        textView.setText( " " + 2 );
                        textViewdod.setText( "Naočale i šešir" );
                        textViewspf.setText( "8-14 SPF" );
                        textViewboja.setText( "Jako tamna koža" );
                    }

                    if ((rez >= 101 && rez <= 150) && rezultat == 1 ){
                        textView.setText( " " + 3);
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50+ SPF" );
                        textViewboja.setText( "Jako svijetla koža" );
                    }
                    if ((rez >= 101 && rez <= 150) && rezultat == 2 ){
                        textView.setText( " " + 3 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50+ SPF" );
                        textViewboja.setText( "Svijetla koža" );
                    }
                    if ((rez >= 101 && rez <= 150) && rezultat == 3 ){
                        textView.setText( " " + 3 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Srednje svijetla koža" );
                    }
                    if ((rez >= 101 && rez <= 150 ) && rezultat == 4 ){
                        textView.setText( " " + 3 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "15 SPF" );
                        textViewboja.setText( "Tamna koža" );
                    }
                    if ((rez >= 101 && rez <= 150) && rezultat == 5 ){
                        textView.setText( " " + 3 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "15 SPF" );
                        textViewboja.setText( "Jako tamna koža" );
                    }

                    if ((rez >= 151 && rez <= 200)&& rezultat == 1 ){
                        textView.setText( " " + 4);
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50-100 SPF" );
                        textViewboja.setText( "Jako svijetla koža" );
                    }
                    if ((rez >= 151 && rez <= 200) && rezultat == 2 ){
                        textView.setText( " " + 4 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50+ SPF" );
                        textViewboja.setText( "Svijetla koža" );
                    }

                    if ((rez >= 151 && rez <= 200) && rezultat == 3 ){
                        textView.setText( " " + 4 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Srednje svijetla koža" );
                    }
                    if ((rez >= 151 && rez <= 200) && rezultat == 4 ){
                        textView.setText( " " + 4 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Tamna koža" );
                    }
                    if ((rez >= 151 && rez <= 200) && rezultat == 5 ){
                        textView.setText( " " + 4 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "15 SPF" );
                        textViewboja.setText( "Jako tamna koža" );
                    }

                    if ((rez >= 201 && rez <= 250)  && (rezultat == 1 || rezultat == 2 ||rezultat == 3 )){
                        textView.setText( " " + 5 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50-100 SPF" );
                        if(rezultat == 1){
                            textViewboja.setText( "Jako svijetla koža" );
                        }
                        if(rezultat == 2){
                            textViewboja.setText( "Svijetla koža" );
                        }
                        if(rezultat == 3) {
                            textViewboja.setText( "Srednje svijetla koža" );
                        }
                    }
                    if ((rez >= 251 && rez <= 300)  && rezultat == 4) {
                        textView.setText( " " + 6 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50+ SPF" );
                        textViewboja.setText( "Tamna koža" );
                    }

                    if ((rez >= 251 && rez <= 300)  && rezultat == 5) {
                        textView.setText( " " + 7 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "30 SPF" );
                        textViewboja.setText( "Tamna koža" );
                    }

                    if (rez >= 301 && rez <= 350){
                        textView.setText( " " + 8 );
                        textViewdod.setText( "Naočale, šešir, držati se sjene" );
                        textViewspf.setText( "50-100 SPF" );
                        if(rezultat == 1) {
                            textViewboja.setText( "Jako svijetla koža" );
                        }
                        if(rezultat == 2) {
                            textViewboja.setText( "Svijetla koža" );
                        }
                        if(rezultat == 3) {
                            textViewboja.setText( "Srednje svijetla koža" );
                        }
                        if(rezultat == 4) {
                            textViewboja.setText( "Tamna koža" );
                        }
                        if(rezultat == 5) {
                            textViewboja.setText( "Jako tamna koža" );
                        }
                    }
                    if (rez >= 351){
                        textView.setText( " " + 9);
                        textViewdod.setText( "Naočale, šešir, držati se sjene, izbjegavati izlaziti između 10:00 i 16:00 sati" );
                        textViewspf.setText( "100 SPF" );
                        if(rezultat == 1) {
                            textViewboja.setText( "Jako svijetla koža" );
                        }
                        if(rezultat == 2) {
                            textViewboja.setText( "Svijetla koža" );
                        }
                        if(rezultat == 3) {
                            textViewboja.setText( "Srednje svijetla koža" );
                        }
                        if(rezultat == 4) {
                            textViewboja.setText( "Tamna koža" );
                        }
                        if(rezultat == 5) {
                            textViewboja.setText( "Jako tamna koža" );
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w( "TAG", "Fall" );
            }
        } );
    return v;
    }
}


