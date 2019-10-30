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
import com.carlesramos.notasaalumnos.modelo.Calificacion;
import com.carlesramos.notasaalumnos.parsers.AlumneParser;
import com.carlesramos.notasaalumnos.parsers.AssignaturaParser;

import java.util.ArrayList;

public class FragmentDetalle extends Fragment {
    private Alumne[] alumnes;
    private Assignatura[] assignaturas;
    private ArrayList<Calificacion> calificaciones;
    private RecyclerView rvClasificaciones;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        calificaciones = new ArrayList<>();
        AssignaturaParser parserAssig = new AssignaturaParser(getActivity());
        AlumneParser parser = new AlumneParser(getActivity());
        if (parser.parse()){
            this.alumnes = parser.getAlumnes();
            for (Alumne a : alumnes){
                for (int i=0; i<a.getCalificaciones().size(); i++){
                    calificaciones.add(a.getCalificaciones().get(i));
                }
            }
        }
        if (parserAssig.parse()){
            this.assignaturas = parserAssig.getAsignatures();
        }
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvClasificaciones = getView().findViewById(R.id.rvDetalle);
        rvClasificaciones.setAdapter(new AdaptadorCalificaciones(calificaciones));
        rvClasificaciones.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    public ArrayList<Calificacion> getCalificaciones(){
        return calificaciones;
    }
}
