package mx.edu.utez.SIPRED.docente.dao;

import mx.edu.utez.SIPRED.docente.model.Docente;


import java.util.List;

public interface IDaoDocente {

    List<Docente> obtenerDocentes();

    Docente obtenerDocente(Docente docente);

    Docente obtenerDocente(int idDocente);

    Docente registrarDocente(Docente docente);

    boolean eliminarDocente(int idDocente);

    boolean modificarDocente(Docente docente);

}
