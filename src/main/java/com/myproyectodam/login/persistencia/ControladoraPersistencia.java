package com.myproyectodam.login.persistencia;

import com.myproyectodam.login.logica.Rol;
import com.myproyectodam.login.logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    UsuarioJpaController usuJpa = new UsuarioJpaController(); // Crear una instancia
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        List<Usuario> listaUsuarios = usuJpa.findUsuarioEntities(); // Con este metodo traermos todos lo usuarios.
        return listaUsuarios;
        // En SQL seria SELECT * FROM USUARIOS

    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities(); // Realizamos SELECT * FROM Roles.
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        try {
            usuJpa.destroy(id_usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
        return usuJpa.findUsuario(id_usuario);
    }

    public void editarusuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

}
