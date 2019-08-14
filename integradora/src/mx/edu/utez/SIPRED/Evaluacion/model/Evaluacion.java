package mx.edu.utez.SIPRED.Evaluacion.model;

import mx.edu.utez.SIPRED.periodo.model.Periodo;

public class Evaluacion {
    private int idEvaluacion;
    private String tiempoInicio;
    private String tiempoFin;
    private int esstado;
    private Periodo periodo;

    public Evaluacion(int idEvaluacion, String tiempoInicio, String tiempoFin, int esstado, Periodo periodo) {
        this.idEvaluacion = idEvaluacion;
        this.tiempoInicio = tiempoInicio;
        this.tiempoFin = tiempoFin;
        this.esstado = esstado;
        this.periodo = periodo;
    }

    public Evaluacion() {
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(String tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public String getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(String tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public int getEsstado() {
        return esstado;
    }

    public void setEsstado(int esstado) {
        this.esstado = esstado;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "idEvaluacion=" + idEvaluacion +
                ", tiempoInicio='" + tiempoInicio + '\'' +
                ", tiempoFin='" + tiempoFin + '\'' +
                ", esstado=" + esstado +
                ", periodo=" + periodo +
                '}';
    }
}
