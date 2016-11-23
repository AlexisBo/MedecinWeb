/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author sio
 */
public class Pays {

    private TreeMap<String, Departement> lesDeps;
    private TreeMap<String, Specialite> lesSpes;

    public Pays() {
        lesDeps = PaysDAO.getLesDeps();
        lesSpes = PaysDAO.getLesSpes();
        this.assocMedecins(PaysDAO.getLesMeds());
    }

    public TreeMap<String, Departement> getLesDeps() {
        return lesDeps;
    }
    
    public TreeMap<String, Specialite> getLesSpes() {
        return lesSpes;
    }

    public Departement getLeDep(String key) {
        return this.lesDeps.get(key);
    }
    
    public Specialite getLaSpe(String key) {
        return this.lesSpes.get(key);
    }
    
    private void assocMedecins(Collection<Medecin> lesMeds){
        for (Medecin unMed : lesMeds){
            getLeDep(unMed.getDep()).addUnMed(unMed);
            Specialite uneSpe = getLaSpe(unMed.getSpe());
            if (uneSpe != null){
                uneSpe.addUnMed(unMed);
            }
        }
    }
}
