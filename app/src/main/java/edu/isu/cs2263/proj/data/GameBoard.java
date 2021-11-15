package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;
import java.util.Random;

/**
 * This class represents the game board for the game
 */
@NoArgsConstructor @AllArgsConstructor @ToString
public class GameBoard {

    //Variables
    @Getter @Setter private List<Tile> playedTiles;

    @Getter @Setter private List<Tile> deck;

    @Getter @Setter private CorporationList corporations = new CorporationList();

    //Methods

    /**
     * Used to initialize the game board tiles
     */
    public void initialize() {
        initTiles();
        corporations.initializeCorps();
    }

    public void initTiles(){
        char tileNum = 1;
        char tileLet = 'A';
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <=  8; j++) {
                Tile newTile = new Tile(tileLet, tileNum);
                deck.add(newTile);
                tileLet++;
            }
            tileNum++;
        }
    }

    /**
     * Returns the currently played tiles
     * @return List of tiles played
     */
    public List<Tile> currentBoard(){
        return getPlayedTiles();
    }

    /**
     * Used to return a random tile for drawing from the pile
     * @return Random Tile
     */
    public Tile getRandomTile(){
        Random random = new Random();
        int numberOfTiles = playedTiles.size();
        int randomIndex = random.nextInt(numberOfTiles);
        return deck.remove(randomIndex);
    }

    /**
     * This plays a given tile on the game board
     * @param tile to be played
     */
    public void playTile(Tile tile) {
        playedTiles.add(tile);
    }

    /**
     * Returns a given tile to the pile of unplaced tiles
     * @param tile to be returned
     */
    public void tileReturn(Tile tile) {
        deck.add(tile);
    }

    public void mergeCorporations(Corporation corp1, Corporation corp2) {
        if(corp1.getTilesOwned() > corp2.getTilesOwned()){
            for(Tile tiles: playedTiles) {
                if (tiles.getOwner()
            }
        }
    }
}
