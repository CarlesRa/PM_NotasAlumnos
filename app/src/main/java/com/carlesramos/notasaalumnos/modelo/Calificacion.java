package com.carlesramos.notasaalumnos.modelo;

public class Calificacion {
    private String codAssignatura;
    private String nomAssignatura;
    private double notaAlumno;

    public Calificacion(String codAssignatura, String nomAssignatura, double notaAlumno) {
        this.codAssignatura = codAssignatura;
        this.nomAssignatura = nomAssignatura;
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
