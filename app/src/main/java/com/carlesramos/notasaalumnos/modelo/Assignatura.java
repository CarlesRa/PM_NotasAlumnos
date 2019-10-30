package com.carlesramos.notasaalumnos.modelo;

import java.io.Serializable;

public class Assignatura implements Serializable {
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
