package com.mycompany.uno;


import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
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

// HASH MAPS:
//https://www.bing.com/search?qs=LS&pq=HashMap+&sk=CSYN1&sc=16-8&pglt=297&q=hashmap+java&cvid=d9dc154cf14f4806bf69113f1241972b&gs_lcrp=EgRlZGdlKgYIABAAGEAyBggAEAAYQDIGCAEQRRg5MgYIAhAAGEAyBggDEAAYQDIGCAQQABhAMgYIBRAAGEAyBggGEAAYQDIGCAcQABhAMgYICBAAGEDSAQgzMjE5ajBqMagCALACAA&FORM=ANNTA1&PC=LCTS

public class LiveGameWin extends javax.swing.JFrame {
    // UI stuff
     private ArrayList<JLabel> player1FaceDownCards;
     private ArrayList<JLabel> player2FaceDownCards;
     private ArrayList<JLabel> player3FaceDownCards;
     private ArrayList<JLabel> player4FaceDownCards;
     private ArrayList<JLabel> playerCountLabels;
     private ArrayList<ArrayList<JLabel>> playerFaceDownCards;
     private ArrayList<JButton> btnCardSlots;
     // Game instance fields
     private Game game;
     private Deck deck;
     // Current number of players
     private int numberOfPlayers;
     private ArrayList<String> names;
     
    /**
     * Creates new form LiveGame
     */
    public LiveGameWin(int numberOfPlayers, ArrayList<String> names) {
        initComponents();
        this.playerFaceDownCards = new ArrayList<>();
        this.player1FaceDownCards = new ArrayList<>();
        this.player2FaceDownCards = new ArrayList<>();
        this.player3FaceDownCards = new ArrayList<>();
        this.player4FaceDownCards = new ArrayList<>();
        this.btnCardSlots = new ArrayList<>();
        
        this.playerFaceDownCards.add(this.player1FaceDownCards);
        this.playerFaceDownCards.add(this.player2FaceDownCards);
        this.playerFaceDownCards.add(this.player3FaceDownCards);
        this.playerFaceDownCards.add(this.player4FaceDownCards);
        
        this.playerCountLabels = new ArrayList<>();
        
        this.playerCountLabels.add(this.lblPlayer1FaceDownCardsCount);
        this.playerCountLabels.add(this.lblPlayer2FaceDownCardsCount);
        this.playerCountLabels.add(this.lblPlayer3FaceDownCardsCount);
        this.playerCountLabels.add(this.lblPlayer4FaceDownCardsCount);

                
        initializeFaceDownCards();
        initializeBtnCardSlots();
        
        this.numberOfPlayers = numberOfPlayers;
        System.out.println("Creating object");
        this.deck = new Deck();
        System.out.println("Done");
        Game game = new Game(names, deck);
        this.names = names;
        this.game = game;
        setFaceDownCards();
        turnOffOtherFaceCardsAtStart();
        updatePlayerCards();
        lblCurrentPlayer.setText(game.getCurrentPlayer().getName());
        lblNextPlayer.setText(game.getNextPlayer().getName());  
        //https://www.shutterstock.com/image-vector/bangkok-thailand-may-212021-deck-600nw-1977486767.jpg
    }
    
    
    private void updatePlayerCards() {
        ArrayList<Card> currentPlayerDeck = game.getCurrentPlayerDeck();
        int currentPlayerDeckSize = currentPlayerDeck.size();

        for (int i = 0; i < btnCardSlots.size(); i++) {
            btnCardSlots.get(i).setVisible(true);
            JButton targetSlot = btnCardSlots.get(i);

            if (i < currentPlayerDeckSize) {
                String target = currentPlayerDeck.get(i).toString();

                String imageName = currentPlayerDeck.get(i).getImageName();
                URL imageUrl = getClass().getResource("/" + imageName);

                if (imageUrl != null) {
                    ImageIcon originalIcon = new ImageIcon(imageUrl);
                    Image scaledImage = originalIcon.getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH); // size for button slots
                    ImageIcon resizedIcon = new ImageIcon(scaledImage);
                    targetSlot.setIcon(resizedIcon);
                } else {
                    System.err.println("Image not found: " + imageName);
                    targetSlot.setIcon(null);
                }
            } else {
                targetSlot.setIcon(null); // Hide extra slots if deck has fewer cards
                btnCardSlots.get(i).setVisible(false);
            }
        }
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
        for (int i = 0; i < numberOfPlayers; i++) {
            int playerSize = game.getPlayerDeckSize(i);
            for (int j = 0; j < 20; j++) {
                boolean visible = j < playerSize;
                this.playerFaceDownCards.get(i).get(j).setVisible(visible);
            }
            this.playerCountLabels.get(i).setText(String.valueOf(playerSize));
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
    
    
    private void createHideCardsWindow(){
        HideCardsWin hideCards = new HideCardsWin();
        hideCards.setVisible(true);
    }
    
    private boolean hasLegalMove() {
        // Check if the game just started (DP is empty), then theres a legal move (any card)
        if (deck.getDiscardPile().isEmpty()) {
            return true;
        }

        // Get the current players deck as well as the top card on the discard pile
        ArrayList<Card> playerHand = game.getCurrentPlayerDeck();
        Card topCard = deck.getDiscardCard();

        // Go through the players deck and if theres a card we can play, return true
        for (Card card : playerHand) {
            if (card.canPlayCard(topCard)) {
                return true;
            }
        }
        return false;
    }

    private void checkPlayerMoves() {
        Player currentPlayer = game.getCurrentPlayer();

        if (!hasLegalMove()) {
            Card drawnCard = deck.getNextMainPileCard();
            currentPlayer.getCurrentPlayerDeck().add(drawnCard);

            JOptionPane.showMessageDialog(
                null,
                currentPlayer.getName() + " had no legal moves and drew a card.",
                "No Legal Moves",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Update GUI
            setFaceDownCards();
            updatePlayerCards();

            // Check if the drawn card is playable
            if (!drawnCard.canPlayCard(deck.getDiscardCard())) {
                JOptionPane.showMessageDialog(
                    null,
                    "Still no legal moves. Skipping turn.",
                    "Turn Skipped",
                    JOptionPane.INFORMATION_MESSAGE
                );

                game.moveToNextPlayer();
                lblCurrentPlayer.setText(game.getCurrentPlayer().getName());
                lblNextPlayer.setText(game.getNextPlayer().getName());
                setFaceDownCards();
                updatePlayerCards();
            }
            // If it IS playable, just let them play it naturally (don’t auto-play it)
        }
    }

    
    private void playCard(int cardIndex){
        // Get current players card
        Card playerCard = game.getCurrentPlayerDeck().get(cardIndex - 1);
        Player currentPlayer = game.getCurrentPlayer();
        
        // Boolean to determine whether to check if theres a winner
        boolean nextStep = false;  // Change this variable name it sucks???
        ArrayList<Card> discardPile = deck.getDiscardPile();
        
        // Get the color of the played card
        String declaredColor = playerCard.getColor();
        lblCurrentColor.setText("Identifying Next Color");
        
        // First, Check if its a Wild Card
        if (playerCard.isWildcard()) {
            String[] possibilities = { "Blue", "Green", "Red", "Yellow" };
            String s = (String)JOptionPane.showInputDialog(
                null,
                "Choose Wildcard Color",
                "Wildcard Color",
                 JOptionPane.PLAIN_MESSAGE,
                 null,
                 possibilities,
                 null);
            playerCard.declareColor(s);
            declaredColor = s;
        }
        
        // Check if the card played is legal, and if so... do this... 
        if (game.playCard(playerCard, declaredColor) == true){
            lblCurrentColor.setText(playerCard.getColor());
            
            // Add the played card to the discard pile and update UI
            discardPile.add(playerCard);
            setFaceDownCards();
            updatePlayerCards();
            lblCurrentPlayer.setText(game.getCurrentPlayer().getName());
            lblNextPlayer.setText(game.getNextPlayer().getName());
            
            // Since the card was played, change the bool flag so we know to 
            // check for a winner after this branch
            nextStep = true;

            // Update the UI, first get played cards image
            String imageName = playerCard.getImageName(); // e.g., "blue_0.png"

            // Load the image from the root of the classpath
            URL imageUrl = getClass().getResource("/" + imageName);

            if (imageUrl != null) {
                ImageIcon originalIcon = new ImageIcon(imageUrl);
                Image scaledImage = originalIcon.getImage().getScaledInstance(324, 380, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(scaledImage);
                ImageHolder.setIcon(resizedIcon);
            } else {
                System.err.println("Image not found: /" + imageName);
                ImageHolder.setIcon(null); // fallback
            }
            // If the branch above does not execute, then the move isn't legal
        } else {
            JOptionPane.showMessageDialog(null, "Please play a legal move", "Invalid Move", JOptionPane.INFORMATION_MESSAGE);
        }

        // If the flag is true, we can now check if there is a winner
        if (game.isThereWinner() == true && nextStep == true){
            Player winner = game.getWinner();
            WinnerWin winnerScreen = new WinnerWin(winner, numberOfPlayers, names, this);
            winnerScreen.setVisible(true);
        } else {
            checkPlayerMoves();
        }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        ImageHolder = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnQuitGame = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblCurrent = new javax.swing.JLabel();
        lblNextPlayer = new javax.swing.JLabel();
        lblCurrentPlayer = new javax.swing.JLabel();
        lblondeck = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCurrentColor = new javax.swing.JLabel();
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
        lblPlayer1FaceDownCards1 = new javax.swing.JLabel();
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
        lblPlayer1FaceDownCards2 = new javax.swing.JLabel();
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
        lblPlayer1FaceDownCards3 = new javax.swing.JLabel();
        lblPlayer4FaceDownCardsCount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlLiveGame.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 255));
        jLabel1.setText("Ethan Makabali Productions");

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

        btnCardSlot2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_draw2.png"))); // NOI18N
        btnCardSlot2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot2ActionPerformed(evt);
            }
        });

        btnCardSlot3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red_1.png"))); // NOI18N
        btnCardSlot3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot3ActionPerformed(evt);
            }
        });

        btnCardSlot6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot6ActionPerformed(evt);
            }
        });

        btnCardSlot4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot4ActionPerformed(evt);
            }
        });

        btnCardSlot5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot5ActionPerformed(evt);
            }
        });

        btnCardSlot9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot9ActionPerformed(evt);
            }
        });

        btnCardSlot7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot7ActionPerformed(evt);
            }
        });

        btnCardSlot8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot8ActionPerformed(evt);
            }
        });

        btnCardSlot12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot12ActionPerformed(evt);
            }
        });

        btnCardSlot10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot10ActionPerformed(evt);
            }
        });

        btnCardSlot11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot11ActionPerformed(evt);
            }
        });

        btnCardSlot15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot15ActionPerformed(evt);
            }
        });

        btnCardSlot13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot13ActionPerformed(evt);
            }
        });

        btnCardSlot14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardSlot14ActionPerformed(evt);
            }
        });

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
                .addContainerGap(43, Short.MAX_VALUE))
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
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCardSlot11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCardSlot10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCardSlot12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pnlPlayer1FaceDownCards.setBackground(new java.awt.Color(51, 153, 0));
        pnlPlayer1FaceDownCards.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPlayer1FaceDownCards.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgPlayer1Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 33, -1, -1));

        imgPlayer1Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 33, -1, -1));

        imgPlayer1Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 33, -1, -1));

        imgPlayer1Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 33, -1, -1));

        imgPlayer1Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 33, -1, -1));

        imgPlayer1Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 33, -1, -1));

        imgPlayer1Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 33, -1, -1));

        imgPlayer1Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 33, -1, -1));

        imgPlayer1Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 33, -1, -1));

        imgPlayer1Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back12, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 93, -1, -1));

        imgPlayer1Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back13, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 93, -1, -1));

        imgPlayer1Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back14, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 93, -1, -1));

        imgPlayer1Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back15, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 93, -1, -1));

        imgPlayer1Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back16, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 93, -1, -1));

        imgPlayer1Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back17, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 93, -1, -1));

        imgPlayer1Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back18, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 93, -1, -1));

        imgPlayer1Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back19, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 93, -1, -1));

        imgPlayer1Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back20, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 93, -1, -1));

        imgPlayer1Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 33, -1, -1));

        imgPlayer1Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer1FaceDownCards.add(imgPlayer1Back11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 93, -1, -1));

        lblPlayer1FaceDownCards.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCards.setText("Player 1 Cards: ");
        pnlPlayer1FaceDownCards.add(lblPlayer1FaceDownCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        lblPlayer1FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCardsCount.setText("0");
        pnlPlayer1FaceDownCards.add(lblPlayer1FaceDownCardsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 61, -1));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jPanel85.setBackground(new java.awt.Color(0, 255, 204));
        jPanel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel85.add(ImageHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 320, 380));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setText("Play Any Card To Get Started!");
        jPanel85.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

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
                .addComponent(btnQuitGame, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnQuitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setText("Current Card:");

        lblCurrent.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblCurrent.setForeground(new java.awt.Color(0, 51, 255));
        lblCurrent.setText("Current Player:");

        lblNextPlayer.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblNextPlayer.setText("On Deck:");

        lblCurrentPlayer.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblCurrentPlayer.setText("Current Player");

        lblondeck.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblondeck.setForeground(new java.awt.Color(0, 51, 255));
        lblondeck.setText("On Deck");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Current Color:");

        lblCurrentColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCurrentColor.setText("No Color Detected");

        pnlPlayer2FaceDownCards.setBackground(new java.awt.Color(255, 153, 255));
        pnlPlayer2FaceDownCards.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPlayer2FaceDownCards.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgPlayer2Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 33, -1, -1));

        imgPlayer2Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 33, -1, -1));

        imgPlayer2Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 33, -1, -1));

        imgPlayer2Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 33, -1, -1));

        imgPlayer2Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 33, -1, -1));

        imgPlayer2Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 33, -1, -1));

        imgPlayer2Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 33, -1, -1));

        imgPlayer2Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 33, -1, -1));

        imgPlayer2Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 33, -1, -1));

        imgPlayer2Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back12, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 93, -1, -1));

        imgPlayer2Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back13, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 93, -1, -1));

        imgPlayer2Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back14, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 93, -1, -1));

        imgPlayer2Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back15, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 93, -1, -1));

        imgPlayer2Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back16, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 93, -1, -1));

        imgPlayer2Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back17, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 93, -1, -1));

        imgPlayer2Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back18, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 93, -1, -1));

        imgPlayer2Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back19, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 93, -1, -1));

        imgPlayer2Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back20, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 93, -1, -1));

        imgPlayer2Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 33, -1, -1));

        imgPlayer2Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer2FaceDownCards.add(imgPlayer2Back11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 93, -1, -1));

        lblPlayer1FaceDownCards1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCards1.setText("Player 2 Cards: ");
        pnlPlayer2FaceDownCards.add(lblPlayer1FaceDownCards1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        lblPlayer2FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer2FaceDownCardsCount.setText("0");
        pnlPlayer2FaceDownCards.add(lblPlayer2FaceDownCardsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 61, -1));

        pnlPlayer3FaceDownCards.setBackground(new java.awt.Color(255, 153, 0));
        pnlPlayer3FaceDownCards.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPlayer3FaceDownCards.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgPlayer3Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 33, -1, -1));

        imgPlayer3Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 33, -1, -1));

        imgPlayer3Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 33, -1, -1));

        imgPlayer3Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 33, -1, -1));

        imgPlayer3Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 33, -1, -1));

        imgPlayer3Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 33, -1, -1));

        imgPlayer3Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 33, -1, -1));

        imgPlayer3Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 33, -1, -1));

        imgPlayer3Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 33, -1, -1));

        imgPlayer3Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back12, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 93, -1, -1));

        imgPlayer3Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back13, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 93, -1, -1));

        imgPlayer3Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back14, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 93, -1, -1));

        imgPlayer3Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back15, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 93, -1, -1));

        imgPlayer3Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back16, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 93, -1, -1));

        imgPlayer3Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back17, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 93, -1, -1));

        imgPlayer3Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back18, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 93, -1, -1));

        imgPlayer3Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back19, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 93, -1, -1));

        imgPlayer3Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back20, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 93, -1, -1));

        imgPlayer3Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 33, -1, -1));

        imgPlayer3Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer3FaceDownCards.add(imgPlayer3Back11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 93, -1, -1));

        lblPlayer1FaceDownCards2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCards2.setText("Player 3 Cards: ");
        pnlPlayer3FaceDownCards.add(lblPlayer1FaceDownCards2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        lblPlayer3FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer3FaceDownCardsCount.setText("0");
        pnlPlayer3FaceDownCards.add(lblPlayer3FaceDownCardsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 61, -1));

        pnlPlayer4FaceDownCards.setBackground(new java.awt.Color(102, 102, 255));
        pnlPlayer4FaceDownCards.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPlayer4FaceDownCards.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgPlayer4Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 33, -1, -1));

        imgPlayer4Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 33, -1, -1));

        imgPlayer4Back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 33, -1, -1));

        imgPlayer4Back5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 33, -1, -1));

        imgPlayer4Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 33, -1, -1));

        imgPlayer4Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 33, -1, -1));

        imgPlayer4Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 33, -1, -1));

        imgPlayer4Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 33, -1, -1));

        imgPlayer4Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 33, -1, -1));

        imgPlayer4Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back12, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 93, -1, -1));

        imgPlayer4Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back13, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 93, -1, -1));

        imgPlayer4Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back14, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 93, -1, -1));

        imgPlayer4Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back15, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 93, -1, -1));

        imgPlayer4Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back16, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 93, -1, -1));

        imgPlayer4Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back17, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 93, -1, -1));

        imgPlayer4Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back18, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 93, -1, -1));

        imgPlayer4Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back19, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 93, -1, -1));

        imgPlayer4Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back20, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 93, -1, -1));

        imgPlayer4Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 33, -1, -1));

        imgPlayer4Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno_face_down_cards.png"))); // NOI18N
        pnlPlayer4FaceDownCards.add(imgPlayer4Back11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 93, -1, -1));

        lblPlayer1FaceDownCards3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer1FaceDownCards3.setText("Player 4 Cards: ");
        pnlPlayer4FaceDownCards.add(lblPlayer1FaceDownCards3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        lblPlayer4FaceDownCardsCount.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblPlayer4FaceDownCardsCount.setText("0");
        pnlPlayer4FaceDownCards.add(lblPlayer4FaceDownCardsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 61, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("U");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("N");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 255));
        jLabel9.setText("O");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 153));
        jLabel10.setText("Cards Left:");

        javax.swing.GroupLayout pnlLiveGameLayout = new javax.swing.GroupLayout(pnlLiveGame);
        pnlLiveGame.setLayout(pnlLiveGameLayout);
        pnlLiveGameLayout.setHorizontalGroup(
            pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblondeck, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNextPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCurrentPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCurrentColor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel3))
                            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1))))
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlPlayer1FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlPlayer2FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlPlayer3FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlPlayer4FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(227, 227, 227))
        );
        pnlLiveGameLayout.setVerticalGroup(
            pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLiveGameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLiveGameLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCurrentColor)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLiveGameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlPlayer1FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlPlayer2FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlPlayer3FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlPlayer4FaceDownCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))))
                    .addGroup(pnlLiveGameLayout.createSequentialGroup()
                        .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurrentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLiveGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNextPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblondeck, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLiveGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLiveGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        HelpWin helpwin = new HelpWin();
        helpwin.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

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
        playCard(1);
        int mainPileSize = deck.getMainPile().size();
        System.out.println("The main pile now has " + mainPileSize);
        //game.moveToNextPlayer();
    }//GEN-LAST:event_btnCardSlot1ActionPerformed

    private void btnCardSlot2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot2ActionPerformed
        // TODO add your handling code here:
        playCard(2);
    }//GEN-LAST:event_btnCardSlot2ActionPerformed

    private void btnCardSlot3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot3ActionPerformed
        // TODO add your handling code here:
        playCard(3);
    }//GEN-LAST:event_btnCardSlot3ActionPerformed

    private void btnCardSlot4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot4ActionPerformed
        // TODO add your handling code here:
       playCard(4);
    }//GEN-LAST:event_btnCardSlot4ActionPerformed

    private void btnCardSlot5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot5ActionPerformed
        // TODO add your handling code here:
        playCard(5);
    }//GEN-LAST:event_btnCardSlot5ActionPerformed

    private void btnCardSlot6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot6ActionPerformed
        // TODO add your handling code here:
        playCard(6);
    }//GEN-LAST:event_btnCardSlot6ActionPerformed

    private void btnCardSlot7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot7ActionPerformed
        // TODO add your handling code here:
        playCard(7);
    }//GEN-LAST:event_btnCardSlot7ActionPerformed

    private void btnCardSlot8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot8ActionPerformed
        // TODO add your handling code here:
        playCard(8);
    }//GEN-LAST:event_btnCardSlot8ActionPerformed

    private void btnCardSlot9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot9ActionPerformed
        // TODO add your handling code here:
        playCard(9);
    }//GEN-LAST:event_btnCardSlot9ActionPerformed

    private void btnCardSlot10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot10ActionPerformed
        // TODO add your handling code here:
        playCard(10);
    }//GEN-LAST:event_btnCardSlot10ActionPerformed

    private void btnCardSlot11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot11ActionPerformed
        // TODO add your handling code here:
        playCard(11);
    }//GEN-LAST:event_btnCardSlot11ActionPerformed

    private void btnCardSlot12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot12ActionPerformed
        // TODO add your handling code here:
        playCard(12);
    }//GEN-LAST:event_btnCardSlot12ActionPerformed

    private void btnCardSlot13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot13ActionPerformed
        // TODO add your handling code here:
        playCard(13);
    }//GEN-LAST:event_btnCardSlot13ActionPerformed

    private void btnCardSlot14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot14ActionPerformed
        // TODO add your handling code here:
        playCard(14);
    }//GEN-LAST:event_btnCardSlot14ActionPerformed

    private void btnCardSlot15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardSlot15ActionPerformed
        // TODO add your handling code here:
        playCard(15);
    }//GEN-LAST:event_btnCardSlot15ActionPerformed

    
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
    private javax.swing.JLabel ImageHolder;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurrent;
    private javax.swing.JLabel lblCurrentColor;
    private javax.swing.JLabel lblCurrentPlayer;
    private javax.swing.JLabel lblNextPlayer;
    private javax.swing.JLabel lblPlayer1FaceDownCards;
    private javax.swing.JLabel lblPlayer1FaceDownCards1;
    private javax.swing.JLabel lblPlayer1FaceDownCards2;
    private javax.swing.JLabel lblPlayer1FaceDownCards3;
    private javax.swing.JLabel lblPlayer1FaceDownCardsCount;
    private javax.swing.JLabel lblPlayer2FaceDownCardsCount;
    private javax.swing.JLabel lblPlayer3FaceDownCardsCount;
    private javax.swing.JLabel lblPlayer4FaceDownCardsCount;
    private javax.swing.JLabel lblondeck;
    private javax.swing.JPanel pnlLiveGame;
    private javax.swing.JPanel pnlPlayer1FaceDownCards;
    private javax.swing.JPanel pnlPlayer2FaceDownCards;
    private javax.swing.JPanel pnlPlayer3FaceDownCards;
    private javax.swing.JPanel pnlPlayer4FaceDownCards;
    // End of variables declaration//GEN-END:variables
}
