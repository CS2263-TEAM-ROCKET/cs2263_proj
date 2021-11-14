package edu.isu.cs2263.proj.data;

import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
public class Facade {

    //Variables
    @Getter @Setter private GameManager gameManager;

    @Getter @Setter private Application application = new Application();

    @Getter @Setter private Player currentPlayer;

    //Methods
    //Methods for new game
    public List<Tile> setupGame(int players, boolean visible) {
        int numberOfPlayers = application.startGame(players, visible);
        gameManager.initialize(numberOfPlayers);
        GameBoard board = gameManager.getBoard();
        return board.currentBoard();
    }

    //Methods for players
    public int chooseFirstPlayer() {
        return gameManager.firstPlayer();
    }

    public int CurrentPlayer() {
        return gameManager.currentPlayerId();
    }

    //Methods for playing a tile
    public void playTile(Tile tile) {
        gameManager.playTile(tile);
    }

    //Methods for buying a stock
    public void buyStock(Corporation corporation, int playerId) {
        Player buyer = gameManager.idToPlayer(playerId);
        buyer.buyStock(corporation);
    }

    //Methods for drawing new tiles
    public void drawTile(Player player) {
        player.addTile(gameManager.drawTile());
    }

    public boolean discardTile(Tile tile) {
        boolean tileDiscarded = false;
        Player player = gameManager.currentPlayer();
        if(player.discardTiles(tile)) {
            gameManager.returnTile(tile);
            tileDiscarded = true;
        }
        return tileDiscarded;
    }

    public Tile tradeTile(Tile tile) {
        Tile tradedTile = tile;
        if(this.discardTile(tile)) {
            tradedTile = gameManager.drawTile();
        }
        return tradedTile;
    }

    public int nextTurn() {
        currentPlayer = gameManager.nextTurn();

        application.updateState(gameManager, gameManager.getBoard(), gameManager.getPlayers());
        return currentPlayer.getPlayerId();
    }

    //Methods for ending the game
    public boolean checkGameEnd() {
        return gameManager.checkGameEnd();
    }

    public List<String> end() {
        return gameManager.calculateScores();
    }

    // Methods for save/load state
    public boolean save(File filePath, String fileName) {
        return application.saveGame(filePath, fileName);
    }

    public void load(File file) throws FileNotFoundException {
        application.loadGame(file);
        this.getState();
    }

    public void getState() {
        gameManager = application.getManagerState();
        gameManager.setBoard(application.getBoard());
        gameManager.setPlayers(application.getPlayers());
        currentPlayer = gameManager.currentPlayer();
    }
}
