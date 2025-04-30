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
    private String playerName;
    private Player previousPlayer;
    private Player nextPlayer;
    private Deck deck;
    private int numberOfPlayers;
    private int playerNumber;
    private boolean currentPlayer;
    
    public Player(String playerName, int playerNumber, int numberOfPlayers, Deck deck){
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.numberOfPlayers = numberOfPlayers;
        this.cards = new ArrayList<Card>();
        this.deck = deck;
        this.generateRandomDecks();
    }
   
    // Getters
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
    
    public int getPlayerNumber() {
        return this.playerNumber;
    }
    
    public int getPlayerIndex() {
        return this.playerNumber - 1;
    }
    
    
    // Action methods
    public void generateRandomDecks(){
        for(int i = 0; i < 7; i++){
            Card card = this.deck.getNextMainPileCard();
            this.cards.add(card);
        }
    }
    
    public void removeCard(Card removeCard) {
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i) == removeCard) {
                this.cards.remove(i);
            }
        }
    }
    
    public void addNewCards(int totalCards) {
        // This adds additional cards to the deck
        // Draw two, draw four, etc...
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
