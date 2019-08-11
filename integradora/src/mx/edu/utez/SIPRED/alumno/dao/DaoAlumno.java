package mx.edu.utez.SIPRED.alumno.dao;

import mx.edu.utez.SIPRED.alumno.model.Alumno;
import mx.edu.utez.SIPRED.carrera.model.Carrera;
import mx.edu.utez.SIPRED.cuatrimestre.model.Cuatrimestre;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAlumno implements IDaoAlumno {

    @Override
    public List<Alumno> consultarAlumnos() {
        List<Alumno> misAlumnos = new ArrayList<>();
        Alumno alumno;
        Carrera carrera;
        Cuatrimestre cuatrimestre;
        String sql = "select matricula, grupo, idcarreras, nombreCarrera, id, cuatrimestre " +
                "from cuatrimestre inner join alumnos on cuatrimestre_id = id inner join carreras on carreras_idcarreras = idcarreras";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                alumno = new Alumno();
                carrera = new Carrera();
                cuatrimestre = new Cuatrimestre();
                alumno.setMatricula(rs.getString("matricula"));
                System.out.println(alumno.getMatricula());
                alumno.setGrupo(rs.getString("grupo"));
                carrera.setIdCarreras(rs.getInt("idcarreras"));
                carrera.setNombreCarrera(rs.getString("nombreCarrera"));
                alumno.setCarrera(carrera);
                cuatrimestre.setIdCuatrimestre(rs.getInt("id"));
                cuatrimestre.setCuatrimestre(rs.getInt("cuatrimestre"));
                alumno.setCuatrimestre(cuatrimestre);
                misAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            System.out.println("error en consultarAlumnos " + e);
        }
        return misAlumnos;
    }

    @Override
    public Alumno obtenerAlumno(Alumno alumno) {
        return null;
    }

    @Override
    public Alumno obtenerAlumno(String matricula) {
        System.out.println("obtenerAlumno: " + matricula);
        String sql = "" +
                "select matricula, grupo, idcarreras, nombreCarrera, id, cuatrimestre " +
                "from cuatrimestre " +
                "inner join alumnos on cuatrimestre_id = id " +
                "inner join carreras on carreras_idcarreras = idcarreras where matricula=?";

        Alumno alumno = new Alumno();
        Carrera carrera = new Carrera();
        Cuatrimestre cuatrimestre = new Cuatrimestre();
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, matricula);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            alumno.setMatricula(resultSet.getString("matricula"));
            System.out.println(alumno.getMatricula());
            alumno.setGrupo(resultSet.getString("grupo"));
            carrera.setIdCarreras(resultSet.getInt("idcarreras"));
            carrera.setNombreCarrera(resultSet.getString("nombreCarrera"));
            alumno.setCarrera(carrera);
            cuatrimestre.setIdCuatrimestre(resultSet.getInt("id"));
            cuatrimestre.setCuatrimestre(resultSet.getInt("cuatrimestre"));
            alumno.setCuatrimestre(cuatrimestre);
        } catch (SQLException e) {
            System.out.println(this.getClass().getCanonicalName() + "@" + e.getMessage());
        }

        return alumno;
    }

    @Override
    public Alumno registrarAlumno(Alumno alumno) {
        String sql = "insert into alumnos(matricula, grupo, carreras_idcarreras, cuatrimestre_id)values(?,?,?,?)";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setString(1, alumno.getMatricula());
            pstm.setString(2, alumno.getGrupo());
            pstm.setInt(3, alumno.getCarrera().getIdCarreras());
            pstm.setInt(4, alumno.getCuatrimestre().getCuatrimestre());
            pstm.execute();
            System.out.println("alumno Registrado");
        } catch (SQLException e) {
            System.out.println("error en registrarAlumno " + e);
        }
        return alumno;
    }

    @Override
    public boolean eliminarAlumno(String matricula) {
        String sql = "DELETE FROM alumnos WHERE matricula=?";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, matricula);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
            return false;
        }
    }

    @Override
    public Alumno modificarAlumno(Alumno alumno) {
        return null;
    }
}
