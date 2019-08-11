package mx.edu.utez.SIPRED.carrera.dao;

import mx.edu.utez.SIPRED.carrera.model.Carrera;

import java.util.List;

public interface IDaoCarrera {
    List<Carrera> consultarCarreras();

    Carrera obtenerCarrera(int idCarrera);

    Carrera registrarCarrera(Carrera carrera);

    boolean eliminarCarrera(int idCarrera);

    Carrera modificarCarrera(Carrera carrera);
}
