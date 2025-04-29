/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public class GameRegistry {
    
    private List<Game> games;
    private int totalTurns;
    private int lowestTurns;
    private int highestTurns;
    private int forfeits;
    
    public GameRegistry() {
        this.games = new ArrayList<>();
        this.totalTurns = 0;
        this.lowestTurns = 999;
        this.highestTurns = 0;
        this.forfeits = 0;
    }
    
    public List<Game> getGames() {
        return games;
    }
    
    public void addGame(Game game) {
        games.add(game);
    }
    
    public int totalGames() {
        return games.size();
    }
    
    public void calculateTotals() {
        this.totalTurns = 0;
        this.lowestTurns = 999;
        this.highestTurns = 0;
        this.forfeits = 0;
        
        for (Game game: games) {
            int turns = game.getTurns();
            this.totalTurns += turns;
            
            if (turns < this.lowestTurns) {
                this.lowestTurns = turns;
            }
            
            if (turns > this.highestTurns) {
                this.highestTurns = turns;
            }
            
            if (game.isForfeit()) {
                this.forfeits ++;
            }
        }
    }
    
    public int getTotalTurns() {
        return this.totalTurns;
    }
    
    public int getLowestTurns() {
        
        if (this.totalGames() == 0) {
            return 0;
        }
        
        return this.lowestTurns;
    }
    
    public int getHighestTurns() {
        return this.highestTurns;
    }
    
    public int getTotalForfeits() {
        return this.forfeits;
    }
            
}
