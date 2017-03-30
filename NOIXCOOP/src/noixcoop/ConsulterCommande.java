/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noixcoop;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JTextArea;

/**
 *
 * @author tangu
 */
public class ConsulterCommande extends javax.swing.JFrame {

    /**
     * Creates new form ConsulterCommande
     */
    public ConsulterCommande() throws IOException{
        initComponents();
        chargerListDistributeur();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        consulter = new javax.swing.JButton();
        comboboxDistributeur = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaCommandeDist = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        deco = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        retour = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Choisissez l'id du distributeur dont vous souhaitez vous les commandes");

        consulter.setText("Consulter");
        consulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulterActionPerformed(evt);
            }
        });

        comboboxDistributeur.setName("comboboxDistributeur"); // NOI18N

        textAreaCommandeDist.setColumns(20);
        textAreaCommandeDist.setRows(5);
        jScrollPane1.setViewportView(textAreaCommandeDist);

        jMenu1.setText("Deconnexion");

        deco.setText("Deconnexion");
        deco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decoActionPerformed(evt);
            }
        });
        jMenu1.add(deco);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Retour à l'accueil");

        retour.setText("Retour à l'accueil");
        retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourActionPerformed(evt);
            }
        });
        jMenu2.add(retour);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(comboboxDistributeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(consulter)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxDistributeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consulter)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        comboboxDistributeur.getAccessibleContext().setAccessibleName("comboboxDistributeur");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourActionPerformed
         AccueilGestionnaire AccueilGestionnaire = new AccueilGestionnaire();
        AccueilGestionnaire.setTitle("Accueil");
        AccueilGestionnaire.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_retourActionPerformed

    private void decoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoActionPerformed
     connexion connexion = new connexion();
        connexion.setTitle("Connexion");
        connexion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_decoActionPerformed
    
    
    private void consulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulterActionPerformed
        // TODO add your handling code here:
         String login = "root"
            , mdp = "",
                ip = "jdbc:mysql://localhost/agrurppe";
        Connection c=null;
        Statement s=null;
        Statement s2=null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost/agrurppe","root",mdp);
            s = c.createStatement();
            s2 = c.createStatement();
             String text="<?xml version=\"1.0\"encoding=\"UTF-8\"?>\n "+
                    "<commandes idDistributeur="+comboboxDistributeur.getSelectedItem().toString()+" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n";
            
            String sql2 = "SELECT * FROM `commandejava`, user WHERE commandejava.idUser = "+comboboxDistributeur.getSelectedItem().toString()+" AND user.idUser = "+comboboxDistributeur.getSelectedItem().toString()+" AND user.profil=\"distributeur\" ;";
            ResultSet res2 = s.executeQuery(sql2);
            while (res2.next()){
                text=text+"<commande id="+res2.getInt("idCommandeJava")+">\n";
                
                String sql3 = "SELECT * FROM `produitjava`, `commandejava`, user WHERE commandejava.idCommandeJava = "+res2.getInt("idCommandeJava")+" "
                        + "AND user.idUser="+comboboxDistributeur.getSelectedItem().toString()+" AND commandejava.idProduitJava = produitjava.idProduitJava";
                ResultSet res3 = s2.executeQuery(sql3);
                while (res3.next()){
                    text = text+"<produit variete="+res3.getString("varieteJava")+" type="+res3.getString("typeJava")+" calibre="+res3.getString("calibreJava")+" /> ";
                }
                
                text=text+ "<conditionnement type="+res2.getString("conditionnementJava")+" />\n"
                        + " <quantite>"+res2.getInt("quantiteJava")+"</quantite>\n"
                        + "<date_conditionnement>"+res2.getDate("dateConditionnement")+"</date_conditionnement>\n"
                        + "<date_envoi>"+res2.getDate("dateEnvoi")+"</date_envoi>\n"
                        + "</commande>";
                        
            }
            textAreaCommandeDist.setText(text);
          /*  unFichier.ecrire("<commande id=\""+this.getId()+"\"> ");
        unFichier.ecrire("<produit variete=\""+this.getLeProduit().getVariete()+"\" type=\""+this.getLeProduit().getType()+"\" calibre=\""+this.getLeProduit().getCalibre()+"\" /> ");
        unFichier.ecrire("<conditionnement type=\""+this.getConditionnement()+"\" /> ");
        unFichier.ecrire("<quantite>"+this.getQuantite()+"</quantite>");
        unFichier.ecrire("<date_conditionnement>"+this.getDateConditionnement()+"</date_conditionnement>");
        unFichier.ecrire("<date_envoi>"+this.getDateEnvoi()+"</date_envoi>");
        unFichier.ecrire("</commande>");*/
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
       
    }//GEN-LAST:event_consulterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterCommande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }
    
    //Charger la liste box avec les id des distributeurs
    public void chargerListDistributeur () throws IOException{
        
        JComboBox liste;
        String login = "root"
            , mdp = "",
                ip = "jdbc:mysql://localhost/agrurppe";
        Connection c=null;
        Statement s=null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost/agrurppe","root",mdp);
            s = c.createStatement();
            String sql= "SELECT * FROM user WHERE profil=\"distributeur\""; 
            ResultSet res = s.executeQuery(sql); 
            while (res.next()){
                comboboxDistributeur.addItem(res.getString("idUser"));
            }
            
                    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboboxDistributeur;
    private javax.swing.JButton consulter;
    private javax.swing.JMenuItem deco;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem retour;
    private javax.swing.JTextArea textAreaCommandeDist;
    // End of variables declaration//GEN-END:variables
}
