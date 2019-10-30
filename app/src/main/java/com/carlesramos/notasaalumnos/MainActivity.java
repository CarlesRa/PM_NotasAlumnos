package com.carlesramos.notasaalumnos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.carlesramos.notasaalumnos.fragments.FragmentDetalle;
import com.carlesramos.notasaalumnos.fragments.FragmentListado;
import com.carlesramos.notasaalumnos.interfaces.IAlumneListener;

public class MainActivity extends AppCompatActivity implements IAlumneListener {
    private FragmentListado frgListado;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        frgListado.setAlumnesListener(this);
    }

    @Override
    public void onAlumnoSelected(int position) {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frgDetalle) != null);
        if (hayDetalle){
            FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        }
        else{
            Intent i = new Intent(this, DetalleActivity.class);
            startActivity(i);
        }
    }
}
