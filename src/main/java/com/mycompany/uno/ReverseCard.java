/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author chief
 */
public class ReverseCard extends Card{
    private String effect;
    
    public ReverseCard(String color, String effect){
        super(color);
        this.effect = "reverse";
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
        return true;
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
        return 0;
    }
    
    @Override
    public void declareColor(String color){
        return;
    }
    
    public String getImageName(){
        return this.color + "_reverse.png";
    }
}
