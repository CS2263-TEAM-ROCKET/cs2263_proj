package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class GameBoard {

    //Variables
    @Getter @Setter private List<Tile> playedTiles;

    @Getter @Setter private List<Tile> deck;

    @Getter @Setter private List<Corporation> corporations;

    //Methods
    public List<Tile> currentBoard(){
        return getPlayedTiles();
    }

    public Tile getRandomTile(){
        return deck.remove(0); //This index needs to be made random
    }

    public void playTile(Tile tile) {
        playedTiles.add(tile);
    }
}
