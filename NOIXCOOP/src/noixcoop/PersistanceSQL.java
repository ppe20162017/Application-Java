/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author benoi
 */
public class PersistanceSQL {
    private Produit pro;
    private ArrayList<Produit> listeProduit;
    private ArrayList<Commande> listeCommande;
    
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
                String sql = "INSERT INTO `variete`(`libelleVar`) VALUES ('"+produit.getVariete()+"');";
                s.executeUpdate(sql); 
                sql = "INSERT INTO `conditionnement`(`libelleCond`,`numeroCommande`) VALUES ('"+produit.getType()+"',1)";
                s.executeUpdate(sql);
                sql = "INSERT INTO `lots`(`calibreLot`) VALUES ('"+produit.getCalibre()+"');";
                s.executeUpdate(sql);
                System.out.println("Objet produit");
            }  
            else if (unObjet instanceof Commande){
                Commande commande = (Commande) unObjet;
                System.out.println("objet commande");
            }
            else if (unObjet instanceof Distributeur){
                Distributeur distributeur  = (Distributeur) unObjet;
                System.out.println("Objet distributeur");           }
            else{
                System.out.println("Erreur");
            }
            
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
    
   public void changerDepuisBase (String nomClasse){
        Connection c=null;
        Statement s=null;
        String mdp="";
        
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            
            c=DriverManager.getConnection("jdbc:mysql://localhost/agrurppe","root",mdp);
            s = c.createStatement();
            if ( nomClasse == "Commande"){
                
                String sql="SELECT * FROM commandejava";
                ResultSet res = s.executeQuery(sql); 
                
                while (res.next()){
                    String sql2 = "SELECT * FROM produitjava WHERE produitjava.idProduitJava = "+res.getInt("idProduitJava")+";";
                    ResultSet res2 = s.executeQuery(sql2);
                    while(res2.next()){
                        pro = new Produit (res2.getInt("idProduitJava"), res2.getString("varieteJava"), res2.getString("typeJava"), res2.getInt("calibreJava") );
                        listeProduit.add(pro);
                        System.out.println(pro.getIdProduit());
                        
                    }
                   res2.close();
                   
                    Commande com = new Commande(res.getInt("idCommandeJava"), res.getString("conditionnementJava"), res.getInt("quantiteJava"), res.getDate("dateConditionnement"), res.getDate("dateEnvoi"),pro);
                    listeCommande.add(com);
                }
                res.close();
            }
            
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
}
