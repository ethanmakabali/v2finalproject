/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

import java.awt.Image;

/**
 *
 * @author chief
 */
public abstract class Card {
    protected String color;
//    protected Image image; 
    
    public Card(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public abstract String toString();
    
    public abstract boolean canPlayCard(Card currentCard);
    
    public abstract boolean isReverse();
    public abstract boolean isSkip();
    public abstract boolean isWildcard();
    public abstract boolean isAddCard();
    public abstract int addCardsCount();
    public abstract void declareColor(String color);
    
    public abstract String getImageName();
    
//    public abstract int totalCards();
    
}
