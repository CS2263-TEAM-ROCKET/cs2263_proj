package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@NoArgsConstructor @RequiredArgsConstructor @ToString
public class GameManager {

    //Variables
    @Getter @Setter @NonNull private PlayerList players;

    @Getter @Setter @NonNull private GameBoard board;

    //Methods
    public void pay() {

    }

    public int firstPlayer() {
        return players.chooseFirstPlayer();
    }

    public Player idToPlayer(int playerId) {
        return players.idToPlayer(playerId);
    }

    public Player currentPlayer() { //This is for direct alterations
        return players.getCurrentPlayer();
    }

    public int currentPlayerId() { //This is for references
        return players.getCurrentPlayerId();
    }

    /**
     * Initializes the gameManager, the Players, and the gameBoard it will use
     * @param numPlayers the start the game with
     */
    public void initialize(int numPlayers) {
        this.initPlayers(numPlayers);
        board.initialize();
    }

    /**
     * Used by the method initialize to get all the players and fill their hands with tiles
     * @param numPlayers to start the game with
     */
    public void initPlayers(int numPlayers) {
        players.addPlayers(numPlayers);
        List<Player> everyone = players.getPlayers();
        for (Player player : everyone){
            for (int j = 0; j <= 6 - 1; j++) { //Fills the players hands with cards
                player.addTile(drawTile());
            }
        }
    }

    /**
     * Starts the next turn
     * @return the next player
     */
    public Player nextTurn() {
        return players.nextTurn();
    }

    /**
     * Used to play tiles down
     * @param tile to be played
     */
    public void playTile(Tile tile) {
        board.playTile(tile);
    }

    /**
     * Draws a random tile from the board
     * @return a random tile
     */
    public Tile drawTile() {
    return board.getRandomTile();
    }

    /**
     * Takes a tile and returns it to the game board pile
     * @param tile to be returned
     */
    public void returnTile(Tile tile) {
        board.tileReturn(tile);
    }

    public void mergeCorporations() {

    }

    /**
     * Checks if the game can be ended
     * @return boolean if the game can be ended
     */
    public boolean checkGameEnd() {
        boolean endable = false;
        //need to add code here to check status
        return endable;
    }

    /**
     * Gets the players scores at the end of the game
     * @return List of strings containing the scores
     */
    public List<String> calculateScores() {
        List<String> scores = null; //This needs changed to grab scores
        return scores;
    }
}
