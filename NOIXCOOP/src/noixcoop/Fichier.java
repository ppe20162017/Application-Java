/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;
import java.io.*;

/**
 *
 * @author benoi
 */
public class Fichier {

    private ObjectOutputStream fwo;
    private ObjectInputStream fro;
    private char mode;
    private String nomDuFichier = "Commande.xml";
    
    public void ouvrir (String s) throws IOException{
        mode=(s.toUpperCase()).charAt(0);
        if (mode=='R' || mode=='L'){
            fro=new ObjectInputStream(new FileInputStream(nomDuFichier));
        }
        else if (mode=='W' || mode=='E'){
            fwo=new ObjectOutputStream (new FileOutputStream(nomDuFichier));
        }
    }
    
    public void ecrire(String tmp) throws IOException {
        if (tmp!=null){
            fwo.writeObject(tmp);
        }
    }
    
    public String lire() throws IOException, ClassNotFoundException{
        String tmp = (String) fro.readObject();
        return tmp;
    }
    
    public void fermer () throws IOException{
        if (mode=='R' || mode=='L'){
            fro.close();
        }
        if (mode=='W' || mode=='E'){
            fwo.close();
        }
    }
}
