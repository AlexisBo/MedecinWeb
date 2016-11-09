/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sio
 */
public class Connect {

    private static Connection con = null;

    private static Connection open() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote mal installé ..." + e);
        }
        try {
            con = DriverManager.getConnection("jdbc:postgresql://sophie/medecin", "aboisne", "linux");
        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
        return con;
    }

    public static Connection get() {
        try {
            if (con == null || con.isClosed()) {
                con = Connect.open();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void close() {
        try {

            con.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
    }
}
