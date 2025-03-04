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
    private ArrayList<Card> mainPile;
    
    
    public Player(String playerName, int playerNumber, int numberOfPlayers, ArrayList<Card> mainPile){
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.numberOfPlayers = numberOfPlayers;
        this.cards = new ArrayList<Card>();
        this.mainPile = mainPile;
        generateRandomDecks();
        //debug
        System.out.println("Player " + this.playerNumber + "(" + this.playerName + ")" +  ": " + this.cards);
        System.out.println("Number of cards in main pile: " + mainPile.size());
//        System.out.println(this.playerNumber);
//        System.out.println(this.cards);
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
            Card card = mainPile.get(i);
            mainPile.remove(i);
            this.cards.add(card);
        }
    }
    
    @Override
    public String toString(){
        return this.playerName;
    }
}
