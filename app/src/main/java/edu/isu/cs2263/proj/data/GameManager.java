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

    public void initialize(int numPlayers) {
        this.initPlayers(numPlayers);
        board.initialize();
    }

    public void initPlayers(int numPlayers) {
        players.addPlayers(numPlayers);
        List<Player> everyone = players.getPlayers();
        for (Player player : everyone){
            for (int j = 0; j <= 6 - 1; j++) { //Fills the players hands with cards
                player.addTile(drawTile());
            }
        }
    }

    public Player nextTurn() {
        return players.nextTurn();
    }

    public void playTile(Tile tile) {
        board.playTile(tile);
    }

    public Tile drawTile() {
    return board.getRandomTile();
    }

    public void returnTile(Tile tile) {
        board.tileReturn(tile);
    }

    public void mergeCorporations() {

    }

    public boolean checkGameEnd() {
        boolean endable = false;
        //need to add code here to check status
        return endable;
    }

    public List<String> calculateScores() {
        List<String> scores = null; //This needs changed to grab scores
        return scores;
    }
}
