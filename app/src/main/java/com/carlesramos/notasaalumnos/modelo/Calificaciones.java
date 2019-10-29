package com.carlesramos.notasaalumnos.modelo;

public class Calificaciones {
    private String codAssignatura;
    private String nomAssignatura;
    private int notaAlumno;

    public Calificaciones(String codAssignatura, String nomAssignatura, int notaAlumno) {
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

    public int getNotaAlumno() {
        return notaAlumno;
    }
}
