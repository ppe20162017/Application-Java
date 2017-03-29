/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.util.ArrayList;
import java.io.IOException;

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
    
    public Fichier XmlNonLivrees (Distributeur unDistributeur) throws IOException, ClassNotFoundException{
        Fichier unFichier = new Fichier();
        unFichier.ouvrir("E");
        unFichier.ecrire("<?xml version=\"1.0\"encoding=\"UTF-8\"?>");
        unFichier.ecrire("<commandes idDistributeur=\""+unDistributeur.getId()+"\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
        for (Commande uneCommande : unDistributeur.getCommandes()){
            uneCommande.XmlCommande();
        }
        unFichier.ecrire("</commandes> ");
        return unFichier;
    }
    
}
