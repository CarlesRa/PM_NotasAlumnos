package com.carlesramos.notasaalumnos.modelo;

import java.io.Serializable;

public class Calificacion implements Serializable{
    private String codAssignatura;
    private String nomAssignatura;
    private double notaAlumno;

    public Calificacion(String codAssignatura,String nombre, double notaAlumno) {
        this.codAssignatura = codAssignatura;
        this.nomAssignatura = nombre;
        this.notaAlumno = notaAlumno;
    }

    public String getCodAssignatura() {
        return codAssignatura;
    }

    public String getNomAssignatura() {
        return nomAssignatura;
    }

    public double getNotaAlumno() {
        return notaAlumno;
    }
}
