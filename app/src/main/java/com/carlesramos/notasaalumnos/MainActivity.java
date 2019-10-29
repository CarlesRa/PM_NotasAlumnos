package com.carlesramos.notasaalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.carlesramos.notasaalumnos.fragments.FragmentListado;

public class MainActivity extends AppCompatActivity implements IAlumneListener{
    private FragmentListado frgListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.rfgListado);
        frgListado.setAlumnesListener(this);
    }

    @Override
    public void onAlumnoSelected(int position) {

    }
}
