/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author chief
 */
public abstract class Card {
    protected String color;
    
    public Card(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public abstract String toString();
}
