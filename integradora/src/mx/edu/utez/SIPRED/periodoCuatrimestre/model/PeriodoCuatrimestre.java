package mx.edu.utez.SIPRED.periodoCuatrimestre.model;

import mx.edu.utez.SIPRED.carrera.model.Carrera;
import mx.edu.utez.SIPRED.cuatrimestre.model.Cuatrimestre;
import mx.edu.utez.SIPRED.periodo.model.Periodo;

public class PeriodoCuatrimestre {
    private int idPeriodoCuatrimestre;
    private Cuatrimestre cuatrimestre;
    private Periodo periodo;
    private int numMaterias;
    private Carrera carrera;

    public PeriodoCuatrimestre() {
    }

    public PeriodoCuatrimestre(int idPeriodoCuatrimestre, Cuatrimestre cuatrimestre, Periodo periodo, int numMaterias, Carrera carrera) {
        this.idPeriodoCuatrimestre = idPeriodoCuatrimestre;
        this.cuatrimestre = cuatrimestre;
        this.periodo = periodo;
        this.numMaterias = numMaterias;
        this.carrera = carrera;
    }

    public int getIdPeriodoCuatrimestre() {
        return idPeriodoCuatrimestre;
    }

    public void setIdPeriodoCuatrimestre(int idPeriodoCuatrimestre) {
        this.idPeriodoCuatrimestre = idPeriodoCuatrimestre;
    }

    public Cuatrimestre getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Cuatrimestre cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getNumMaterias() {
        return numMaterias;
    }

    public void setNumMaterias(int numMaterias) {
        this.numMaterias = numMaterias;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "PeriodoCuatrimestre{" +
                "idPeriodoCuatrimestre=" + idPeriodoCuatrimestre +
                ", cuatrimestre=" + cuatrimestre +
                ", periodo=" + periodo +
                ", numMaterias=" + numMaterias +
                ", carrera=" + carrera +
                '}';
    }
}
