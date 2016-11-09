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
    private TreeSet<Medecin> lesMeds = new TreeSet<Medecin>();

    public Departement(String num, TreeSet<Medecin> m) {
        this.num = num;
        lesMeds = m;
    }

    public String getNum() {
        return num;
    }

    public Collection<Medecin> getLesMeds() {
        return lesMeds;
    }

    @Override
    public int compareTo(Departement o) {
        return (num.compareTo(o.num));
    }

}
