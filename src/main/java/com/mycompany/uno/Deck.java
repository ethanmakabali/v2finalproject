/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author chief
 */
public class Deck {
     private ArrayList<Card> discardPile;
     private ArrayList<Card> mainPile;
    
    public Deck(){
        this.mainPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        createMainPile();
        shuffleDeck();
    }   
    
    // Getters
    public ArrayList<Card> getMainPile(){
        return this.mainPile;
    }
    
    public ArrayList<Card> getDiscardPile(){
        return this.discardPile;
    }
    
    public Card getDiscardCard() {
        if (this.discardPile.isEmpty()){
            this.discardPile.add(this.mainPile.get(0));
            mainPile.remove(0);
        }
        return this.discardPile.get(this.discardPile.size() - 1);
    }
    
    public Card getNextMainPileCard() {
        Card card = mainPile.get(0);
        mainPile.remove(0);
        return card;
    }
    
    // Action methods
    private void createMainPile(){
        //108 cards, in a tradiontal Uno deck;
        String[] colors = {"Red","Green","Blue","Yellow"};
        String[] values = {"1", "2", "3", "4","5", "6", "7", "8","9"};
        String[] actions = {"Skip","Reverse","Draw Two"};
        // there are only one 0 card for each color
        for(String color : colors){
            mainPile.add(new NumberCard(color, "0"));
        }
        // Add each number w/color card twice to the deck
        for (String color : colors){
            for(String value : values){
                mainPile.add(new NumberCard(color, value));
                mainPile.add(new NumberCard(color, value));
            }
        }
        // Add each action card twice to the deck
        for(String color : colors){
            mainPile.add(new SkipCard(color, actions[0]));
            mainPile.add(new SkipCard(color, actions[0]));
            mainPile.add(new ReverseCard(color, actions[1]));
            mainPile.add(new ReverseCard(color, actions[1]));
            mainPile.add(new Draw2Card(color, actions[2]));
            mainPile.add(new Draw2Card(color, actions[2]));
        }
        // Add 4 Wild Cards and 4 Wild Card Add four cards
        for (int i = 0; i < 4; i++) {
            mainPile.add(new WildCard());
            mainPile.add(new WildDraw4Card());
        }
    }
    
    private void shuffleDeck(){
        Collections.shuffle(mainPile);
    }
    
    public void placeDiscardCard(Card card) {
        this.discardPile.add(card);
    }
}

