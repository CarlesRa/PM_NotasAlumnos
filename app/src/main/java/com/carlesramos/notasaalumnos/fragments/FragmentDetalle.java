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
import com.carlesramos.notasaalumnos.modelo.Assignatura;
import com.carlesramos.notasaalumnos.parsers.AlumneParser;
import com.carlesramos.notasaalumnos.parsers.AssignaturaParser;

public class FragmentDetalle extends Fragment {
    private Assignatura[]assignatures;
    private Alumne[]alumnes;
    private RecyclerView rvClasificaciones;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AssignaturaParser parser = new AssignaturaParser(getActivity());
        AlumneParser alumneParser = new AlumneParser(getActivity());
        if (parser.parse()){
            this.assignatures = parser.getAsignatures();
        }
        if (alumneParser.parse()){
            this.alumnes = alumneParser.getAlumnes();
        }
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvClasificaciones = getView().findViewById(R.id.rvDetalle);
        rvClasificaciones.setAdapter(new AdaptadorCalificaciones(alumnes,assignatures));
        rvClasificaciones.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    public Assignatura[] getAssignatures(){
        return assignatures;
    }
}
