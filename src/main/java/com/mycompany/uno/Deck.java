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
        System.out.println("number of cards in main pile: " + mainPile.size());
        System.out.println(mainPile);
    }   
    
    private void createMainPile(){
        //108 cards, in a tradiontal Uno deck;
        String[] colors = {"Red","Green","Blue","Yellow"};
        String[] values = {"1", "2", "3", "4","5", "6", "7", "8","9"};
        String[] actions = {"Skip","Reverse","Draw Two"};
        String[] wildCards = {"Wild Card","Wild Card Draw 4"};
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
            for(String action : actions){
                mainPile.add(new ActionCard(color, action));
                mainPile.add(new ActionCard(color, action));
            }
        }
        // Add 4 Wild Cards and 4 Wild Card Add four cards
        for(String wc : wildCards){
            mainPile.add(new WildCard(wc));
            mainPile.add(new WildCard(wc));
            mainPile.add(new WildCard(wc));
            mainPile.add(new WildCard(wc));
        }
    }
    
    private void shuffleDeck(){
        Collections.shuffle(mainPile);
    }
    
    public ArrayList<Card> getMainPile(){
        return this.mainPile;
    }
}

