/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.util.Date;

/**
 *
 * @author benoi
 */
public class Commande {
    private int id;
    private String conditionnement;
    private int quantite;
    private Date dateConditionnement;
    private Date dateEnvoi;
    private Produit leProduit;

    public Commande(int id, String conditionnement, int quantite, Date dateConditionnement, Date dateEnvoi, Produit leProduit) {
        this.id = id;
        this.conditionnement = conditionnement;
        this.quantite = quantite;
        this.dateConditionnement = dateConditionnement;
        this.dateEnvoi = dateEnvoi;
        this.leProduit = leProduit;
    }
    
    /**
     * @return leProduit 
     */
    public Produit getLeProduit() {
        return leProduit;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the conditionnement
     */
    public String getConditionnement() {
        return conditionnement;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @return the dateConditionnement
     */
    public Date getDateConditionnement() {
        return dateConditionnement;
    }

    /**
     * @return the dateEnvoi
     */
    public Date getDateEnvoi() {
        return dateEnvoi;
    }
    
    public Boolean enCours(){
        Boolean valeur=false;
        if (this.dateEnvoi!=null){
            valeur = true;
        }
        // Renvoie vrai si la commande n'est pas encore expédiée, faux sinon.   
        // Une commande n’est pas expédiée si sa date d’envoi contient NULL. 
        return valeur;
    }
    
    public String XmlCommande(){
        // Retourne la chaîne correspondant au code XML représentant la commande (voir annexe).  
        // Cette fonction est appelée par la méthode XmlNonLivrees() de la classe   
        // GestionCommandes décrite ci-après.
        return "";
    }
    
}
