package com.example.mob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class Ulaz extends Fragment {
    Context ctx;
    public Ulaz() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_ulaz, container,false );
        ctx = getActivity();
        ImageButton jsvjetlo = (ImageButton) v.findViewById( R.id.imageButtonjs );
        ImageButton svjetlo = (ImageButton) v.findViewById( R.id.imageButtons );
        ImageButton ssvjetlo = (ImageButton) v.findViewById( R.id.imageButtonss );
        ImageButton tamno = (ImageButton) v.findViewById( R.id.imageButtont);
        ImageButton jtamno = (ImageButton) v.findViewById( R.id.imageButtonjt );

        jsvjetlo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new Glavni();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle args = new Bundle();
                args.putInt("rezultat", 1 );
                fr.setArguments(args);
                ft.replace(R.id.FrameContainer, fr);
                ft.commit();
            }
        } );
        svjetlo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new Glavni();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle args = new Bundle();
                args.putInt("rezultat", 2 );
                fr.setArguments(args);
                ft.replace(R.id.FrameContainer, fr);
                ft.commit();
            }
        } );
        ssvjetlo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new Glavni();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle args = new Bundle();
                args.putInt("rezultat", 3 );
                fr.setArguments(args);
                ft.replace(R.id.FrameContainer, fr);
                ft.commit();
            }
        } );
        tamno.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new Glavni();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle args = new Bundle();
                args.putInt("rezultat", 4 );
                fr.setArguments(args);
                ft.replace(R.id.FrameContainer, fr);
                ft.commit();
            }
        } );
        jtamno.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr = new Glavni();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle args = new Bundle();
                args.putInt("rezultat", 5 );
                fr.setArguments(args);
                ft.replace(R.id.FrameContainer, fr);
                ft.commit();
            }
        } );

        return v;
    }
}

