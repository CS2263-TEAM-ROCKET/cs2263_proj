package edu.isu.cs2263.proj.data;

import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Facade {

    //Variables
    @Getter @Setter private GameManager gameManager;

    @Getter @Setter private Application application = new Application();

    @Getter @Setter private Player currentPlayer;

    @Getter @Setter private GameBoard board;

    //Methods
    //Methods for new game
    public List<Tile> setupGame(int players, boolean visible) {
        gameManager = application.startGame(players, visible);
        board = gameManager.getBoard();
        return board.currentBoard();
    }

    public int chooseFirstPlayer() {
        return gameManager.firstPlayer();
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

    public boolean load(File file) throws FileNotFoundException {
        return application.loadGame(file);
    }
}
