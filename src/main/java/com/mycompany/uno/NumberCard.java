/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author chief
 */
public class NumberCard extends Card {
    private String number;

    public NumberCard(String color, String number) {
        super(color);
        this.color = color;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return getColor() + " " + getNumber();
    }
    
    public boolean canPlayCard(Card currentCard) {
        
        if (currentCard.isWildcard()) {
            // TODO: this is necessary until the wildcard feature is working
            return true;
        }
        
        if (currentCard.getColor() == this.color) {
            return true;
        }
        
        if (currentCard instanceof NumberCard) {
            NumberCard numberCard = (NumberCard) currentCard;
            
            if (numberCard.getNumber() == this.number) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isReverse() {
        return false;
    }
    
    public boolean isSkip() {
        return false;
    }
    
    public boolean isWildcard() {
        return false;
    }
    
    public boolean isAddCard() {
        return false;
    }
    
    public int addCardsCount() {
        return 0;
    }
    
    public void declareColor(String color) {
        // null operation
    }
    
    public String getImageName(){
        return this.color + "_" + this.number + ".png";
    }
}
