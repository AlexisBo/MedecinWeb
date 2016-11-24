/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author sio
 */
public class Medecin implements Comparable <Medecin> {

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String spe;
    private Integer dep;
    private String id;

    public Medecin(String nom, String prenom, String adresse, String tel, String spe, Integer dep, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.spe = spe;
        this.id = id;
        this.dep = dep;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getSpe() {
        return spe;
    }

    public Integer getDep() {
        return dep;
    }
    
    

    @Override
    public int compareTo(Medecin o) {
        if (!nom.equals(o.nom)){
            return nom.compareTo(o.nom);
        }else{
            return id.compareTo(o.id);
        }
    }

}
