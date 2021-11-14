package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;
import java.util.Random;

@NoArgsConstructor @AllArgsConstructor @ToString
public class GameBoard {

    //Variables
    @Getter @Setter private List<Tile> playedTiles;

    @Getter @Setter private List<Tile> deck;

    @Getter @Setter private List<Corporation> corporations;

    //Methods
    public void initialize() {
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

    public List<Tile> currentBoard(){
        return getPlayedTiles();
    }

    public Tile getRandomTile(){
        Random random = new Random();
        int numberOfTiles = playedTiles.size();
        int randomIndex = random.nextInt(numberOfTiles);
        return deck.remove(randomIndex);
    }

    public void playTile(Tile tile) {
        playedTiles.add(tile);
    }

    public void tileReturn(Tile tile) {
        deck.add(tile);
    }
}
