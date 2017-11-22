package com.example.usuario.dynamicfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener{

    private Fragment fragmentA;
    private Fragment fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentA = fragmentManager.findFragmentByTag("fragmentA");
        if(fragmentA == null) {
            fragmentA = new FragmentA();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, fragmentA, "fragmentA");
            fragmentTransaction.commit();
        }

        Log.d("Activity", "onCreate()");
    }


    @Override
    public void onFragmentAEvent(String mensaje, int size) {

        Bundle bundle = new Bundle();
        bundle.putString("message", mensaje);
        bundle.putInt("size", size);
        //Con el método setArguments se pasa la infromación a un fragment
        //fragmentB.setArguments(bundle);
        // Se debe utilizar el patrón factory donde la creación del objeto y el paso
        // de arguementos se ejecuten consecutivamente
        fragmentB = FragmentB.newInstance(bundle);

        // A continuación se empieza la transacción de FragmentA a FragmentB
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentB, "fragmentB");
        // Antes de realizar el commit se debe guardar la transaccion
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity", "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity", "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity", "onDestroy()");
    }
}
