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

    public static TreeMap<String, Departement> getLesDeps() {
        try {
            Connection con = Connect.get();
            Statement req;
            req = con.createStatement();
            ResultSet rs = req.executeQuery("select distinct departement from medecin");

            Statement reqP = con.createStatement();

            String num;
//            String id;
//            String nom;
//            String prenom;
//            String adresse;
//            String tel;
//            String spe;
            TreeMap<String, Departement> lesDeps = new TreeMap<>();

            while (rs.next()) {
                num = rs.getString("departement");
//                ResultSet rsP = reqP.executeQuery(
//                        "select id, nom, prenom, adresse, tel, specialitecomplementaire "
//                        + "from medecin "
//                        + "where departement = '" + num + "'");
//                Collection<Medecin> lesMeds = new TreeSet<>();
//                while (rsP.next()) {
//                    id = rsP.getString("id");
//                    nom = rsP.getString("nom");
//                    prenom = rsP.getString("prenom");
//                    adresse = rsP.getString("adresse");
//                    tel = rsP.getString("tel");
//                    spe = rsP.getString("specialitecomplementaire");
//                       
//                    Medecin unMed = new Medecin(nom, prenom, adresse, tel, spe, id);
//                    lesMeds.add(unMed);}

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
                Specialite uneSpe = new Specialite(libelle);
                lesSpes.put(libelle, uneSpe);
            }
            return lesSpes;

        } catch (SQLException ex) {
            Logger.getLogger(PaysDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
