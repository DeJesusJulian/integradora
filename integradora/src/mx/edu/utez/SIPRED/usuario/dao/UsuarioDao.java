package mx.edu.utez.SIPRED.usuario.dao;

import mx.edu.utez.SIPRED.usuario.model.Usuario;
import mx.edu.utez.SIPRED.utility.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao implements IUsuarioDao {

    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        String sql = "SELECT idAdministrador,usuario,contrasena FROM administrador WHERE usuario=? AND contrasena=?";
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement prepraredStatement = conexion.prepareStatement(sql);
            prepraredStatement.setString(1, usuario.getUsuario());
            prepraredStatement.setString(2, usuario.getContrasena());

            ResultSet resultSet = prepraredStatement.executeQuery();
            resultSet.next();
            //nombre de la columna de la base de atos donde vamos a obtener el id del usuario
            usuario.setIdAdministrador(resultSet.getInt("idAdministrador"));
        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }
        return usuario;
    }
}
