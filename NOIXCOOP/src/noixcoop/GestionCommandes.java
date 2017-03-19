/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class GestionCommandes {
    private PersistanceSQL données;
    private ArrayList<Distributeur> lesDistributeur;

    public GestionCommandes(PersistanceSQL données) {
        this.données = données;
    }
    
    public Distributeur getDistributeur (String idDistributeur){
        Distributeur leDistributeur = new Distributeur();
        for (Distributeur unDistributeur : lesDistributeur){
            if (unDistributeur.getId()==idDistributeur){
                leDistributeur = unDistributeur;
            }
        }
        return leDistributeur; 
    }
    
    public String XmlNonLivrees (Distributeur unDistributeur){
        
    }
    
}
