package com.example.testdriver;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdriver.Config;
import com.example.testdriver.R;
import com.example.testdriver.TSL2591_kotlin;
import com.google.android.things.pio.I2cDevice;
import com.google.android.things.pio.PeripheralManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;



public class MainActivity extends Activity {


    Config con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_main);
        DatabaseReference dataBase;
        dataBase = FirebaseDatabase.getInstance().getReference("Jacina");
        try {
            I2cDevice device = PeripheralManager.getInstance().openI2cDevice("I2C1", 0x29);
            Intrinsics.checkExpressionValueIsNotNull(device, "device");
            TSL2591_kotlin sensor = new TSL2591_kotlin(device);
            sensor.powerOn();
            sensor.setTime(TSL2591_kotlin.TSL2591_INTEGRATIONTIME_400MS);
            sensor.setGain(TSL2591_kotlin.TSL2591_GAIN_HIGH);

            Context context = getApplicationContext();
            Observable<Float> o = sensor.getLux();
            Observer observer = new Observer() {
                @SuppressLint("ShowToast")
                @Override
                public void onSubscribe(Disposable d) {
                    Toast.makeText(context,  "Subscribed", Toast.LENGTH_LONG );
                }

                @SuppressLint("ShowToast")
                @Override
                public void onNext(Object o) {
                    try{
                        Float f = (float)o;
                        //Toast.makeText(context,  String.valueOf(f), Toast.LENGTH_LONG ).show();
                        Log.i("Next", String.valueOf( f) );
                        Config con = new Config(f);
                        dataBase.setValue( con );
                        Toast.makeText( context,"Jacina dodana", Toast.LENGTH_LONG ).show();


                        sensor.powerOff();
                        sensor.close();

                    } catch (Exception e){}
                }


                @SuppressLint("ShowToast")
                @Override
                public void onError(Throwable e) {
                    Toast.makeText(context,  "Error " + e.getMessage(), Toast.LENGTH_LONG ).show();
                    Log.i("MainActivity", "Eror" );
                }

                @SuppressLint("ShowToast")
                @Override
                public void onComplete() {
                    Toast.makeText(context,  "Observable completed", Toast.LENGTH_LONG ).show();
                    Log.i("MainActivity", " " );
                }
            };
            o.subscribe(observer);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}




