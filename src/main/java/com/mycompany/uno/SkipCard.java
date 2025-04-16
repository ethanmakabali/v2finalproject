/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author chief
 */
public class SkipCard extends Card{
    private String effect;
    
    
    public SkipCard(String color, String effect){
        super(color);
        this.effect = effect;
    }
    
    @Override
    public String toString() {
        return color + " " + effect;
    }
    
    @Override
    public boolean canPlayCard(Card currentCard) {
        if (currentCard.isWildcard()) {
            return this.color.equalsIgnoreCase(currentCard.getColor());
        }

        if (currentCard.getColor().equalsIgnoreCase(this.color)) {
            return true;
        }

        if (currentCard instanceof SkipCard) {
            return true;
        }

        return false;
    }

    
    @Override
    public boolean isReverse(){
        return false;
    }
    
    @Override
    public boolean isSkip(){
        return true;
    }
    
    @Override
    public boolean isWildcard(){
        return false;
    }

    @Override
    public boolean isAddCard(){
        return false;
    }
    
    @Override
    public int addCardsCount(){
        return 0;
    }
    
    @Override
    public void declareColor(String color){
        // nothing
    }
    
    public String getImageName(){
        return this.color + "_skip.png";
    }
}
