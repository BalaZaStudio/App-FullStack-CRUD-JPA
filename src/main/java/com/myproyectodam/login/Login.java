package com.myproyectodam.login;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.myproyectodam.login.igu.PrincipalLogin;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login {

    public static void main(String[] args) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new AluminiumLookAndFeel()); //  Seleccionamos el tema
            } catch (UnsupportedLookAndFeelException ex) {

            }

            PrincipalLogin principal = new PrincipalLogin(); // Instanciamos un objeto 
            principal.setVisible(true); // Que sea visible 
            principal.setLocationRelativeTo(null); // Situar la posicion centrada

        });
    }
}
