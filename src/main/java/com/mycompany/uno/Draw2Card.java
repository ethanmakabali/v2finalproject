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
public class Draw2Card extends Card {
    private String effect;
    
    public Draw2Card(String color, String effect){
        super(color); 
        this.effect = "draw 2";
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
        
    }
    
    public String getImageName(){
        return this.color + "_draw2.png";
    }
}
