package com.carlesramos.notasaalumnos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.carlesramos.notasaalumnos.interfaces.IAlumneListener;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Alumne;

public class AdaptadorAlumnes extends RecyclerView.Adapter<AdaptadorAlumnes.AlumnesViewHolder>{
    private Alumne[] alumnes;
    private IAlumneListener listener;

    public AdaptadorAlumnes(Alumne[] alumnes, IAlumneListener listener) {
        this.alumnes = alumnes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lisitem_alumnos,parent,false);
        return new AlumnesViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnesViewHolder holder, int position) {
        Alumne alumne = alumnes[position];
        holder.bindAlumne(alumne);
    }

    @Override
    public int getItemCount() {
        return alumnes.length;
    }

    public static class AlumnesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvNombre;
        private TextView tvEmail;
        private TextView tvEdad;
        private StringBuilder sb;
        private IAlumneListener listener;



        public AlumnesViewHolder(@NonNull View itemView, IAlumneListener listener) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvEdad = itemView.findViewById(R.id.tvEdad);
            sb = new StringBuilder();
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindAlumne(Alumne a){
            sb.setLength(0);
            sb.append(a.getNom()).append(" ").append(a.getApellido1()).append(" ")
                    .append(a.getApellido2());
            tvNombre.setText(sb.toString());
            tvEmail.setText(a.getEmail());
            tvEdad.setText(String.valueOf(a.getEdad()));
        }

        @Override
        public void onClick(View v) {
            if (this.listener != null){
                this.listener.onAlumnoSelected(getAdapterPosition());
            }
        }
    }
}
