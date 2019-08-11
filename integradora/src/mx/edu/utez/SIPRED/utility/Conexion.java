package mx.edu.utez.SIPRED.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection obtenerConexion(){
        String cadena = "jdbc:mysql://localhost:3306/sipred?user=root&password=root&serverTimezone=America/Mexico_City&useSSL=false"+
                "&allowPublicKeyRetrieval=true";
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(cadena);
        }catch (SQLException ex){
            System.out.println(this.getClass().getCanonicalName());
            System.out.println("La conexion no esta funcionando "+ ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection con = new Conexion().obtenerConexion();
        if (con == null){
            System.out.println("algo paso");
        }else{
            System.out.println("Se conecto");
        }
    }
}
