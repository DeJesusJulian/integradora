package mx.edu.utez.SIPRED.preguntas1.model;

public class Pregunta1 {
    private  int idPregunta1;
    private String pregunta;

    public Pregunta1() {
    }

    public Pregunta1(int idPregunta1, String pregunta) {
        this.idPregunta1 = idPregunta1;
        this.pregunta = pregunta;
    }

    public int getIdPregunta1() {
        return idPregunta1;
    }

    public void setIdPregunta1(int idPregunta1) {
        this.idPregunta1 = idPregunta1;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Pregunta1{" +
                "idPregunta1=" + idPregunta1 +
                ", pregunta='" + pregunta + '\'' +
                '}';
    }
}
