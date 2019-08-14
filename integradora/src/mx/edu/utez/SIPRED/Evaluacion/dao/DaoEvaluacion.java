package mx.edu.utez.SIPRED.Evaluacion.dao;

import mx.edu.utez.SIPRED.Evaluacion.model.Evaluacion;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.*;

public class DaoEvaluacion implements IDaoEvaluacion {

    @Override
    public boolean crearEvaluacion(Evaluacion evaluacion) {
        String sql = "insert into evaluaciones(tiempoInicio, tiempoFin, estado, periodo_id_periodo)values(?,?,?,?)";

        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, evaluacion.getTiempoInicio());
            pstm.setString(2, evaluacion.getTiempoFin());
            pstm.setInt(3, 0);
            pstm.setInt(4, evaluacion.getPeriodo().getIdPeriodo());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            evaluacion.setIdEvaluacion(rs.getInt(1));
            System.out.println("evaluacion creada");
            return true;
        } catch (SQLException e) {
            System.out.println("error en crear evaluacion " + e);
        }
        return false;
    }
}
