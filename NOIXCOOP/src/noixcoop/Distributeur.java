/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author benoi
 */
public class Distributeur {
    private String id;
    private String nom;
    private ArrayList<Commande> lesCommandes;

    public Distributeur(){
        
    }
    
    public Distributeur(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Commande> getLesCommandes() {
        return lesCommandes;
    }
    
    public ArrayList<Commande> getCommandesEnCours(){
        ArrayList<Commande> commandesEnCours=new ArrayList();
        for (Commande uneCommande : lesCommandes){
            if (uneCommande.enCours()){
                commandesEnCours.add(uneCommande);
            }
        }
        return commandesEnCours;
    }
}
