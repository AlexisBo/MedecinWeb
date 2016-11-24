/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author sio
 */
public class Specialite implements Comparable <Specialite> {
    private String libelle;
    private Collection<Medecin> lesMeds = new HashSet<Medecin>();

    public Specialite(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public Collection<Medecin> getLesMeds() {
        return lesMeds;
    }
    
    public void addUnMed(Medecin unMed){
        lesMeds.add(unMed);
    }

    @Override
    public int compareTo(Specialite o) {
        return (libelle.compareTo(o.libelle));
    }
    
}
