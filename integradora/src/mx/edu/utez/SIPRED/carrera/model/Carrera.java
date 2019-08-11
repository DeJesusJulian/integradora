package mx.edu.utez.SIPRED.carrera.model;

public class Carrera {
    private int idCarreras;
    private String nombreCarrera;

    public Carrera() {
    }

    public Carrera(int idCarreras, String nombreCarrera) {
        this.idCarreras = idCarreras;
        this.nombreCarrera = nombreCarrera;
    }

    public int getIdCarreras() {
        return idCarreras;
    }

    public void setIdCarreras(int idCarreras) {
        this.idCarreras = idCarreras;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarreras=" + idCarreras +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                '}';
    }
}
