package com.carlesramos.notasaalumnos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.notasaalumnos.IAlumneListener;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Alumne;
import com.carlesramos.notasaalumnos.modelo.Assignatura;


public class AdaptadorCalificaciones extends RecyclerView.Adapter<AdaptadorCalificaciones.CalificacionesViewHolder> {
    private Alumne[] alumnes;
    static Assignatura[]assignatures;

    public AdaptadorCalificaciones(Alumne[] alumnes, Assignatura[] assignatures) {
        this.alumnes = alumnes;
        this.assignatures = assignatures;
    }

    @NonNull
    @Override
    public CalificacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_notas,parent,false);
        return new CalificacionesViewHolder(itemView, assignatures);
    }

    @Override
    public void onBindViewHolder(@NonNull CalificacionesViewHolder holder, int position) {
        Alumne alumne = alumnes[position];
        Assignatura[] assignatures = (Assignatura[])alumne.getCalificacions().keySet().toArray();

        holder.bindCalificaciones(assignatures);

    }

    @Override
    public int getItemCount() {
        return assignatures.length;
    }

    public static class CalificacionesViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCodAsig;
        private TextView tvNomAsig;
        private TextView tvNota;
        private IAlumneListener listener;


        public CalificacionesViewHolder(@NonNull View itemView, Assignatura[] assignatures) {
            super(itemView);
            tvCodAsig = itemView.findViewById(R.id.tvCodAsig);
            tvNomAsig = itemView.findViewById(R.id.tvCodAsig);
            tvNota = itemView.findViewById(R.id.tvNota);
        }

        public void bindCalificaciones(Alumne a, int position){

            tvCodAsig.setText(assignatures[position].getCodAssignatura());
            tvNomAsig.setText(assignatures[position].getNomAssignatura());
            tvNomAsig.setText(String.valueOf(a.getCalificacions()
                    .get(assignatures[position].getCodAssignatura())));
        }



    }
}
