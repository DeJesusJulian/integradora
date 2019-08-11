package mx.edu.utez.SIPRED.preguntas1.dao;

import mx.edu.utez.SIPRED.preguntas1.model.Pregunta1;

import java.util.List;

public interface IDaoPregunta1 {

    List<Pregunta1> obtenerConsulta();

    Pregunta1 obtenerConsulta(int idPregunta1);

    Pregunta1 registrarPregunta(Pregunta1 pregunta1);

    boolean eliminarPregunta(Pregunta1 pregunta1);

    Pregunta1 modificarPregunta(Pregunta1 pregunta1);

}
