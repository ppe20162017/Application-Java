/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

/**
 *
 * @author benoi
 */
public class PersistanceSQL {
    
    private String ipBase, nomBaseDonnees;
    private int port;

    public PersistanceSQL(String ipBase, String nomBaseDonnees, int port) {
        this.ipBase = ipBase;
        this.nomBaseDonnees = nomBaseDonnees;
        this.port = port;
    }
    
    public void rangerDansBase(Object unObjet){
        
    }
    
    public Object changerDepuisBase (String id, String nomClasse){
        
    }
}
