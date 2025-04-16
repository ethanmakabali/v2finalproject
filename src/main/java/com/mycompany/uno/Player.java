/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

import java.util.ArrayList;

/**
 *
 * @author chief
 */
public class Player {
    private ArrayList<Card> cards;
    private int playerNumber;
    private String playerName;
    private boolean currentPlayer;
    private Player previousPlayer;
    private Player nextPlayer;
    private int numberOfPlayers;
    private Deck deck;
    
    public Player(String playerName, int playerNumber, int numberOfPlayers, Deck deck){
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.numberOfPlayers = numberOfPlayers;
        this.cards = new ArrayList<Card>();
        this.deck = deck;
        this.generateRandomDecks();
        //debug
        System.out.println("Player " + this.playerNumber + "(" + this.playerName + ")" +  ": " + this.cards);
        System.out.println("Number of cards in main pile: " + deck.getMainPile().size());
//        System.out.println(this.playerNumber);
//        System.out.println(this.cards);
    }
   
    
    public String getName() {
        return this.playerName; // Assuming you have a 'name' field
    }

    
    public int getCurrentPlayerDeckSize(){
        int size = this.cards.size();
        return size;
    }
    
    public ArrayList<Card> getCurrentPlayerDeck(){
        return this.cards;
    }
    
    public void generateRandomDecks(){
        // Simulate the drawing pattern, alternates
        
        for(int i = 0; i < 7; i++){
            Card card = this.deck.getNextMainPileCard();
            this.cards.add(card);
        }
    }
    
    public int getPlayerNumber() {
        return this.playerNumber;
    }
    
    public int getPlayerIndex() {
        return this.playerNumber - 1;
    }
    
    public void removeCard(Card removeCard) {
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i) == removeCard) {
                // removing the card
                this.cards.remove(i);
            }
        }
    }
    
    public void addNewCards(int totalCards) {
        //
        // This adds additional cards to the deck
        //
        for(int i = 0; i < totalCards; i++){
            Card card = this.deck.getNextMainPileCard();
            this.cards.add(card);
        }
    }
    
    @Override
    public String toString(){
        return this.playerName;
    }
}
