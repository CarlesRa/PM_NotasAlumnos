package com.carlesramos.notasaalumnos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.notasaalumnos.IAlumneListener;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Calificacion;

import java.util.ArrayList;


public class AdaptadorCalificaciones extends RecyclerView.Adapter<AdaptadorCalificaciones.CalificacionesViewHolder> {
    private ArrayList<Calificacion>calificaciones;

    public AdaptadorCalificaciones(ArrayList<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @NonNull
    @Override
    public CalificacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_notas,parent,false);
        return new CalificacionesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CalificacionesViewHolder holder, int position) {
        Calificacion calificacion = calificaciones.get(position);
        holder.bindCalificaciones(calificacion);

    }

    @Override
    public int getItemCount() {
        return calificaciones.size();
    }

    public static class CalificacionesViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCodAsig;
        private TextView tvNomAsig;
        private TextView tvNota;
        private IAlumneListener listener;


        public CalificacionesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodAsig = itemView.findViewById(R.id.tvCodAsig);
            tvNomAsig = itemView.findViewById(R.id.tvCodAsig);
            tvNota = itemView.findViewById(R.id.tvNota);
        }
        //TODO aqui esta el problema la calificacion llega nula.
        public void bindCalificaciones(Calificacion c){

            tvCodAsig.setText(c.getCodAssignatura());
            tvNomAsig.setText(c.getNomAssignatura());
            tvNomAsig.setText(String.valueOf(c.getNotaAlumno()));
        }



    }
}
