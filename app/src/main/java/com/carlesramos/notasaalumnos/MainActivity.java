package com.carlesramos.notasaalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.carlesramos.notasaalumnos.fragments.FragmentListado;

public class MainActivity extends AppCompatActivity implements IAlumneListener{
    private FragmentListado frgListado;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*tv = findViewById(R.id.tv);
        tv.setText("Eres un capullo");*/
        frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        //frgListado.setAlumnesListener(this);
    }

    @Override
    public void onAlumnoSelected(int position) {

    }
}
