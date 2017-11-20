package com.example.usuario.dynamicfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentA, "fragmentA");
        fragmentTransaction.commit();

    }


    @Override
    public void onFragmentAEvent(String mensaje, int size) {

        fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("message", mensaje);
        bundle.putInt("size", size);
        //Con el método setArguments se pasa la infromación a un fragment
        fragmentB.setArguments(bundle);
        // A continuación se empieza la transacción de FragmentA a FragmentB
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentB, "fragmentB");
        fragmentTransaction.commit();

    }
}
