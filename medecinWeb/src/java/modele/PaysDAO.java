/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sio
 */
public class PaysDAO {

    public static Pays getLesDeps() {
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rs = req.executeQuery("select distinct departement from medecin");

            String num;
            TreeMap<Integer, Departement> lesDeps;

            while (rs.next()) {
                num = rs.getString("departement");
                lesDeps = new TreeMap<Integer, Departement>();

                Statement reqP = con.createStatement();
                ResultSet rsP = reqP.executeQuery(
                        "select id, nom, prenom, adresse, tel "
                        + "from medecin "
                        + "where departement = '" + num + "'");
                while (rsP.next()) {
                    

                }
                rsP.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaysDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
