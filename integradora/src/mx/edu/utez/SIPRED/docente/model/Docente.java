package mx.edu.utez.SIPRED.docente.model;

public class Docente {
    private int idDocente;
    private String nombreDocente;

    public Docente() {
    }

    public Docente(int idDocente, String nombreDocente) {
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "idDocente=" + idDocente +
                ", nombreDocente='" + nombreDocente + '\'' +
                '}';
    }
}
