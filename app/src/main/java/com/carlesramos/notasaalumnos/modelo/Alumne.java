package com.carlesramos.notasaalumnos.modelo;

import com.carlesramos.notasaalumnos.utils.Lib;

import java.io.Serializable;

public class Alumne implements Serializable {
    private int nia;
    private String nom;
    private String apellido1;
    private String apellido2;
    private String fechaNac;
    private int edad;
    private String email;
    private Calificacion[] calificaciones;

    public Alumne(int nia, String nom, String apellido1, String apellido2, String fechaNac
            , String email, Calificacion[] calificaciones) {
        this.nia = nia;
        this.nom = nom;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.email = email;
        this.calificaciones = calificaciones;
        edad = Lib.calcularEdat(this.fechaNac);
    }

    public int getNia() {
        return nia;
    }

    public String getNom() {
        return nom;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public Calificacion[] getCalificaciones(){
        return calificaciones;
    }
}
