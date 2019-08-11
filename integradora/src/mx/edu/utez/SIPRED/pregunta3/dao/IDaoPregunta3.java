package mx.edu.utez.SIPRED.pregunta3.dao;

import mx.edu.utez.SIPRED.pregunta3.model.Pregunta3;

import java.util.List;

public interface IDaoPregunta3 {
    List<Pregunta3> obtenerPregunta();
    Pregunta3 obtenerPregunta(Pregunta3 pregunta3);
    Pregunta3 registrarPregunta(Pregunta3 pregunta3);
    boolean eliminarPregunta(Pregunta3 pregunta3);
    Pregunta3 modificarPregunta(Pregunta3 pregunta3);
}
