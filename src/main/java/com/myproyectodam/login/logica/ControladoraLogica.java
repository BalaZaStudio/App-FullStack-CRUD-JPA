package com.myproyectodam.login.logica;

import com.myproyectodam.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis;// = new ControladoraPersistencia();

    public ControladoraLogica() {
        controlPersis = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasena) {

        Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usu : listaUsuarios) {

            if (usu.getNombreUsuario(usuario).equals(usuario) && usu.getContrasena(contrasena).equals(contrasena)) {
                usr = usu;
                return usr;
            }
        }
        // Si no se encontró ninguna coincidencia, devolver null
        return usr;
    }

    public List<Usuario> traerusuarios() { //  Traer la lista de Usuarios ya con metodo creado anteriormente
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasena(contra);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);

        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        int id = this.buscarUltimaId();

        usu.setId(id + 1); // trae el ultimo Id se le suma uno 

        controlPersis.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();

        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }

        }
        return null;
    }

    private int buscarUltimaId() {
        List<Usuario> listaUsuarios = this.traerusuarios();
        Usuario usu = listaUsuarios.get(listaUsuarios.size() - 1);
        return usu.getId(); // Obtenemos Id
    }

    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);
    }

    public Usuario traerUsuario(int id_usuario) {

        return controlPersis.traerUsuario(id_usuario);

    }

    public void editarUsuario(Usuario usu, String usuario, String contra, String rolRecibido) {

        usu.setNombreUsuario(usuario);
        usu.setContrasena(contra);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);

        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        controlPersis.editarusuario(usu);
    }

}
