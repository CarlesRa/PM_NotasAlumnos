package com.carlesramos.notasaalumnos.modelo;

public class Assignatura {
    private String codAssignatura;
    private String nomAssignatura;

    public Assignatura(String codAssignatura, String nomAssignatura) {
        this.codAssignatura = codAssignatura;
        this.nomAssignatura = nomAssignatura;

    }

    public String getNomAssignatura() {
        return nomAssignatura;
    }

    public String getCodAssignatura() {
        return codAssignatura;
    }

}
