package com.carlesramos.notasaalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.carlesramos.notasaalumnos.fragments.FragmentDetalle;
import com.carlesramos.notasaalumnos.modelo.Alumne;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.carlesramos.notasalumnos.EXTRA_TEXTO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        frgDetalle.mostrarDetalle((Alumne)getIntent().getSerializableExtra(EXTRA_TEXTO));
    }
}
