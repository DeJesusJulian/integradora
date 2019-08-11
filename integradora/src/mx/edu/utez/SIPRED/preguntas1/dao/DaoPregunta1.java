package mx.edu.utez.SIPRED.preguntas1.dao;

import mx.edu.utez.SIPRED.preguntas1.model.Pregunta1;
import mx.edu.utez.SIPRED.utility.Conexion;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPregunta1 implements IDaoPregunta1{
    @Override
    public List<Pregunta1> obtenerConsulta() {
        List<Pregunta1> misPreguntas = new ArrayList<>();
        Pregunta1 pregunta1;
        String sql = "select idPregunta, pregunta from preguntas_1";
        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                pregunta1 = new Pregunta1();
                pregunta1.setIdPregunta1(rs.getInt("idPregunta"));
                pregunta1.setPregunta(rs.getString("pregunta"));
                System.out.println(pregunta1.getPregunta());
                misPreguntas.add(pregunta1);
            }
        }catch (SQLException e){
            System.out.println("error en obtenerPregunta1 "+e);
        }
        return misPreguntas;
    }

    @Override
    public Pregunta1 obtenerConsulta(int idPregunta1) {
        return null;
    }

    @Override
    public Pregunta1 registrarPregunta(Pregunta1 pregunta1) {
        String sql = "INSERT INTO preguntas_1 (pregunta) VALUES (?)";
        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, pregunta1.getPregunta());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            pregunta1.setIdPregunta1(rs.getInt(1));
            System.out.println("Pregunta1 registrada");
        }catch (SQLException e){
            System.out.println("error en registrarPregunta1 "+e);
        }
        return pregunta1;
    }

    @Override
    public boolean eliminarPregunta(Pregunta1 pregunta1) {
        return false;
    }

    @Override
    public Pregunta1 modificarPregunta(Pregunta1 pregunta1) {
        return null;
    }
}
