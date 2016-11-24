/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;

/**
 *
 * @author sio
 */
public class test {
    public static void main(String[] args) {
        Pays p = new Pays();
        Collection<Specialite> s = p.getLesSpes().values();
        for (Specialite uneS : s){
            System.out.println(uneS.getLibelle());
        }
    }
}
