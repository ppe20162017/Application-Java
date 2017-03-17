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
public class Produit {
    private String variete, type;
    private int calibre;

    public Produit(String variete, String type, int calibre) {
        this.variete = variete;
        this.type = type;
        this.calibre = calibre;
    }

    public String getVariete() {
        return variete;
    }

    public String getType() {
        return type;
    }

    public int getCalibre() {
        return calibre;
    }
    
    
}
