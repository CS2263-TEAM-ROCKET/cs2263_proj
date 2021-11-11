package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class GameManager {

    //Variables
    @Getter @Setter private List<Player> players;

    @Getter @Setter private GameBoard board;

    @Getter @Setter private boolean visibility = true;

    //Methods
    public Player chooseFirstPlayer() {
        return players.get(0); //This is just a placeholder for now. Needs to get random from the full list
    }

    public void pay() {

    }

    public List<Tile> setupGameBoard(int numPlayers, boolean visible) {
        for(int i = 0; i <= numPlayers - 1; i++){ //Creates all the players
            Player player = new Player(i);
            for(int j = 0; j <= 7 - 1; j++) { //Fills the players hands with cards
                player.addTile(drawTile());
            }
            players.add(player);
            }
        this.setVisibility(visible); //Sets hand visibility
        return board.currentBoard();
    }

    public void changeTurn() {

    }

    public void playTurn() {

    }

    public void playTile(Tile tile) {
        board.playTile(tile);
    }

    public Tile drawTile() {
    return board.getRandomTile();
    }

    public void mergeCorporations() {

    }

    public void checkGameEnd() {

    }
}
