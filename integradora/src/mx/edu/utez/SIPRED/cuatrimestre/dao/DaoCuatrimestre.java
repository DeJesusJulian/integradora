package mx.edu.utez.SIPRED.cuatrimestre.dao;

import mx.edu.utez.SIPRED.cuatrimestre.model.Cuatrimestre;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DaoCuatrimestre implements ICuatrimestre {

    @Override
    public List<Cuatrimestre> obtenerCuatrimestres() {
        List<Cuatrimestre> misCuatrimestres = new ArrayList<>();
        Cuatrimestre cuatrimestre;
        String sql = "select id, cuatrimestre from cuatrimestre";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cuatrimestre = new Cuatrimestre();
                cuatrimestre.setIdCuatrimestre(rs.getInt("id"));
                cuatrimestre.setCuatrimestre(rs.getInt("cuatrimestre"));
                misCuatrimestres.add(cuatrimestre);
                System.out.println(cuatrimestre.getCuatrimestre());
            }
            System.out.println("cuatrimestres consultados");
        } catch (SQLException e) {
            System.out.println("Error en obtenercuatrimestres " + e);
        }

        return misCuatrimestres;
    }
}
