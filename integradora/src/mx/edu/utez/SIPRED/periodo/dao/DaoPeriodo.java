package mx.edu.utez.SIPRED.periodo.dao;

import mx.edu.utez.SIPRED.periodo.model.Periodo;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPeriodo implements IDaoPeriodo {

    @Override
    public List<Periodo> ObtenerPeriodos() {
        List<Periodo> misPeriodos = new ArrayList<>();
        Periodo periodo;
        String sql = "select id_periodo, nombre_periodo, fecha_inicio, fecha_fin from periodo";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                periodo = new Periodo();
                periodo.setIdPeriodo(rs.getInt("id_periodo"));
                periodo.setNombrePeriodo(rs.getString("nombre_periodo"));
                periodo.setFechaInicio(rs.getString("fecha_inicio"));
                periodo.setFechaFin(rs.getString("fecha_fin"));
                System.out.println(periodo.getNombrePeriodo());
                misPeriodos.add(periodo);
            }
        } catch (SQLException e) {
            System.out.println("error en obtenerPeriodos " + e);
        }
        return misPeriodos;
    }

    @Override
    public Periodo obtenerPeriodos(Periodo periodo) {
        return null;
    }

    @Override
    public Periodo modificarPeriodo(Periodo periodo) {
        return null;
    }


}
