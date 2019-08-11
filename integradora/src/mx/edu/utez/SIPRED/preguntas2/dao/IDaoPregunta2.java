package mx.edu.utez.SIPRED.preguntas2.dao;


import mx.edu.utez.SIPRED.preguntas2.model.pregunta2;

import java.util.List;

public interface IDaoPregunta2 {
    List<pregunta2> obtenerPreguntas();
    pregunta2 obtenerPregunta(pregunta2 pregunta);
    pregunta2 registrarPregunta(pregunta2 pregunta);
    boolean eliminarPregunta(int idPregunta);
    pregunta2 modificarPregunta(pregunta2 pregunta2);
}
