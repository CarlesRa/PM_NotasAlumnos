package com.carlesramos.notasaalumnos.modelo;

import java.io.Serializable;

public class Calificacion implements Serializable{
    private String codAssignatura;
    private String nomAssignatura;
    private double notaAlumno;

    public Calificacion(String codAssignatura, double notaAlumno) {
        this.codAssignatura = codAssignatura;
        this.nomAssignatura = nombreAssig();
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

    private String nombreAssig(){
        String nombre;
        switch (this.codAssignatura){
            case "AAD":{
                nombre = "Acceso a base de datos";
                break;
            }
            case "DDI":{
                nombre = "Desarrollo de interfaces";
                break;
            }
            case "PMDM":{
                nombre = "Programación multimedia y dispositivos móviles";
                break;
            }
            case "PSP":{
                nombre = "Progroamación de servicios y procesos";
                break;
            }
            case "SGE":{
                nombre = "Sistemas de gestión empresarial";
                break;
            }
            case "EIE":{
                nombre = "Empresa e iniciativa emprendedora";
                break;
            }
            case "ANG":{
                nombre = "Inglés técnico";
                break;
            }
            default: {
                nombre = "";
                break;
            }
        }
        return nombre;
    }
}
