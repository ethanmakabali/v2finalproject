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
    private ArrayList<Integer> turns;
    private int numberOfPlayers;
    private int turn;
    
    private ArrayList<String> playerNames;
    private ArrayList<Player> players;
    private ArrayList<Card> mainPile;
    
    private Player currentPlayer;
    private Player previousPlayer;
    private Player nextPlayer;
    private int nextIndex;
    private boolean clockWise;
    private Player winner;
    
    private Deck deck;
    
    public Game(ArrayList<String> playerNames, Deck deck){
        this.deck = deck;
        this.turns = new ArrayList<>();
        this.players = new ArrayList<>();
        this.numberOfPlayers = playerNames.size();
        this.playerNames = playerNames;
        System.out.println("number of players: " + numberOfPlayers);
        for(int i = 0; i < this.numberOfPlayers; i++){
//            System.out.println("in the loop");
            String name = playerNames.get(i);
//            System.out.println(name + ':');
            Player player = new Player(name, i+1, numberOfPlayers, deck);
            players.add(player);
//            System.out.println(numberOfPlayers);
        }
        System.out.println("players: " + playerNames);
        this.currentPlayer = players.get(0);
        this.nextIndex = 1;
        this.nextPlayer = players.get(nextIndex);
        this.previousPlayer = null;
        this.clockWise = true;
        this.winner = null;
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
    
    public boolean playCard(Player player, Card card, String declaredColor) {
        if (this.currentPlayer != player) {
            // Reset the game to this player
            System.err.println("The current player doesn't match incoming player");
            this.currentPlayer = player;
        }
        
        if (!this.deck.getDiscardPile().isEmpty()) {
            // if not empty, check the card against the discard pile
            // otherwise, automatically play
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
        
        // this moves the card to the discount pile
        this.currentPlayer.removeCard(card);
        this.deck.placeDiscardCard(card);
        
        // Find the next player to play
        if (this.clockWise == true) {
            // add to the next index
            int nextPlayerIndex = this.currentPlayer.getPlayerIndex() + 1;
            
            nextPlayerIndex = nextPlayerIndex % this.numberOfPlayers;
 
            if (card.isAddCard()) {
                // we have to add a card to the next player even if there is a skip
                Player nextPlayer = this.players.get(nextPlayerIndex);
                nextPlayer.addNewCards(card.addCardsCount());
            }
            
            if (card.isSkip()) {
                nextPlayerIndex++;
            }
            
            // if we exceed the total players, go back to 0 to get the next player
            nextPlayerIndex = nextPlayerIndex % this.numberOfPlayers;

            this.currentPlayer = this.players.get(nextPlayerIndex);
        } else {
            // subtract from the next index
            int prevPlayerIndex = this.currentPlayer.getPlayerIndex() - 1;
            
            if (prevPlayerIndex < 0) {
               // this means that the current player is 0
               prevPlayerIndex = this.numberOfPlayers - 1;
            }
            
            if (card.isAddCard()) {
                // we have to add a card to the next player even if there is a skip
                Player prevPlayer = this.players.get(prevPlayerIndex);
                prevPlayer.addNewCards(card.addCardsCount());
            }
                                
            if (card.isSkip()) {
                if (prevPlayerIndex == 0) {
                    prevPlayerIndex = this.numberOfPlayers - 1;
                } else {
                    prevPlayerIndex = prevPlayerIndex - 1;
                }
            }
            
            this.currentPlayer = this.players.get(prevPlayerIndex);
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
//        String[] players2 = {"a","b","c","d"};
        //Debug
//        this.clockWise = false;
        //its always gonna be the previous one
        this.previousPlayer = currentPlayer;
        if(clockWise == true){
            this.currentPlayer = nextPlayer;
            // If the next index does exist, go back to the first person
            if(nextIndex + 1 == players.size()){
                this.nextIndex = 0;
                this.nextPlayer = players.get(nextIndex);
            }
            else{
                this.nextIndex += 1;
                this.nextPlayer = players.get(nextIndex);
            }
        }else{
            // Code here;
            // debug
            //still needs completion
            System.out.println(nextIndex - 1);
//            this.currentPlayer = previousPlayer;
            if(nextIndex - 2 < 0){
                // get the last index
                // NOT -1 (NOT PYTHON)
                this.nextIndex = players.size() - 1;
                // current player is now the last element
                this.currentPlayer = players.get(nextIndex);
                // the next player is now 
                this.nextPlayer = players.get(players.size() - 2);
            }
            else{
                // So confusing
                this.nextIndex -= 1;
                this.currentPlayer = players.get(nextIndex);
                this.nextPlayer = players.get(nextIndex - 1);
            }
        }
        System.out.println("previous player: "  + previousPlayer);
        System.out.println("current player: " + currentPlayer);
        System.out.println("next player: " + nextPlayer);
        System.out.println("-----------------------------");
    }
    
    
    
    
    public void setNumberOfPlayers(int numPlayers){
        this.numberOfPlayers = numPlayers;
    }
    
    
    
    private void nextPlayersTurn(){
        for(int i = 1; i < turns.size()+1; i++){
            // If the the player in the arraylist is about of bounce, go back to the first player
            if(turn == turns.get(i) && turns.get(i+1) == null){
                turn = 1;
            }
            if(turn == turns.get(i)){
                turn = turn + 1;
            }
        }
    }
    
    private void setTurns(){
        //Example: {1,2,3,4}
        for(int i=1; i < numberOfPlayers+1; i++){
            this.turns.add(i);
        }
    }
}
