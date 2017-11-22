package com.example.usuario.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentA extends Fragment {

    private FragmentAListener mCallBack;
    private EditText edtMessage;
    private Button btnSize;
    private SeekBar skbSize;

    /**
     * Se define la inerfaz que servirá de contrato entre el Fragment y la Activity
     **/
    public interface FragmentAListener {
        void onFragmentAEvent(String mensaje, int size);
    }


    @Override
    public void onAttach(Activity activity) {
        Log.d("FragmentA", "onAttach()");
        super.onAttach(activity);
        try {
            mCallBack = (FragmentAListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement FragmentAListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("FragmentA", "onCreate()");
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FragmentA", "onCreateView()");
        View view = inflater.inflate(R.layout.fragmenta, container, false);
        edtMessage = view.findViewById(R.id.edtMessage);
        btnSize = view.findViewById(R.id.btnSize);
        skbSize = view.findViewById(R.id.skbSize);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("FragmentA", "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        btnSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.onFragmentAEvent(edtMessage.getText().toString(), skbSize.getProgress());
            }
        });
    }

    /**
     * Este método solo funciona desde la API 23 en adelante.
     * Si se ejecuta en una API inferior NO DA ERROR PERO NO FUNCIONA LA COMUNICACIÓN Activity-Fragment

     @Override public void onAttach(Context context) {
     super.onAttach(context);
     }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("FragmentA", "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("FragmentA", "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("FragmentA", "onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("FragmentA", "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("FragmentA", "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("FragmentA", "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("FragmentA", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("FragmentA", "onDetach");
        mCallBack = null;
        super.onDetach();
    }
}
