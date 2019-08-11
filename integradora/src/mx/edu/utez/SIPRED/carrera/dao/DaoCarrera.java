package mx.edu.utez.SIPRED.carrera.dao;

import mx.edu.utez.SIPRED.carrera.model.Carrera;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCarrera implements IDaoCarrera {
    @Override
    public List<Carrera> consultarCarreras() {
        List<Carrera> misCarreras = new ArrayList<>();
        Carrera unaCarrera;
        String sql = "select idcarreras, nombreCarrera from carreras";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                unaCarrera = new Carrera();
                unaCarrera.setIdCarreras(rs.getInt("idCarreras"));
                System.out.println(unaCarrera.getIdCarreras());
                unaCarrera.setNombreCarrera(rs.getString("nombreCarrera"));
                System.out.println(unaCarrera.getNombreCarrera());
                misCarreras.add(unaCarrera);
            }
            System.out.println("carreras consultadas");
        } catch (SQLException e) {
            System.out.println("error en consultarCarreras " + e);
        }
        return misCarreras;
    }

    @Override
    public Carrera obtenerCarrera(int idCarrera) {

        return null;
    }

    @Override
    public Carrera registrarCarrera(Carrera carrera) {
        String sql = "insert into carreras(nombreCarrera)values(?)";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, carrera.getNombreCarrera());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            carrera.setIdCarreras(rs.getInt(1));
            System.out.println(carrera.getIdCarreras());
            System.out.println("carrera registrada");
        } catch (SQLException e) {
            System.out.println("error en registrarCarrera");
        }
        return carrera;
    }

    @Override
    public boolean eliminarCarrera(int idCarrera) {
        String sql = "DELETE FROM carreras WHERE idcarreras=?";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idCarrera);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(this.getClass().getCanonicalName() + "@" + e.getMessage());
            return false;
        }

    }

    @Override
    public Carrera modificarCarrera(Carrera carrera) {
        return null;
    }
}
