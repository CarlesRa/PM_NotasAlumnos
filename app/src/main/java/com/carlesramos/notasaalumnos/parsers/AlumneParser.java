package com.carlesramos.notasaalumnos.parsers;

import android.content.Context;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Alumne;
import com.carlesramos.notasaalumnos.modelo.Assignatura;
import com.carlesramos.notasaalumnos.modelo.Calificacion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AlumneParser {
    private Alumne[] alumnes;
    private Assignatura[] asignatures;
    private ArrayList<Calificacion> calificaciones;
    private InputStream alumnesFile;

    private InputStream asigFile;

    public AlumneParser(Context c) {
        this.alumnesFile = c.getResources().openRawResource(R.raw.alumnos_notas);
        this.asigFile = c.getResources().openRawResource(R.raw.asignaturas);
    }

    public boolean parse(){

        boolean parsed = false;
        String json;
        String jsonAssig;

        try {
            //assignatures
            int sizeAssig = asigFile.available();
            byte[] bufferAssig = new byte[sizeAssig];
            asigFile.read(bufferAssig);
            jsonAssig = new String(bufferAssig,"UTF-8");
            JSONTokener jsonTokenerAssig = new JSONTokener(jsonAssig);
            JSONArray jsonArrayAssig = new JSONArray(jsonTokenerAssig);
            asignatures = new Assignatura[jsonArrayAssig.length()];

            for (int i=0; i<asignatures.length; i++){
                JSONObject jsonObject = jsonArrayAssig.getJSONObject(i);
                String codAsig = jsonObject.getString("codAsig");
                String nomAsig = jsonObject.getString("nomAsig");
                asignatures[i] = new Assignatura(codAsig,nomAsig);
            }

            //alumne
            int size = alumnesFile.available();
            byte[] buffer = new byte[size];
            alumnesFile.read(buffer);
            json = new String(buffer,"UTF-8");
            JSONTokener jsonTokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(jsonTokener);
            alumnes = new Alumne[jsonArray.length()];



            for (int i=0; i<alumnes.length; i++){
                JSONObject jsonAlumne = jsonArray.getJSONObject(i);
                int nia = jsonAlumne.getInt("nia");
                String nombre = jsonAlumne.getString("nombre");
                String apellido1 = jsonAlumne.getString("apellido1");
                String apellido2 = jsonAlumne.getString("apellido2");
                String fechaNac = jsonAlumne.getString("fechaNacimiento");
                String email = jsonAlumne.getString("email");
                JSONArray jsonArrayNotas = jsonAlumne.getJSONArray("notas");
                calificaciones = new ArrayList<>();
                //recorrem les calificacions
                for (int z=0; z<jsonArrayNotas.length(); z++){

                    JSONObject jsonNotas = jsonArrayNotas.getJSONObject(z);
                    double nota = jsonNotas.getDouble("calificacion");
                    String codAsig = jsonNotas.getString("codAsig");
                    calificaciones.add(new Calificacion(codAsig,getNomAssignatura(codAsig,asignatures), nota));
                }
                alumnes[i] = new Alumne(nia,nombre,apellido1,apellido2,
                        fechaNac,email,calificaciones);
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsed;
    }

    public Alumne[] getAlumnes(){
        return alumnes;
    }

    public String getNomAssignatura(String codAssig, Assignatura[] asignaturas){
        String nom = null;
        for (int i=0; i<asignaturas.length; i++){
            if (asignaturas[i].getCodAssignatura().equals(codAssig)){
                nom = asignaturas[i].getNomAssignatura();
                return nom;
            }
        }
        return nom;
    }
}
