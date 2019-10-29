package com.carlesramos.notasaalumnos.parsers;

import android.content.Context;

import com.carlesramos.notasaalumnos.R;
import com.carlesramos.notasaalumnos.modelo.Assignatura;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class AssignaturaParser {
    private Assignatura[] asignatures;
    private InputStream assignaturesFile;

    public AssignaturaParser(Context c) {
        this.assignaturesFile = c.getResources().openRawResource(R.raw.asignaturas);
        asignatures = null;
    }

    public boolean parse(){
        boolean parsed = false;
        String json;
        try {
            int size = assignaturesFile.available();
            byte[] buffer = new byte[size];
            json = new String(buffer,"UTF-8");
            JSONTokener jsonTokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(jsonTokener);
            asignatures = new Assignatura[jsonArray.length()];

            for (int i=0; i<asignatures.length; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String codAsig = jsonObject.getString("codAsig");
                String nomAsig = jsonObject.getString("nomAsig");
                asignatures[i] = new Assignatura(codAsig,nomAsig);
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public Assignatura[] getAsignatures(){
        return asignatures;
    }
}

