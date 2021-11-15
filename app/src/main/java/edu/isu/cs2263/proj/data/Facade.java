package edu.isu.cs2263.proj.data;

import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * This is an in-between for the UI and the rest of the game
 */
@NoArgsConstructor @AllArgsConstructor
public class Facade {

    //Variables
    @Getter @Setter private GameManager gameManager;

    @Getter @Setter private Application application = new Application();

    @Getter @Setter private Player currentPlayer;

    //Methods
    //Methods for new game

    /**
     * This sets up the initial game using some settings given
     * @param players is the number of players. Defaults to 2.
     * @param visible marks if assets should be hidden. Defaults to false.
     * @return returns the played tiles on the gameBoard that will be needed by the UI.
     */
    public List<Tile> setupGame(int players, boolean visible) {
        int numberOfPlayers = application.startGame(players, visible);
        gameManager.initialize(numberOfPlayers);
        GameBoard board = gameManager.getBoard();
        return board.currentBoard();
    }

    //Methods for players
    /**
     * This returns the first player for starting the game. (This could probably be eliminated?)
     * @return an int that represents the first player
     */
    public int chooseFirstPlayer() {
        return gameManager.firstPlayer();
    }

    /**
     * This gets the current player
     * @return an int that represents the current player
     */
    public int CurrentPlayer() {
        return gameManager.currentPlayerId();
    }

    /**
     * This plays a given tile on the board
     * @param tile tile to be played
     */
    public void playTile(Tile tile) {
        gameManager.playTile(tile);
    }

    /**
     * This buys a stock in a corp for a player
     * @param corporation the corp to buy from
     * @param playerId the player buying
     */
    public void buyStock(Corporation corporation, int playerId) {
        Player buyer = gameManager.idToPlayer(playerId);
        buyer.buyStock(corporation);
    }

    /**
     * Draws a new tile for the player at the beginning of each turn
     * @param player player drawing the tile
     */
     public void drawTile(Player player) {
        player.addTile(gameManager.drawTile());
    }

    /**
     * Discards a given tile
     * @param tile to be discarded
     * @return boolean to confirm the tile was discarded
     */
    public boolean discardTile(Tile tile) {
        boolean tileDiscarded = false;
        Player player = gameManager.currentPlayer();
        if(player.discardTiles(tile)) {
            gameManager.returnTile(tile);
            tileDiscarded = true;
        }
        return tileDiscarded;
    }

    /**
     * For trading tiles for new tiles for players
     * @param tile tile to trade in
     */
    public void tradeTile(Tile tile) {
        Player trader = gameManager.currentPlayer();
        Tile tradedTile = tile;
        if(this.discardTile(tile)) {
            tradedTile = gameManager.drawTile();
        }
        trader.addTile(tradedTile);
    }

    /**
     * Ends the current turn and starts the next
     * @return an int representing the next player
     */
    public int nextTurn() {
        currentPlayer = gameManager.nextTurn();
        application.updateState(gameManager, gameManager.getBoard(), gameManager.getPlayers());
        return currentPlayer.getPlayerId();
    }

    /**
     * Trades a stock to one player to another for cash
     * @param payer to buy stock
     * @param paid to sell stock
     * @param money amount stock is sold for
     * @param stock stock traded
     * @return boolean to confirm trade
     */
    public boolean TradeStocks(int payer, int paid, int money, Stock stock){
        boolean success = false;
        Player payingPlayer = gameManager.idToPlayer(payer);
        Player payedPlayer = gameManager.idToPlayer(paid);
        if (gameManager.pay(payingPlayer, payedPlayer, money)) {
            payedPlayer.tradeAwayStock(stock);
            payingPlayer.addStock(stock);
            success = true;
        }
        return success;
    }

    //Methods for ending the game

    /**
     * Checks to see if the game can be ended
     * @return a boolean that is true if the game can be ended
     */
    public boolean checkGameEnd() {
        return gameManager.checkGameEnd();
    }

    /**
     * Used to end the game and determine scores
     * @return the scoresheet as a list of strings
     */
    public List<String> end() {
        return gameManager.calculateScores();
    }

    // Methods for save/load state

    /**
     * Saves the game with the current state
     * @param filePath full path of directory to save at
     * @param fileName specific file name to save in the directory
     * @return a boolean to confirm save
     */
    public boolean save(File filePath, String fileName) {
        application.updateState(gameManager, gameManager.getBoard(), gameManager.getPlayers());
        return application.saveGame(filePath, fileName);
    }

    /**
     * Used to load a game from a file
     * @param file to load from
     * @throws FileNotFoundException
     * @return boolean to confirm load
     */
    public boolean load(File file) throws FileNotFoundException {
        boolean loaded = false;
        application.loadGame(file);
        if (this.getState()) {
            loaded = true;
        }
        return loaded;
    }

    /**
     * used by load game to update the state of a game after loading a game
     * @return boolean to confirm update
     */
    public boolean getState() {
        gameManager = application.getManagerState();
        gameManager.setBoard(application.getBoard());
        gameManager.setPlayers(application.getPlayers());
        currentPlayer = gameManager.currentPlayer();
        return true;
    }
}
