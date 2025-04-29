/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executors;

/**
 *
 * @author micha
 */
public class GameAPI {

    private GameRegistry gameRegistry;
    
    public GameAPI(GameRegistry gameRegistry) {
        this.gameRegistry = gameRegistry;
    }
    
    public void startServer() {
        //
        // Start an API in a background thread
        //
        try {
            // Define the server address and port
            InetSocketAddress address = new InetSocketAddress(8000);

            // Create an HttpServer instance
            HttpServer server = HttpServer.create(address, 0);

            // Create a context and handler for incoming requests
            server.createContext("/games/total", new GameCountHandler(gameRegistry));
            server.createContext("/games/list", new GameListHandler(gameRegistry));
            server.createContext("/games/stats", new GameStatsHandler(gameRegistry));

            // Set an executor to handle requests in separate threads
            server.setExecutor(Executors.newFixedThreadPool(10));

            // Start the server in a new thread
            new Thread(() -> {
                server.start();
                System.out.println("Server started on port 8000");
            }).start();
        
        } catch(IOException ioException) {
            System.err.println("IO Exception detected: " + ioException.toString());
            System.exit(-1);
        }
    }
    
    private class GameListHandler implements HttpHandler {
        
        private GameRegistry gameRegistry;
        
        public GameListHandler(GameRegistry gameRegistry) {
            this.gameRegistry = gameRegistry;
        }
        
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            
            String jsonResponse = "[";
            
            List<Game> gameList = gameRegistry.getGames();
            
            int gameCount = 1;
            
            for (Game game : gameList) {
                String gameJSON = "{";
                gameJSON += "\"id\": ";
                gameJSON += gameCount + ",";
                gameJSON += "\"players\": ";
                gameJSON += game.getNumberOfPlayers() + ",";
                gameJSON += "\"turns\": ";
//                gameJSON += game.getTurns() + ",";               
                gameJSON += "}";
                
                gameCount++;
            }
            
            jsonResponse += "]";

            // Set the response headers
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            // Send the response
            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(jsonResponse.getBytes());
            outputStream.close();

        }
    }
    
    private class GameCountHandler implements HttpHandler {
        
        private GameRegistry gameRegistry;
        
        public GameCountHandler(GameRegistry gameRegistry) {
            this.gameRegistry = gameRegistry;
        }
        
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            
            int totalGames = gameRegistry.totalGames();
            
            String jsonResponse = "{ \"total_games\": \"";
            jsonResponse += totalGames;
            jsonResponse += "\" }";

            // Set the response headers
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            // Send the response
            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(jsonResponse.getBytes());
            outputStream.close();

        }
    }
        
    private class GameStatsHandler implements HttpHandler {
        
        private GameRegistry gameRegistry;
        
        public GameStatsHandler(GameRegistry gameRegistry) {
            this.gameRegistry = gameRegistry;
        }
        
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            
            gameRegistry.calculateTotals();
            int totalGames = gameRegistry.totalGames();
            int totalTurns = gameRegistry.getTotalTurns();
            int lowestTurns = gameRegistry.getLowestTurns();
            int highestTurns = gameRegistry.getHighestTurns();
            int forfeits = gameRegistry.getTotalForfeits();
            
            // TODO: Add logic to process totals
            //
            String jsonResponse = "{";
            jsonResponse += "\"total_games\": ";
            jsonResponse += totalGames + ",";

            jsonResponse += "\"total_turns\": ";
            jsonResponse += totalTurns + ",";

            jsonResponse += "\"lowest_moves\": ";
            jsonResponse += lowestTurns + ",";
            
            jsonResponse += "\"highest_moves\": ";
            jsonResponse += highestTurns + ",";
            
            jsonResponse += "\"forfeits\": ";
            jsonResponse += forfeits; 

            jsonResponse += "}";

            // Set the response headers
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            // Send the response
            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(jsonResponse.getBytes());
            outputStream.close();

        }
    }
    
}
