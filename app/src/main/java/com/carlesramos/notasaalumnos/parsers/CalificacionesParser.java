package com.carlesramos.notasaalumnos.parsers;

import android.content.Context;

import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Calificacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/////ASO NO SE SI TIRA NI FA FALTA LA VERITAT\\\\\\

public class CalificacionesParser {

    private ArrayList<Calificacion> calificaciones;
    private InputStream aluFile;
    private InputStream asigFile;

    public CalificacionesParser(Context c) {
        this.aluFile = c.getResources().openRawResource(R.raw.alumnos_notas);
        this.asigFile = c.getResources().openRawResource(R.raw.asignaturas);
    }

    public boolean parse(){
        boolean parsed = false;
        String jsonAlu;
        String jsonAsig;
        calificaciones = null;

        try {
            int sizeAlu = aluFile.available();
            int sizeAsig = asigFile.available();
            byte[] bufferAlu = new byte[sizeAlu];
            byte[] bufferAsig = new byte[sizeAsig];
            jsonAlu = new String(bufferAlu, "UTF-8");
            jsonAsig = new String(bufferAsig, "UTF-8");
            JSONTokener tokenerAlu = new JSONTokener(jsonAlu);
            JSONTokener tokenerAsig = new JSONTokener(jsonAsig);
            JSONArray jsonArrayAlu = new JSONArray(tokenerAlu);
            JSONArray jsonArrayAsig = new JSONArray(tokenerAsig);

            for (int i=0; i<jsonArrayAlu.length(); i++){

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsed;
    }
}
