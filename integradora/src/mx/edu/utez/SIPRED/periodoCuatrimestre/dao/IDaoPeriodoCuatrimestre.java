package mx.edu.utez.SIPRED.periodoCuatrimestre.dao;

import mx.edu.utez.SIPRED.periodo.model.Periodo;
import mx.edu.utez.SIPRED.periodoCuatrimestre.model.PeriodoCuatrimestre;

import java.util.List;

public interface IDaoPeriodoCuatrimestre {
    List<PeriodoCuatrimestre> obtenerPeriodoCuatrimestre(Periodo periodo);

    List<PeriodoCuatrimestre> modificarPeriodoCuatrimestre(int periosCuatrimestral);
}
