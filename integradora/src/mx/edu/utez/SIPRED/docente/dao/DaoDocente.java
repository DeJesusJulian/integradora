package mx.edu.utez.SIPRED.docente.dao;

import mx.edu.utez.SIPRED.docente.model.Docente;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDocente implements IDaoDocente {

    @Override
    public List<Docente> obtenerDocentes() {
        List<Docente> misDocentes = new ArrayList<>();
        Docente docente;
        String sql = "select idDocente, nombreDocente from docentes";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                docente = new Docente();
                docente.setIdDocente(rs.getInt("idDocente"));
                docente.setNombreDocente(rs.getString("nombreDocente"));
                misDocentes.add(docente);
            }
        } catch (SQLException e) {
            System.out.println("error en obtenerDocentes " + e);
        }
        return misDocentes;
    }

    @Override
    public Docente obtenerDocente(Docente docente) {
        return null;
    }

    @Override
    public Docente obtenerDocente(int idDocente) {
        String sql = "SELECT idDocente,nombreDocente FROM docentes WHERE idDocente=?";
        Docente docente = new Docente();
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idDocente);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            docente.setIdDocente(resultSet.getInt("idDocente"));
            docente.setNombreDocente(resultSet.getString("nombreDocente"));

        } catch (SQLException e) {
            System.out.println("error en obtenerDocentes " + e);
        }
        return docente;
    }

    @Override
    public Docente registrarDocente(Docente docente) {
        String sql = "insert into docentes(nombreDocente)values(?)";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, docente.getNombreDocente());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            docente.setIdDocente(rs.getInt(1));
            System.out.println(docente.getIdDocente());
        } catch (SQLException e) {
            System.out.println("error en registrarDocente " + e);
        }
        return docente;
    }

    @Override
    public boolean eliminarDocente(int idDocente) {
        String sql = "DELETE FROM docentes WHERE idDocente=?";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idDocente);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarDocente(Docente docente) {
        String sql = "UPDATE docentes set nombreDocente=? WHERE idDocente=?";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, docente.getIdDocente());
            preparedStatement.setString(2, docente.getNombreDocente());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }
        return false;
    }
}
