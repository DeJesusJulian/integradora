package mx.edu.utez.SIPRED.pregunta3.dao;

import mx.edu.utez.SIPRED.pregunta3.model.Pregunta3;
import mx.edu.utez.SIPRED.utility.Conexion;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPregunta3 implements IDaoPregunta3
{
    @Override
    public List<Pregunta3> obtenerPregunta() {
        List<Pregunta3>misPreguntas= new ArrayList<>();
        Pregunta3 pregunta3;
        String sql = "select idComentario, comentario from comentarios";
        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                pregunta3 = new Pregunta3();
                pregunta3.setIdComentario(rs.getInt("idComentario"));
                pregunta3.setComentario(rs.getString("comentario"));
                System.out.println(pregunta3.getComentario());
                misPreguntas.add(pregunta3);
            }

        }catch (SQLException e){
            System.out.println("error en obtenerPregunta3 "+e);
        }
        return misPreguntas;
    }

    @Override
    public Pregunta3 obtenerPregunta(Pregunta3 pregunta3) {
        return null;
    }

    @Override
    public Pregunta3 registrarPregunta(Pregunta3 pregunta3) {
        return null;
    }

    @Override
    public boolean eliminarPregunta(Pregunta3 pregunta3) {
        return false;
    }

    @Override
    public Pregunta3 modificarPregunta(Pregunta3 pregunta3) {
        return null;
    }
}
