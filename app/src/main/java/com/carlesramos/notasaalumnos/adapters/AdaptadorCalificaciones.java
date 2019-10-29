package com.carlesramos.notasaalumnos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.notasaalumnos.IAlumneListener;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Assignatura;
import com.carlesramos.notasaalumnos.modelo.Calificacion;


public class AdaptadorCalificaciones extends RecyclerView.Adapter<AdaptadorCalificaciones.CalificacionesViewHolder> {
    private Calificacion[]calificaciones;

    public AdaptadorCalificaciones(Calificacion[] calificaciones, Assignatura[] assignatures) {
        this.calificaciones = calificaciones;
    }

    @NonNull
    @Override
    public CalificacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_notas,parent,false);
        return new CalificacionesViewHolder(itemView, calificaciones);
    }

    @Override
    public void onBindViewHolder(@NonNull CalificacionesViewHolder holder, int position) {
        Calificacion calificacion = calificaciones[position];
        holder.bindCalificaciones(calificacion);

    }

    @Override
    public int getItemCount() {
        return calificaciones.length;
    }

    public static class CalificacionesViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCodAsig;
        private TextView tvNomAsig;
        private TextView tvNota;
        private IAlumneListener listener;


        public CalificacionesViewHolder(@NonNull View itemView, Calificacion[] calificaciones) {
            super(itemView);
            tvCodAsig = itemView.findViewById(R.id.tvCodAsig);
            tvNomAsig = itemView.findViewById(R.id.tvCodAsig);
            tvNota = itemView.findViewById(R.id.tvNota);
        }

        public void bindCalificaciones(Calificacion c){

            tvCodAsig.setText(c.getCodAssignatura());
            tvNomAsig.setText(c.getNomAssignatura());
            tvNomAsig.setText(String.valueOf(c.getNotaAlumno()));
        }



    }
}
