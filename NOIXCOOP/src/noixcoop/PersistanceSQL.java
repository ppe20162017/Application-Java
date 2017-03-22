/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.sql.*;
/**
 *
 * @author benoi
 */
public class PersistanceSQL {
    
    String ipBase, nomBaseDonnees;
    private int port;
    String login = "root"
            , mdp = "";
    
    public PersistanceSQL(){
        
    }
    
    public PersistanceSQL(String ipBase, String nomBaseDonnees, int port) {
        this.ipBase = ipBase;
        this.nomBaseDonnees = nomBaseDonnees;
        this.port = port;
    }
    
    public void rangerDansBase(Object unObjet){
        Connection c=null;
        Statement s=null;
        
        
        
        
        
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            
            c=DriverManager.getConnection(this.ipBase,this.login,this.mdp);
            s = c.createStatement();
            if (unObjet instanceof Produit){
                Produit produit = (Produit) unObjet;
                produit.getType();
                //String sql = "INSERT INTO `var`(`dateCommande`, `numLots`, `idClient`) VALUES ('');";
            }  
            
            //String sql = "INSERT INTO `commande`(`dateCommande`, `numLots`, `idClient`) VALUES ('2017-02-03',8,1);";
            //s.executeUpdate(sql); 
            System.out.println("connexion OK");
        }
        catch(SQLException e){
            System.out.println("erreur premier catch");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("erreur deuxieme catch");
            e.printStackTrace();
        }finally{
            try{
                c.close();
                s.close();
            }
            catch(SQLException e){
                System.out.println("erreur troisieme catch");
                e.printStackTrace();
            }
        }
    }
    
    /*public Object changerDepuisBase (String id, String nomClasse){
        
    }*/
}
