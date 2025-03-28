/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author chief
 */
public class WildCard extends Card {
    private String effect; // "Wild" or "Wild Draw Four"

    public WildCard() {
        super("Wild");
        this.effect = "Wild";
    }

    public String getEffect() {
        return effect;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return effect;
    }
    
    @Override
    public boolean canPlayCard(Card currentCard){
        return true;
    }
    
    @Override
    public boolean isReverse(){
        return false;
    }
    
    @Override
    public boolean isSkip(){
        return false;
    }
    
    @Override
    public boolean isWildcard(){
        return true;
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
        this.color = color;
    }
    
    public String getImageName(){
        return "wild_card.png";
    }
}
