/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author sio
 */
public class Departement implements Comparable<Departement> {

    private String num;
    private Collection<Medecin> lesMeds = new TreeSet<Medecin>();

    public Departement(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public Collection<Medecin> getLesMeds() {
        return lesMeds;
    }

    public Collection<Medecin> getLesMeds(String prefix) {
        Collection<Medecin> lesMedecinsTrier = new TreeSet<>();
        for (Medecin unMedecin : this.lesMeds) {
            if (unMedecin.getNom().startsWith(prefix)) {
                lesMedecinsTrier.add(unMedecin);
            }
        }
        return lesMedecinsTrier;
    }

    public void addUnMed(Medecin unMed) {
        lesMeds.add(unMed);
    }

    @Override
    public int compareTo(Departement o) {
        return (num.compareTo(o.num));
    }

}
