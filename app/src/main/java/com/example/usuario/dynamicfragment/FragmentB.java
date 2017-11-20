package com.example.usuario.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentB extends Fragment {

    private TextView txvTexto;
    private String message;
    private int size;

    @Override
    public void onAttach(Activity activity) {
        Log.d("FragmentB", "onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("FragmentB", "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FragmentB", "onCreateView()");
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        txvTexto = view.findViewById(R.id.txvTexto);
        return view;
    }

    public void changeTextAndSize(String message, int size){
        txvTexto.setText(message);
        txvTexto.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d("FragmentB", "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            changeTextAndSize(bundle.getString("message"), bundle.getInt("size"));
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("FragmentB", "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            changeTextAndSize(savedInstanceState.getString("message"), savedInstanceState.getInt("size"));
        }
    }

    @Override
    public void onStart() {
        Log.d("FragmentB", "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("FragmentB", "onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("FragmentB", "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("FragmentB", "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("FragmentB", "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("FragmentB", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("FragmentB", "onDetach");
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message", txvTexto.getText().toString());
        outState.putFloat("size", txvTexto.getTextSize());
    }

}
