package com.carlesramos.notasaalumnos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.adapters.AdaptadorCalificaciones;
import com.carlesramos.notasaalumnos.modelo.Alumne;
import com.carlesramos.notasaalumnos.modelo.Calificacion;
import java.util.ArrayList;

public class FragmentDetalle extends Fragment {
    private ArrayList<Calificacion> calificaciones;
    private RecyclerView rvClasificaciones;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calificaciones = new ArrayList<>();
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }

    public void mostrarDetalle(Alumne a){
        this.calificaciones = a.getCalificaciones();
        rvClasificaciones = getView().findViewById(R.id.rvDetalle);
        rvClasificaciones.setAdapter(new AdaptadorCalificaciones(calificaciones));
        rvClasificaciones.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }
}
