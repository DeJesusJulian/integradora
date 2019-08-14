package mx.edu.utez.SIPRED.periodo.dao;

import mx.edu.utez.SIPRED.periodo.model.Periodo;

import java.util.List;

public interface IDaoPeriodo {
    List<Periodo> ObtenerPeriodos();

    Periodo obtenerPeriodos(Periodo periodo);

    Periodo modificarPeriodo(Periodo periodo);

}
