package com.carlesramos.notasaalumnos.parsers;

import android.content.Context;
import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Alumne;
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
    private ArrayList<Calificacion> calificaciones;
    private InputStream alumnesFile;

    public AlumneParser(Context c) {
        this.alumnesFile = c.getResources().openRawResource(R.raw.alumnos_notas);
    }

    public boolean parse(){

        boolean parsed = false;
        String json;
        //alumnes = null;
        calificaciones = null;

        try {
            //alumnes
            int size = alumnesFile.available();
            byte[] buffer = new byte[size];
            alumnesFile.read(buffer);
            alumnesFile.close();
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
                    calificaciones.add(new Calificacion(codAsig,nombre,nota));
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

}
