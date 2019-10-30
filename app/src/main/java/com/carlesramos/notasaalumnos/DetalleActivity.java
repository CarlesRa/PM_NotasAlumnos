package com.carlesramos.notasaalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.carlesramos.notasaalumnos.fragments.FragmentDetalle;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
    }
}
