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

import com.carlesramos.notasaalumnos.IAlumneListener;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.adapters.AdaptadorAlumnes;
import com.carlesramos.notasaalumnos.modelo.Alumne;
import com.carlesramos.notasaalumnos.parsers.AlumneParser;

public class FragmentListado extends Fragment {
    private Alumne[] alumnes;
    private RecyclerView rvAlumnos;
    private IAlumneListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AlumneParser parser = new AlumneParser(getActivity());
        if (parser.parse()){
            this.alumnes = parser.getAlumnes();
        }
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvAlumnos = getView().findViewById(R.id.rvListado);
        rvAlumnos.setAdapter(new AdaptadorAlumnes(alumnes, listener));
        rvAlumnos.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    public void setAlumnesListener(IAlumneListener listener){
        this.listener = listener;
    }

    public Alumne[] getAlumnes(){
        return alumnes;
    }
}
