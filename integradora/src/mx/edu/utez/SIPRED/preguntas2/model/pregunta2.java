package mx.edu.utez.SIPRED.preguntas2.model;

public class pregunta2 {
    private int idPregunta;
    private String pregunta;

    public pregunta2(int idPregunta, String pregunta) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
    }

    public pregunta2() {
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "pregunta2{" +
                "idPregunta=" + idPregunta +
                ", pregunta='" + pregunta + '\'' +
                '}';
    }
}
