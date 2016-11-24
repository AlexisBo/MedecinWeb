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
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sio
 */
public class PaysDAO {

    public static TreeMap<Integer, Departement> getLesDeps() {
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rs = req.executeQuery("select distinct departement from medecin");

            Statement reqP = con.createStatement();

            Integer num;
            TreeMap<Integer, Departement> lesDeps = new TreeMap<>();

            while (rs.next()) {
                num = rs.getInt("departement");

                Departement unDep = new Departement(num);
                lesDeps.put(num, unDep);
            }
            return lesDeps;

        } catch (SQLException ex) {
            Logger.getLogger(PaysDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static TreeMap<String, Specialite> getLesSpes() {
        try {
            Connection con = Connect.get();
            Statement req2;
            req2 = con.createStatement();
            ResultSet rs2 = req2.executeQuery("select specialitecomplementaire from medecin");

            String libelle;
            TreeMap<String, Specialite> lesSpes = new TreeMap<>();

            while (rs2.next()) {

                libelle = rs2.getString("specialitecomplementaire");
                if (libelle != null) {
                    Specialite uneSpe = new Specialite(libelle);
                    lesSpes.put(libelle, uneSpe);
                }
            }
            return lesSpes;

        } catch (SQLException ex) {
            Logger.getLogger(PaysDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Collection<Medecin> getLesMeds() {
        try {
            Connection con = Connect.get();
            Statement req3;
            req3 = con.createStatement();
            ResultSet rs3 = req3.executeQuery("select * from medecin");

            String id;
            String nom;
            String prenom;
            String adresse;
            String tel;
            String spe;
            Integer dep;
            Collection<Medecin> lesMeds = new HashSet<>();

            while (rs3.next()) {

                id = rs3.getString("id");
                nom = rs3.getString("nom");
                prenom = rs3.getString("prenom");
                adresse = rs3.getString("adresse");
                tel = rs3.getString("tel");
                spe = rs3.getString("specialitecomplementaire");
                dep = rs3.getInt("departement");

                Medecin unMed = new Medecin(nom, prenom, adresse, tel, spe, dep, id);
                lesMeds.add(unMed);
            }
            return lesMeds;

        } catch (SQLException ex) {
            Logger.getLogger(PaysDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
