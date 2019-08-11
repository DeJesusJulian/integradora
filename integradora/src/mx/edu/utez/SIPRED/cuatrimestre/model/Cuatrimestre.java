package mx.edu.utez.SIPRED.cuatrimestre.model;

public class Cuatrimestre {

    private int idCuatrimestre;
    private int cuatrimestre;

    public Cuatrimestre() {
    }

    public Cuatrimestre(int idCuatrimestre, int cuatrimestre) {
        this.idCuatrimestre = idCuatrimestre;
        this.cuatrimestre = cuatrimestre;
    }

    public int getIdCuatrimestre() {
        return idCuatrimestre;
    }

    public void setIdCuatrimestre(int idCuatrimestre) {
        this.idCuatrimestre = idCuatrimestre;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    @Override
    public String toString() {
        return "Cuatrimestre{" +
                "idCuatrimestre=" + idCuatrimestre +
                ", cuatrimestre=" + cuatrimestre +
                '}';
    }
}
