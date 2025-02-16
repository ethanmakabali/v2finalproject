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

    public WildCard(String effect) {
        super("Wild"); // Wild cards have no fixed color initially
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public void setColor(String color) { // Allows changing the color when played
        this.color = color;
    }

    @Override
    public String toString() {
        return effect;
    }
}
