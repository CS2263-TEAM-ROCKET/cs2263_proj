package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Facade {

    //Variables
    @Getter @Setter private GameManager gameManager;

    //Methods
    //Methods for new game
    public List<Tile> setupGame(int players, boolean visible) {
        return gameManager.setupGameBoard(players, visible);
    }

    public Player chooseFirstPlayer() {
        return gameManager.chooseFirstPlayer();
    }

    //Methods for playing a tile
    public void playTile(Tile tile) {
        gameManager.playTile(tile);
    }

    //Methods for buying a stock
    public void buyStock(Corporation corporation, Player player) { //This can be altered to return a boolean to confirm
        player.buyStock(corporation);
    }

    //Methods for drawing new tiles
    public void drawTile() {

    }

    public void discardTile() {

    }

    //Methods for ending the game
    public void checkGameEnd() {

    }

    public void end() {

    }

    // Methods for save/load state
    public void save() {

    }

    public void load() {

    }
}
