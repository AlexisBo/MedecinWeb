/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author sio
 */
public class Pays {

    private TreeMap<String, Departement> lesDeps = new TreeMap<>();

    public Pays() {
        lesDeps = PaysDAO.getLesDeps();
    }

    public TreeMap<String, Departement> getLesDeps() {
        return lesDeps;
    }

    public Departement getLeDep(String key) {
        return this.lesDeps.get(key);
    }
}
