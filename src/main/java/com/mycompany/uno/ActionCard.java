/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.uno;

/**
 *
 * @author chief
 */
public class ActionCard extends Card {
    private String actionType; // "Skip", "Reverse", "Draw Two"

    public ActionCard(String color, String actionType) {
        super(color);
        this.actionType = actionType;
    }

    public String getActionType() {
        return actionType;
    }

    @Override
    public String toString() {
        return color + " " + actionType;
    }
}
