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
}
