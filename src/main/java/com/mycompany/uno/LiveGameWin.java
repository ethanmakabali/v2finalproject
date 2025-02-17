package com.mycompany.uno;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author chief
 */
public class LiveGameWin extends javax.swing.JFrame {
     private ArrayList<JLabel> player1FaceDownCards;
     private ArrayList<JLabel> player2FaceDownCards;
     private ArrayList<JLabel> player3FaceDownCards;
     private ArrayList<JLabel> player4FaceDownCards;
     private ArrayList<JButton> btnCardSlots;
     private int numberOfPlayers;
     private Game game;
     
    /**
     * Creates new form LiveGame
     */
    public LiveGameWin(int numberOfPlayers, ArrayList<String> names) {
        initComponents();
        this.player1FaceDownCards = new ArrayList<>();
        this.player2FaceDownCards = new ArrayList<>();
        this.player3FaceDownCards = new ArrayList<>();
        this.player4FaceDownCards = new ArrayList<>();
        this.btnCardSlots = new ArrayList<>();
        initializeFaceDownCards();
        initializeBtnCardSlots();
        turnOnNoMovesPanel(true);
        this.numberOfPlayers = numberOfPlayers;
        System.out.println("Creating object");
        Deck deck = new Deck();
        System.out.println("Done");
        ArrayList<Card> mainPile = deck.getMainPile();
        Game game = new Game(names, deck, mainPile);
        this.game = game;
        setFaceDownCards();
        turnOffOtherFaceCardsAtStart();
//        System.out.println("TESTTTT");
        //https://www.shutterstock.com/image-vector/bangkok-thailand-may-212021-deck-600nw-1977486767.jpg
    }
    
    private void turnOffOtherFaceCardsAtStart(){
        if(numberOfPlayers == 4){
            return;
        }
        if(numberOfPlayers == 3){
            turnOffPlayer4FaceDownCards();
        }
        if(numberOfPlayers == 2){
            turnOffPlayer4FaceDownCards();
            turnOffPlayer3FaceDownCards();
        }
    }
    
    private void setFaceDownCards(){
        for(int i = 0; i < numberOfPlayers; i++){
            if(i == 0){
                int player1Size = game.getPlayerDeckSize(0);
                for(int j = player1Size; j < 20; j++){
                    player1FaceDownCards.get(j).setVisible(false);
                    lblPlayer1FaceDownCardsCount.setText(String.valueOf(player1Size));
                }
            }
            if(i == 1){
                int player2Size = game.getPlayerDeckSize(0);
                for(int j = player2Size; j < 20; j++){
                    player2FaceDownCards.get(j).setVisible(false);
                    lblPlayer2FaceDownCardsCount.setText(String.valueOf(player2Size));
                }
            }
            if(i == 2){
                int player3Size = game.getPlayerDeckSize(0);
                for(int j = player3Size; j < 20; j++){
                    player3FaceDownCards.get(j).setVisible(false);
                    lblPlayer3FaceDownCardsCount.setText(String.valueOf(player3Size));
                }
            }
            if(i == 3){
                int player4Size = game.getPlayerDeckSize(0);
                for(int j = player4Size; j < 20; j++){
                    player4FaceDownCards.get(j).setVisible(false);
                    lblPlayer4FaceDownCardsCount.setText(String.valueOf(player4Size));
                }
            }
        }
    }
    

    private void initializeFaceDownCards(){
        // Add the face down cards to player 1's array list
        player1FaceDownCards.add(imgPlayer1Back1);
        player1FaceDownCards.add(imgPlayer1Back2);
        player1FaceDownCards.add(imgPlayer1Back3);
        player1FaceDownCards.add(imgPlayer1Back4);
        player1FaceDownCards.add(imgPlayer1Back5);
        player1FaceDownCards.add(imgPlayer1Back6);
        player1FaceDownCards.add(imgPlayer1Back7);
        player1FaceDownCards.add(imgPlayer1Back8);
        player1FaceDownCards.add(imgPlayer1Back9);
        player1FaceDownCards.add(imgPlayer1Back10);
        player1FaceDownCards.add(imgPlayer1Back11);
        player1FaceDownCards.add(imgPlayer1Back12);
        player1FaceDownCards.add(imgPlayer1Back13);
        player1FaceDownCards.add(imgPlayer1Back14);
        player1FaceDownCards.add(imgPlayer1Back15);
        player1FaceDownCards.add(imgPlayer1Back16);
        player1FaceDownCards.add(imgPlayer1Back17);
        player1FaceDownCards.add(imgPlayer1Back18);
        player1FaceDownCards.add(imgPlayer1Back19);
        player1FaceDownCards.add(imgPlayer1Back20);
        
        // Add the face down cards to player 2's array list
        player2FaceDownCards.add(imgPlayer2Back1);
        player2FaceDownCards.add(imgPlayer2Back2);
        player2FaceDownCards.add(imgPlayer2Back3);
        player2FaceDownCards.add(imgPlayer2Back4);
        player2FaceDownCards.add(imgPlayer2Back5);
        player2FaceDownCards.add(imgPlayer2Back6);
        player2FaceDownCards.add(imgPlayer2Back7);
        player2FaceDownCards.add(imgPlayer2Back8);
        player2FaceDownCards.add(imgPlayer2Back9);
        player2FaceDownCards.add(imgPlayer2Back10);
        player2FaceDownCards.add(imgPlayer2Back11);
        player2FaceDownCards.add(imgPlayer2Back12);
        player2FaceDownCards.add(imgPlayer2Back13);
        player2FaceDownCards.add(imgPlayer2Back14);
        player2FaceDownCards.add(imgPlayer2Back15);
        player2FaceDownCards.add(imgPlayer2Back16);
        player2FaceDownCards.add(imgPlayer2Back17);
        player2FaceDownCards.add(imgPlayer2Back18);
        player2FaceDownCards.add(imgPlayer2Back19);
        player2FaceDownCards.add(imgPlayer2Back20);
        
        // Add the face down cards to player 3's array list
        player3FaceDownCards.add(imgPlayer3Back1);
        player3FaceDownCards.add(imgPlayer3Back2);
        player3FaceDownCards.add(imgPlayer3Back3);
        player3FaceDownCards.add(imgPlayer3Back4);
        player3FaceDownCards.add(imgPlayer3Back5);
        player3FaceDownCards.add(imgPlayer3Back6);
        player3FaceDownCards.add(imgPlayer3Back7);
        player3FaceDownCards.add(imgPlayer3Back8);
        player3FaceDownCards.add(imgPlayer3Back9);
        player3FaceDownCards.add(imgPlayer3Back10);
        player3FaceDownCards.add(imgPlayer3Back11);
        player3FaceDownCards.add(imgPlayer3Back12);
        player3FaceDownCards.add(imgPlayer3Back13);
        player3FaceDownCards.add(imgPlayer3Back14);
        player3FaceDownCards.add(imgPlayer3Back15);
        player3FaceDownCards.add(imgPlayer3Back16);
        player3FaceDownCards.add(imgPlayer3Back17);
        player3FaceDownCards.add(imgPlayer3Back18);
        player3FaceDownCards.add(imgPlayer3Back19);
        player3FaceDownCards.add(imgPlayer3Back20);
        
        // Add the face down cards to player 4's array list
        player4FaceDownCards.add(imgPlayer4Back1);
        player4FaceDownCards.add(imgPlayer4Back2);
        player4FaceDownCards.add(imgPlayer4Back3);
        player4FaceDownCards.add(imgPlayer4Back4);
        player4FaceDownCards.add(imgPlayer4Back5);
        player4FaceDownCards.add(imgPlayer4Back6);
        player4FaceDownCards.add(imgPlayer4Back7);
        player4FaceDownCards.add(imgPlayer4Back8);
        player4FaceDownCards.add(imgPlayer4Back9);
        player4FaceDownCards.add(imgPlayer4Back10);
        player4FaceDownCards.add(imgPlayer4Back11);
        player4FaceDownCards.add(imgPlayer4Back12);
        player4FaceDownCards.add(imgPlayer4Back13);
        player4FaceDownCards.add(imgPlayer4Back14);
        player4FaceDownCards.add(imgPlayer4Back15);
        player4FaceDownCards.add(imgPlayer4Back16);
        player4FaceDownCards.add(imgPlayer4Back17);
        player4FaceDownCards.add(imgPlayer4Back18);
        player4FaceDownCards.add(imgPlayer4Back19);
        player4FaceDownCards.add(imgPlayer4Back20);
        
    }
    
    private void initializeBtnCardSlots(){
        btnCardSlots.add(btnCardSlot1);
        btnCardSlots.add(btnCardSlot2);
        btnCardSlots.add(btnCardSlot3);
        btnCardSlots.add(btnCardSlot4);
        btnCardSlots.add(btnCardSlot5);
        btnCardSlots.add(btnCardSlot6);
        btnCardSlots.add(btnCardSlot7);
        btnCardSlots.add(btnCardSlot8);
        btnCardSlots.add(btnCardSlot9);
        btnCardSlots.add(btnCardSlot10);
        btnCardSlots.add(btnCardSlot11);
        btnCardSlots.add(btnCardSlot12);
        btnCardSlots.add(btnCardSlot13);
        btnCardSlots.add(btnCardSlot14);
        btnCardSlots.add(btnCardSlot15);
        btnCardSlots.add(btnCardSlot16);
        btnCardSlots.add(btnCardSlot17);
        btnCardSlots.add(btnCardSlot18);
        btnCardSlots.add(btnCardSlot19);
        btnCardSlots.add(btnCardSlot20);
    }
    
            
    // Methods to whether to show none of the face down cards
    //      e.g. : if a player has lost/forfeit
    //      False: hides all face down cards
    //
    //      design decision: decided to put stuff in a panel to set visibility
    private void turnOffPlayer1FaceDownCards(){
        pnlPlayer1FaceDownCards.setVisible(false);
    }
    
    private void turnOffPlayer2FaceDownCards(){
        pnlPlayer2FaceDownCards.setVisible(false);
    }
    
    private void turnOffPlayer3FaceDownCards(){
        pnlPlayer3FaceDownCards.setVisible(false);
    }
    
    private void turnOffPlayer4FaceDownCards(){
        pnlPlayer4FaceDownCards.setVisible(false);
    }
    
    // turning off windows
    private void turnOnNoMovesPanel(boolean isVisible){
        pnlNoMoves.setVisible(isVisible);
    }
    
    
    // create new window
    private void createHideCardsWindow(){
        HideCardsWin hideCards = new HideCardsWin();
        hideCards.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLiveGame = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel84 = new javax.swing.JPanel();
        btnCardSlot1 = new javax.swing.JButton();
        btnCardSlot2 = new javax.swing.JButton();
        btnCardSlot3 = new javax.swing.JButton();
        btnCardSlot6 = new javax.swing.JButton();
        btnCardSlot4 = new javax.swing.JButton();
        btnCardSlot5 = new javax.swing.JButton();
        btnCardSlot9 = new javax.swing.JButton();
        btnCardSlot7 = new javax.swing.JButton();
        btnCardSlot8 = new javax.swing.JButton();
        btnCardSlot12 = new javax.swing.JButton();
        btnCardSlot10 = new javax.swing.JButton();
        btnCardSlot11 = new javax.swing.JButton();
        btnCardSlot15 = new javax.swing.JButton();
        btnCardSlot13 = new javax.swing.JButton();
        btnCardSlot14 = new javax.swing.JButton();
        btnCardSlot18 = new javax.swing.JButton();
        btnCardSlot16 = new javax.swing.JButton();
        btnCardSlot17 = new javax.swing.JButton();
        btnCardSlot19 = new javax.swing.JButton();
        btnCardSlot20 = new javax.swing.JButton();
        pnlPlayer1FaceDownCards = new javax.swing.JPanel();
        imgPlayer1Back2 = new javax.swing.JLabel();
        imgPlayer1Back3 = new javax.swing.JLabel();
        imgPlayer1Back4 = new javax.swing.JLabel();
        imgPlayer1Back5 = new javax.swing.JLabel();
        imgPlayer1Back6 = new javax.swing.JLabel();
        imgPlayer1Back7 = new javax.swing.JLabel();
        imgPlayer1Back8 = new javax.swing.JLabel();
        imgPlayer1Back9 = new javax.swing.JLabel();
        imgPlayer1Back10 = new javax.swing.JLabel();
        imgPlayer1Back12 = new javax.swing.JLabel();
        imgPlayer1Back13 = new javax.swing.JLabel();
        imgPlayer1Back14 = new javax.swing.JLabel();
        imgPlayer1Back15 = new javax.swing.JLabel();
        imgPlayer1Back16 = new javax.swing.JLabel();
        imgPlayer1Back17 = new javax.swing.JLabel();
        imgPlayer1Back18 = new javax.swing.JLabel();
        imgPlayer1Back19 = new javax.swing.JLabel();
        imgPlayer1Back20 = new javax.swing.JLabel();
        imgPlayer1Back1 = new javax.swing.JLabel();
        imgPlayer1Back11 = new javax.swing.JLabel();
        lblPlayer1FaceDownCards = new javax.swing.JLabel();
        lblPlayer1FaceDownCardsCount = new javax.swing.JLabel();
        pnlPlayer2FaceDownCards = new javax.swing.JPanel();
        imgPlayer2Back2 = new javax.swing.JLabel();
        imgPlayer2Back3 = new javax.swing.JLabel();
        imgPlayer2Back4 = new javax.swing.JLabel();
        imgPlayer2Back5 = new javax.swing.JLabel();
        imgPlayer2Back6 = new javax.swing.JLabel();
        imgPlayer2Back7 = new javax.swing.JLabel();
        imgPlayer2Back8 = new javax.swing.JLabel();
        imgPlayer2Back9 = new javax.swing.JLabel();
        imgPlayer2Back10 = new javax.swing.JLabel();
        imgPlayer2Back12 = new javax.swing.JLabel();
        imgPlayer2Back13 = new javax.swing.JLabel();
        imgPlayer2Back14 = new javax.swing.JLabel();
        imgPlayer2Back15 = new javax.swing.JLabel();
        imgPlayer2Back16 = new javax.swing.JLabel();
        imgPlayer2Back17 = new javax.swing.JLabel();
        imgPlayer2Back18 = new javax.swing.JLabel();
        imgPlayer2Back19 = new javax.swing.JLabel();
        imgPlayer2Back20 = new javax.swing.JLabel();
        imgPlayer2Back1 = new javax.swing.JLabel();
        imgPlayer2Back11 = new javax.swing.JLabel();
        lblPlayer2FaceDownCards = new javax.swing.JLabel();
        lblPlayer2FaceDownCardsCount = new javax.swing.JLabel();
        pnlPlayer3FaceDownCards = new javax.swing.JPanel();
        imgPlayer3Back2 = new javax.swing.JLabel();
        imgPlayer3Back3 = new javax.swing.JLabel();
        imgPlayer3Back4 = new javax.swing.JLabel();
        imgPlayer3Back5 = new javax.swing.JLabel();
        imgPlayer3Back6 = new javax.swing.JLabel();
        imgPlayer3Back7 = new javax.swing.JLabel();
        imgPlayer3Back8 = new javax.swing.JLabel();
        imgPlayer3Back9 = new javax.swing.JLabel();
        imgPlayer3Back10 = new javax.swing.JLabel();
        imgPlayer3Back12 = new javax.swing.JLabel();
        imgPlayer3Back13 = new javax.swing.JLabel();
        imgPlayer3Back14 = new javax.swing.JLabel();
        imgPlayer3Back15 = new javax.swing.JLabel();
        imgPlayer3Back16 = new javax.swing.JLabel();
        imgPlayer3Back17 = new javax.swing.JLabel();
        imgPlayer3Back18 = new javax.swing.JLabel();
        imgPlayer3Back19 = new javax.swing.JLabel();
        imgPlayer3Back20 = new javax.swing.JLabel();
        imgPlayer3Back1 = new javax.swing.JLabel();
        imgPlayer3Back11 = new javax.swing.JLabel();
        lblPlayer3FaceDownCards = new javax.swing.JLabel();
        lblPlayer3FaceDownCardsCount = new javax.swing.JLabel();
        pnlPlayer4FaceDownCards = new javax.swing.JPanel();
        imgPlayer4Back2 = new javax.swing.JLabel();
        imgPlayer4Back3 = new javax.swing.JLabel();
        imgPlayer4Back4 = new javax.swing.JLabel();
        imgPlayer4Back5 = new javax.swing.JLabel();
        imgPlayer4Back6 = new javax.swing.JLabel();
        imgPlayer4Back7 = new javax.swing.JLabel();
        imgPlayer4Back8 = new javax.swing.JLabel();
        imgPlayer4Back9 = new javax.swing.JLabel();
        imgPlayer4Back10 = new javax.swing.JLabel();
        imgPlayer4Back12 = new javax.swing.JLabel();
        imgPlayer4Back13 = new javax.swing.JLabel();
        imgPlayer4Back14 = new javax.swing.JLabel();
        imgPlayer4Back15 = new javax.swing.JLabel();
        imgPlayer4Back16 = new javax.swing.JLabel();
        imgPlayer4Back17 = new javax.swing.JLabel();
        imgPlayer4Back18 = new javax.swing.JLabel();
        imgPlayer4Back19 = new javax.swing.JLabel();
        imgPlayer4Back20 = new javax.swing.JLabel();
        imgPlayer4Back1 = new javax.swing.JLabel();
        imgPlayer4Back11 = new javax.swing.JLabel();
        lblPlayer4FaceDownCards = new javax.swing.JLabel();
        lblPlayer4FaceDownCardsCount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnForfeit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnQuitGame = new javax.swing.JButton();
        pnlNoMoves = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlLiveGame.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setText("Ethan Makabali productions");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel7.setText("Your cards:");

        btnHelp.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setText("(Click on the card you want to play)");

        jPanel84.setBackground(new java.awt.Color(153, 255, 204));
        jPanel84.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel84.setForeground(new java.awt.Color(0, 0, 255));

        btnCardSlot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot1ActionPerformed(evt);
            }
        });

        btnCardSlot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(btnCardSlot19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCardSlot20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot16, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCardSlot20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCardSlot19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane1.setViewportView(jPanel84);

        pnlPlayer1FaceDownCards.setBackground(new java.awt.Color(153, 255, 153));

        imgPlayer1Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer1Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        lblPlayer1FaceDownCards.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCards.setText("Player 1 Cards: ");

        lblPlayer1FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCardsCount.setText("0");

        javax.swing.GroupLayout pnlPlayer1FaceDownCardsLayout = new javax.swing.GroupLayout(pnlPlayer1FaceDownCards);
        pnlPlayer1FaceDownCards.setLayout(pnlPlayer1FaceDownCardsLayout);
        pnlPlayer1FaceDownCardsLayout.setHorizontalGroup(
            pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                        .addComponent(imgPlayer1Back11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer1Back20))
                    .addGroup(pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                        .addGroup(pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer1Back1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(lblPlayer1FaceDownCards)
                                .addGap(43, 43, 43)))
                        .addGroup(pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlayer1FaceDownCardsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer1Back6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer1Back10)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlPlayer1FaceDownCardsLayout.setVerticalGroup(
            pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayer1FaceDownCardsLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayer1FaceDownCards)
                    .addComponent(lblPlayer1FaceDownCardsCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer1Back10)
                    .addComponent(imgPlayer1Back9)
                    .addComponent(imgPlayer1Back8)
                    .addComponent(imgPlayer1Back7)
                    .addComponent(imgPlayer1Back6)
                    .addComponent(imgPlayer1Back5)
                    .addComponent(imgPlayer1Back4)
                    .addComponent(imgPlayer1Back3)
                    .addComponent(imgPlayer1Back2)
                    .addComponent(imgPlayer1Back1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer1FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer1Back20)
                    .addComponent(imgPlayer1Back19)
                    .addComponent(imgPlayer1Back18)
                    .addComponent(imgPlayer1Back17)
                    .addComponent(imgPlayer1Back16)
                    .addComponent(imgPlayer1Back15)
                    .addComponent(imgPlayer1Back14)
                    .addComponent(imgPlayer1Back13)
                    .addComponent(imgPlayer1Back12)
                    .addComponent(imgPlayer1Back11))
                .addContainerGap())
        );

        pnlPlayer2FaceDownCards.setBackground(new java.awt.Color(153, 255, 153));

        imgPlayer2Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer2Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        lblPlayer2FaceDownCards.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer2FaceDownCards.setText("Player 2 Cards: ");

        lblPlayer2FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer2FaceDownCardsCount.setText("0");

        javax.swing.GroupLayout pnlPlayer2FaceDownCardsLayout = new javax.swing.GroupLayout(pnlPlayer2FaceDownCards);
        pnlPlayer2FaceDownCards.setLayout(pnlPlayer2FaceDownCardsLayout);
        pnlPlayer2FaceDownCardsLayout.setHorizontalGroup(
            pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer2FaceDownCardsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPlayer2FaceDownCardsLayout.createSequentialGroup()
                        .addComponent(imgPlayer2Back11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer2Back20))
                    .addGroup(pnlPlayer2FaceDownCardsLayout.createSequentialGroup()
                        .addGroup(pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPlayer2FaceDownCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlPlayer2FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer2Back1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPlayer2FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer2Back6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer2Back10))
                            .addComponent(lblPlayer2FaceDownCardsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlPlayer2FaceDownCardsLayout.setVerticalGroup(
            pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayer2FaceDownCardsLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayer2FaceDownCards)
                    .addComponent(lblPlayer2FaceDownCardsCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer2Back10)
                    .addComponent(imgPlayer2Back9)
                    .addComponent(imgPlayer2Back8)
                    .addComponent(imgPlayer2Back7)
                    .addComponent(imgPlayer2Back6)
                    .addComponent(imgPlayer2Back5)
                    .addComponent(imgPlayer2Back4)
                    .addComponent(imgPlayer2Back3)
                    .addComponent(imgPlayer2Back2)
                    .addComponent(imgPlayer2Back1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer2FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer2Back20)
                    .addComponent(imgPlayer2Back19)
                    .addComponent(imgPlayer2Back18)
                    .addComponent(imgPlayer2Back17)
                    .addComponent(imgPlayer2Back16)
                    .addComponent(imgPlayer2Back15)
                    .addComponent(imgPlayer2Back14)
                    .addComponent(imgPlayer2Back13)
                    .addComponent(imgPlayer2Back12)
                    .addComponent(imgPlayer2Back11)))
        );

        pnlPlayer3FaceDownCards.setBackground(new java.awt.Color(153, 255, 153));

        imgPlayer3Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer3Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        lblPlayer3FaceDownCards.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer3FaceDownCards.setText("Player 3 Cards: ");

        lblPlayer3FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer3FaceDownCardsCount.setText("0");

        javax.swing.GroupLayout pnlPlayer3FaceDownCardsLayout = new javax.swing.GroupLayout(pnlPlayer3FaceDownCards);
        pnlPlayer3FaceDownCards.setLayout(pnlPlayer3FaceDownCardsLayout);
        pnlPlayer3FaceDownCardsLayout.setHorizontalGroup(
            pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer3FaceDownCardsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPlayer3FaceDownCardsLayout.createSequentialGroup()
                        .addComponent(imgPlayer3Back11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer3Back20))
                    .addGroup(pnlPlayer3FaceDownCardsLayout.createSequentialGroup()
                        .addGroup(pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPlayer3FaceDownCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlPlayer3FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer3Back1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPlayer3FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer3Back6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer3Back10))
                            .addComponent(lblPlayer3FaceDownCardsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlPlayer3FaceDownCardsLayout.setVerticalGroup(
            pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayer3FaceDownCardsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayer3FaceDownCards)
                    .addComponent(lblPlayer3FaceDownCardsCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer3Back10)
                    .addComponent(imgPlayer3Back9)
                    .addComponent(imgPlayer3Back8)
                    .addComponent(imgPlayer3Back7)
                    .addComponent(imgPlayer3Back6)
                    .addComponent(imgPlayer3Back5)
                    .addComponent(imgPlayer3Back4)
                    .addComponent(imgPlayer3Back3)
                    .addComponent(imgPlayer3Back2)
                    .addComponent(imgPlayer3Back1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer3FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer3Back20)
                    .addComponent(imgPlayer3Back19)
                    .addComponent(imgPlayer3Back18)
                    .addComponent(imgPlayer3Back17)
                    .addComponent(imgPlayer3Back16)
                    .addComponent(imgPlayer3Back15)
                    .addComponent(imgPlayer3Back14)
                    .addComponent(imgPlayer3Back13)
                    .addComponent(imgPlayer3Back12)
                    .addComponent(imgPlayer3Back11))
                .addContainerGap())
        );

        pnlPlayer4FaceDownCards.setBackground(new java.awt.Color(153, 255, 153));

        imgPlayer4Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        imgPlayer4Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unoback.png"))); // NOI18N

        lblPlayer4FaceDownCards.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer4FaceDownCards.setText("Player 4 Cards: ");

        lblPlayer4FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer4FaceDownCardsCount.setText("0");

        javax.swing.GroupLayout pnlPlayer4FaceDownCardsLayout = new javax.swing.GroupLayout(pnlPlayer4FaceDownCards);
        pnlPlayer4FaceDownCards.setLayout(pnlPlayer4FaceDownCardsLayout);
        pnlPlayer4FaceDownCardsLayout.setHorizontalGroup(
            pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlayer4FaceDownCardsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblPlayer4FaceDownCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
            .addGroup(pnlPlayer4FaceDownCardsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPlayer4FaceDownCardsLayout.createSequentialGroup()
                        .addComponent(imgPlayer4Back11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back20))
                    .addGroup(pnlPlayer4FaceDownCardsLayout.createSequentialGroup()
                        .addComponent(imgPlayer4Back1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgPlayer4Back5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlayer4FaceDownCardsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPlayer4FaceDownCardsLayout.createSequentialGroup()
                                .addComponent(imgPlayer4Back6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer4Back7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer4Back8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer4Back9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgPlayer4Back10)))))
                .addGap(15, 15, 15))
        );
        pnlPlayer4FaceDownCardsLayout.setVerticalGroup(
            pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlayer4FaceDownCardsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayer4FaceDownCards)
                    .addComponent(lblPlayer4FaceDownCardsCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer4Back10)
                    .addComponent(imgPlayer4Back9)
                    .addComponent(imgPlayer4Back8)
                    .addComponent(imgPlayer4Back7)
                    .addComponent(imgPlayer4Back6)
                    .addComponent(imgPlayer4Back5)
                    .addComponent(imgPlayer4Back4)
                    .addComponent(imgPlayer4Back3)
                    .addComponent(imgPlayer4Back2)
                    .addComponent(imgPlayer4Back1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPlayer4FaceDownCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgPlayer4Back20)
                    .addComponent(imgPlayer4Back19)
                    .addComponent(imgPlayer4Back18)
                    .addComponent(imgPlayer4Back17)
                    .addComponent(imgPlayer4Back16)
                    .addComponent(imgPlayer4Back15)
                    .addComponent(imgPlayer4Back14)
                    .addComponent(imgPlayer4Back13)
                    .addComponent(imgPlayer4Back12)
                    .addComponent(imgPlayer4Back11))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jPanel85.setBackground(new java.awt.Color(0, 255, 204));
        jPanel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        btnForfeit.setBackground(new java.awt.Color(255, 51, 51));
        btnForfeit.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnForfeit.setText("Forfeit?");
        btnForfeit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForfeitActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButton2.setText("Settings");

        btnQuitGame.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnQuitGame.setText("Quit Game (Main Menu)");
        btnQuitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnForfeit, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(btnQuitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnForfeit, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNoMoves.setBackground(new java.awt.Color(153, 255, 153));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("You don't have any available moves!");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Drawing a new card in:");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 204));
        jLabel6.setText("5");

        javax.swing.GroupLayout pnlNoMovesLayout = new javax.swing.GroupLayout(pnlNoMoves);
        pnlNoMoves.setLayout(pnlNoMovesLayout);
        pnlNoMovesLayout.setHorizontalGroup(
            pnlNoMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNoMovesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNoMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNoMovesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlNoMovesLayout.setVerticalGroup(
            pnlNoMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNoMovesLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNoMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setText("Current Card:");

        javax.swing.GroupLayout pnlLiveGameLayout = new javax.swing.GroupLayout(pnlLiveGame);
        pnlLiveGame.setLayout(pnlLiveGameLayout);
        pnlLiveGameLayout.setHorizontalGroup(
            pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlNoMoves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLiveGameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(196, 196, 196))
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPlayer4FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPlayer2FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPlayer3FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPlayer1FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlLiveGameLayout.setVerticalGroup(
            pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                .addComponent(pnlPlayer1FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPlayer2FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlPlayer3FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPlayer4FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLiveGameLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addComponent(pnlNoMoves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLiveGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLiveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        HelpWin helpwin = new HelpWin();
        helpwin.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnForfeitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForfeitActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to forfeit?", "Forfeit?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            return;
        }
    }//GEN-LAST:event_btnForfeitActionPerformed

    private void btnQuitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitGameActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the main menu?"
                + " (Scores will reset)",
                "Return to main menu?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            this.dispose();
            Uno homescreen = new Uno();
            homescreen.setVisible(true);
        } else {
            return;
        }
    }//GEN-LAST:event_btnQuitGameActionPerformed

    private void btnCardSlot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot1ActionPerformed
        // TODO add your handling code here:
        createHideCardsWindow();
        game.moveToNextPlayer();
    }//GEN-LAST:event_btnCardSlot1ActionPerformed

    
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
//            java.util.logging.Logger.getLogger(LiveGameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LiveGameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LiveGameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LiveGameWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LiveGameWin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCardSlot1;
    private javax.swing.JButton btnCardSlot10;
    private javax.swing.JButton btnCardSlot11;
    private javax.swing.JButton btnCardSlot12;
    private javax.swing.JButton btnCardSlot13;
    private javax.swing.JButton btnCardSlot14;
    private javax.swing.JButton btnCardSlot15;
    private javax.swing.JButton btnCardSlot16;
    private javax.swing.JButton btnCardSlot17;
    private javax.swing.JButton btnCardSlot18;
    private javax.swing.JButton btnCardSlot19;
    private javax.swing.JButton btnCardSlot2;
    private javax.swing.JButton btnCardSlot20;
    private javax.swing.JButton btnCardSlot3;
    private javax.swing.JButton btnCardSlot4;
    private javax.swing.JButton btnCardSlot5;
    private javax.swing.JButton btnCardSlot6;
    private javax.swing.JButton btnCardSlot7;
    private javax.swing.JButton btnCardSlot8;
    private javax.swing.JButton btnCardSlot9;
    private javax.swing.JButton btnForfeit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnQuitGame;
    private javax.swing.JLabel imgPlayer1Back1;
    private javax.swing.JLabel imgPlayer1Back10;
    private javax.swing.JLabel imgPlayer1Back11;
    private javax.swing.JLabel imgPlayer1Back12;
    private javax.swing.JLabel imgPlayer1Back13;
    private javax.swing.JLabel imgPlayer1Back14;
    private javax.swing.JLabel imgPlayer1Back15;
    private javax.swing.JLabel imgPlayer1Back16;
    private javax.swing.JLabel imgPlayer1Back17;
    private javax.swing.JLabel imgPlayer1Back18;
    private javax.swing.JLabel imgPlayer1Back19;
    private javax.swing.JLabel imgPlayer1Back2;
    private javax.swing.JLabel imgPlayer1Back20;
    private javax.swing.JLabel imgPlayer1Back3;
    private javax.swing.JLabel imgPlayer1Back4;
    private javax.swing.JLabel imgPlayer1Back5;
    private javax.swing.JLabel imgPlayer1Back6;
    private javax.swing.JLabel imgPlayer1Back7;
    private javax.swing.JLabel imgPlayer1Back8;
    private javax.swing.JLabel imgPlayer1Back9;
    private javax.swing.JLabel imgPlayer2Back1;
    private javax.swing.JLabel imgPlayer2Back10;
    private javax.swing.JLabel imgPlayer2Back11;
    private javax.swing.JLabel imgPlayer2Back12;
    private javax.swing.JLabel imgPlayer2Back13;
    private javax.swing.JLabel imgPlayer2Back14;
    private javax.swing.JLabel imgPlayer2Back15;
    private javax.swing.JLabel imgPlayer2Back16;
    private javax.swing.JLabel imgPlayer2Back17;
    private javax.swing.JLabel imgPlayer2Back18;
    private javax.swing.JLabel imgPlayer2Back19;
    private javax.swing.JLabel imgPlayer2Back2;
    private javax.swing.JLabel imgPlayer2Back20;
    private javax.swing.JLabel imgPlayer2Back3;
    private javax.swing.JLabel imgPlayer2Back4;
    private javax.swing.JLabel imgPlayer2Back5;
    private javax.swing.JLabel imgPlayer2Back6;
    private javax.swing.JLabel imgPlayer2Back7;
    private javax.swing.JLabel imgPlayer2Back8;
    private javax.swing.JLabel imgPlayer2Back9;
    private javax.swing.JLabel imgPlayer3Back1;
    private javax.swing.JLabel imgPlayer3Back10;
    private javax.swing.JLabel imgPlayer3Back11;
    private javax.swing.JLabel imgPlayer3Back12;
    private javax.swing.JLabel imgPlayer3Back13;
    private javax.swing.JLabel imgPlayer3Back14;
    private javax.swing.JLabel imgPlayer3Back15;
    private javax.swing.JLabel imgPlayer3Back16;
    private javax.swing.JLabel imgPlayer3Back17;
    private javax.swing.JLabel imgPlayer3Back18;
    private javax.swing.JLabel imgPlayer3Back19;
    private javax.swing.JLabel imgPlayer3Back2;
    private javax.swing.JLabel imgPlayer3Back20;
    private javax.swing.JLabel imgPlayer3Back3;
    private javax.swing.JLabel imgPlayer3Back4;
    private javax.swing.JLabel imgPlayer3Back5;
    private javax.swing.JLabel imgPlayer3Back6;
    private javax.swing.JLabel imgPlayer3Back7;
    private javax.swing.JLabel imgPlayer3Back8;
    private javax.swing.JLabel imgPlayer3Back9;
    private javax.swing.JLabel imgPlayer4Back1;
    private javax.swing.JLabel imgPlayer4Back10;
    private javax.swing.JLabel imgPlayer4Back11;
    private javax.swing.JLabel imgPlayer4Back12;
    private javax.swing.JLabel imgPlayer4Back13;
    private javax.swing.JLabel imgPlayer4Back14;
    private javax.swing.JLabel imgPlayer4Back15;
    private javax.swing.JLabel imgPlayer4Back16;
    private javax.swing.JLabel imgPlayer4Back17;
    private javax.swing.JLabel imgPlayer4Back18;
    private javax.swing.JLabel imgPlayer4Back19;
    private javax.swing.JLabel imgPlayer4Back2;
    private javax.swing.JLabel imgPlayer4Back20;
    private javax.swing.JLabel imgPlayer4Back3;
    private javax.swing.JLabel imgPlayer4Back4;
    private javax.swing.JLabel imgPlayer4Back5;
    private javax.swing.JLabel imgPlayer4Back6;
    private javax.swing.JLabel imgPlayer4Back7;
    private javax.swing.JLabel imgPlayer4Back8;
    private javax.swing.JLabel imgPlayer4Back9;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPlayer1FaceDownCards;
    private javax.swing.JLabel lblPlayer1FaceDownCardsCount;
    private javax.swing.JLabel lblPlayer2FaceDownCards;
    private javax.swing.JLabel lblPlayer2FaceDownCardsCount;
    private javax.swing.JLabel lblPlayer3FaceDownCards;
    private javax.swing.JLabel lblPlayer3FaceDownCardsCount;
    private javax.swing.JLabel lblPlayer4FaceDownCards;
    private javax.swing.JLabel lblPlayer4FaceDownCardsCount;
    private javax.swing.JPanel pnlLiveGame;
    private javax.swing.JPanel pnlNoMoves;
    private javax.swing.JPanel pnlPlayer1FaceDownCards;
    private javax.swing.JPanel pnlPlayer2FaceDownCards;
    private javax.swing.JPanel pnlPlayer3FaceDownCards;
    private javax.swing.JPanel pnlPlayer4FaceDownCards;
    // End of variables declaration//GEN-END:variables
}
