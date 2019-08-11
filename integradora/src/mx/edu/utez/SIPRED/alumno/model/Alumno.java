package mx.edu.utez.SIPRED.alumno.model;

import mx.edu.utez.SIPRED.carrera.model.Carrera;
import mx.edu.utez.SIPRED.cuatrimestre.model.Cuatrimestre;

public class Alumno {

    private String matricula;
    private String grupo;
    private Carrera carrera;
    private Cuatrimestre cuatrimestre;

    public Alumno() {
    }

    public Alumno(String matricula, String grupo, Carrera carrera, Cuatrimestre cuatrimestre) {
        this.matricula = matricula;
        this.grupo = grupo;
        this.carrera = carrera;
        this.cuatrimestre = cuatrimestre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Cuatrimestre getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Cuatrimestre cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", grupo='" + grupo + '\'' +
                ", carrera=" + carrera +
                ", cuatrimestre=" + cuatrimestre +
                '}';
    }
}
