package mx.edu.utez.SIPRED.pregunta3.model;

public class Pregunta3 {
    private int idComentario;
    private String comentario;

    public Pregunta3() {
    }

    public Pregunta3(int idComentario, String comentario) {
        this.idComentario = idComentario;
        this.comentario = comentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
