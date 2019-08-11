package mx.edu.utez.SIPRED.usuario.model;

public class Usuario {
    private int idAdministrador;
    private String usuario;
    private String contrasena;

    public Usuario(int idAdministrador, String usuario, String contrasena) {
        this.idAdministrador = idAdministrador;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idAdministrador=" + idAdministrador +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
