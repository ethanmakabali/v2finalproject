package com.mycompany.uno;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author chief
 */
public class PlayerInfoWin extends javax.swing.JFrame {
    private int numberOfPlayers;
    private ArrayList<String> playerNames;
    private ArrayList<JTextField> names;
    /**
     * Creates new form PlayerInfoWin
     * @param numberOfPlayers
     */
    public PlayerInfoWin(int numberOfPlayers) {
        initComponents();
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = new ArrayList<>();
        showCorrectTextFields(numberOfPlayers);
    }
    
    private void showCorrectTextFields(int numberOfPlayers){
        if(numberOfPlayers == 4){
            jtfName1.setVisible(true);
            jtfName2.setVisible(true);
            jtfName3.setVisible(true);
            jtfName4.setVisible(true);
            lblName1.setVisible(true);
            lblName2.setVisible(true);
            lblName3.setVisible(true);
            lblName4.setVisible(true);
        }
        if(numberOfPlayers == 3){
            jtfName4.setVisible(false);
            lblName4.setVisible(false);  
        }
        if(numberOfPlayers == 2){ // has to be an if????
            jtfName4.setVisible(false);
            jtfName3.setVisible(false);
            lblName4.setVisible(false);
            lblName3.setVisible(false);
        }
    }
    
    
    private boolean checkValidName(){
        return true;
    }
    
    private void setPlayerNames(){
        String name1 = jtfName1.getText();
        String name2 = jtfName2.getText();
        String name3 = jtfName3.getText();
        String name4 = jtfName4.getText();
        // Make sure the names are being retrieved
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        if(numberOfPlayers == 4){
            playerNames.add(name1);
            playerNames.add(name2);
            playerNames.add(name3);
            playerNames.add(name4);
        }
        if(numberOfPlayers == 3){
            playerNames.add(name1);
            playerNames.add(name2);
            playerNames.add(name3);
        }
        if(numberOfPlayers == 2){
            playerNames.add(name1);
            playerNames.add(name2);
        }      
    }
    
    private ArrayList<String> getPlayerNames(){
        return this.playerNames;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblName4 = new javax.swing.JLabel();
        jtfName2 = new javax.swing.JTextField();
        jtfName1 = new javax.swing.JTextField();
        jtfName4 = new javax.swing.JTextField();
        jtfName3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblName5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 255, 102));
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Player Names:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        lblName1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblName1.setForeground(new java.awt.Color(255, 255, 255));
        lblName1.setText("Player 1:");
        jPanel1.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 77, -1, -1));

        lblName3.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblName3.setForeground(new java.awt.Color(255, 255, 255));
        lblName3.setText("Player 3:");
        jPanel1.add(lblName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 267, -1, -1));

        lblName2.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblName2.setForeground(new java.awt.Color(255, 255, 255));
        lblName2.setText("Player 2:");
        jPanel1.add(lblName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 176, -1, -1));

        lblName4.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblName4.setForeground(new java.awt.Color(255, 255, 255));
        lblName4.setText("Player 4:");
        jPanel1.add(lblName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 360, -1, -1));

        jtfName2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jPanel1.add(jtfName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 648, 42));

        jtfName1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jtfName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfName1ActionPerformed(evt);
            }
        });
        jPanel1.add(jtfName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 75, 648, 42));

        jtfName4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jPanel1.add(jtfName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 648, 42));

        jtfName3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jPanel1.add(jtfName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 648, 42));

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 320, 100));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton2.setText("Return to Main Menu");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 220, 50));

        lblName5.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        lblName5.setForeground(new java.awt.Color(255, 255, 255));
        lblName5.setText("Note: Player 1 Starts First!!!");
        jPanel1.add(lblName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unobackground2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1030, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setPlayerNames(); // if you put in the constructor, its too early
        boolean flag = checkValidName();
        if(flag == false){
            JOptionPane.showMessageDialog(null, "You must enter a name to play!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            ArrayList<String>names = getPlayerNames();
            LiveGameWin win = new LiveGameWin(numberOfPlayers, names);
            win.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfName1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PlayerInfoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PlayerInfoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PlayerInfoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PlayerInfoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlayerInfoWin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfName1;
    private javax.swing.JTextField jtfName2;
    private javax.swing.JTextField jtfName3;
    private javax.swing.JTextField jtfName4;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblName5;
    // End of variables declaration//GEN-END:variables
}
