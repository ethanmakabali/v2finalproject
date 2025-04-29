/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author chief
 */
public class WildDraw4Card extends Card {
    private String effect;
    
    public WildDraw4Card(){
        super("wild");
        this.effect = "Wild Draw 4";
    }
    
    @Override
    public String toString() {
        return color + " " + effect;
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
        return true;
    }
    
    @Override
    public boolean isWildcard(){
        return true;
    }

    @Override
    public boolean isAddCard(){
        return true;
    }
    
    @Override
    public int addCardsCount(){
        return 4;
    }
    
    @Override
    public void declareColor(String color){
        this.color = color;
    }
    
    public String getImageName(){
        return "wild_card_draw_4.png";
    }
}
