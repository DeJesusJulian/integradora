package mx.edu.utez.SIPRED.preguntas2.dao;

import mx.edu.utez.SIPRED.alumno.dao.IDaoAlumno;
import mx.edu.utez.SIPRED.preguntas2.model.pregunta2;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPregunta2 implements IDaoPregunta2 {

    @Override
    public List<pregunta2> obtenerPreguntas() {
        List<pregunta2> misPreguntas = new ArrayList<>();
        pregunta2 pregunta;
        String sql = "select idPregunta, pregunta from preguntas_2";
        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                pregunta = new pregunta2();
                pregunta.setIdPregunta(rs.getInt("idPregunta"));
                pregunta.setPregunta(rs.getString("pregunta"));
                System.out.println(pregunta.getPregunta());
                misPreguntas.add(pregunta);
            }
        }catch (SQLException e){
            System.out.println("error en obtener preguntas2 "+e);
        }
        return misPreguntas;
    }

    @Override
    public pregunta2 obtenerPregunta(pregunta2 pregunta) {
        String sql = "";
        return pregunta;
    }

    @Override
    public pregunta2 registrarPregunta(pregunta2 pregunta) {
        String sql = "insert into preguntas_2(pregunta) values(?)";
        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, pregunta.getPregunta());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            pregunta.setIdPregunta(rs.getInt(1));
            System.out.println(pregunta.getIdPregunta());
        }catch (SQLException e){
            System.out.println("error en registrar pregunta2 "+e);
        }
        return pregunta;
    }

    @Override
    public boolean eliminarPregunta(int idPregunta) {
        return false;
    }

    @Override
    public pregunta2 modificarPregunta(pregunta2 pregunta2) {
        return null;
    }
}
