/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author chief
 */
public class Game {
    private int numberOfPlayers;
    // Arrays
    private ArrayList<String> playerNames;
    private ArrayList<Player> players;
    private ArrayList<Card> mainPile;
    // Player tracking
    private Player currentPlayer;
    private Player previousPlayer;
    private Player nextPlayer;
    private Player winner;
    private Deck deck;
    // Game Logic
    private int nextIndex;
    private boolean clockWise;
    private int turn;
    private boolean forfeit;
    
    
    public Game(ArrayList<String> playerNames, Deck deck){
        this.deck = deck;
        this.players = new ArrayList<>();
        this.numberOfPlayers = playerNames.size();
        this.playerNames = playerNames;
        assignPlayers();
        this.currentPlayer = players.get(0);
        this.nextIndex = 1;
        this.nextPlayer = players.get(nextIndex);
        this.previousPlayer = null;
        this.clockWise = true;
        this.winner = null;
    }
    
    public void assignPlayers(){
        for(int i = 0; i < this.numberOfPlayers; i++){
            String name = playerNames.get(i);
            Player player = new Player(name, i+1, numberOfPlayers, deck);
            players.add(player);
        }
    }
    
    public int getPlayerDeckSize(int playerNum) {
        return players.get(playerNum).getCurrentPlayerDeckSize();
    }
    
    public ArrayList<Card> getPlayerDeck(int playerNum){
        return players.get(playerNum).getCurrentPlayerDeck();
    }
    
    public ArrayList<Card> getCurrentPlayerDeck(){
        return this.currentPlayer.getCurrentPlayerDeck();
    }
    
    public boolean playCard(Card card, String declaredColor) {
        if (!this.deck.getDiscardPile().isEmpty()) {
            if (!card.canPlayCard(this.deck.getDiscardCard())) {
                return false;
            }
        }

        if (card.isReverse()) {
            this.clockWise = !this.clockWise;
        }

        if (card.isWildcard()) {
            card.declareColor(declaredColor);
        }

        this.currentPlayer.removeCard(card);
        this.deck.placeDiscardCard(card);

        if (card.isAddCard()) {
            moveToNextPlayer();
            this.currentPlayer.addNewCards(card.addCardsCount());
            moveToNextPlayer();
        } else if (card.isSkip()) {
            moveToNextPlayer();
            moveToNextPlayer();
        } else {
            moveToNextPlayer();
        }

        return true;
    }

    
    public boolean isThereWinner() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (getPlayerDeck(i).isEmpty()) { 
                winner = getThisPlayer(i);
                return true;
            }
        }
        return false;
    }
    

    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    
    public Player getWinner(){
        return this.winner;
    }
    
    public Player getThisPlayer(int i){
        return players.get(i);
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public Player getNextPlayer(){
        return this.nextPlayer;
    }
    
    public Player getPreviousPlayer(){
        return this.previousPlayer;
    }
    
    public void setClockWise(boolean yesOrNo){
        this.clockWise = yesOrNo;
    }
    
    public void moveToNextPlayer(){
        this.previousPlayer = currentPlayer;
        if(clockWise == true){
            this.currentPlayer = nextPlayer;
            if(nextIndex + 1 == players.size()){
                this.nextIndex = 0;
                this.nextPlayer = players.get(nextIndex);
            }
            else{
                this.nextIndex += 1;
                this.nextPlayer = players.get(nextIndex);
            }
        } else {
            if (nextIndex - 1 < 0) {
                nextIndex = players.size() - 1;
            } else {
                nextIndex -= 1;
            }
            currentPlayer = players.get(nextIndex);
            nextPlayer = players.get((nextIndex - 1 + players.size()) % players.size());
        }
//        System.out.println("previous player: "  + previousPlayer);
//        System.out.println("current player: " + currentPlayer);
//        System.out.println("next player: " + nextPlayer);
//        System.out.println("-----------------------------");
    }
    
    
    public void setNumberOfPlayers(int numPlayers){
        this.numberOfPlayers = numPlayers;
    }
    
    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }
    
    public int getTurns() {
        return this.turn;
    }
    
    public boolean isForfeit() {
        return this.forfeit;
    }
}

    