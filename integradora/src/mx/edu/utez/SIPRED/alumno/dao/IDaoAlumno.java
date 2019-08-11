package mx.edu.utez.SIPRED.alumno.dao;

import mx.edu.utez.SIPRED.alumno.model.Alumno;

import java.util.List;

public interface IDaoAlumno {
    List<Alumno> consultarAlumnos();

    Alumno obtenerAlumno(Alumno alumno);

    Alumno obtenerAlumno(String matricula);

    Alumno registrarAlumno(Alumno alumno);

    boolean eliminarAlumno(String matricula);

    Alumno modificarAlumno(Alumno alumno);
}
