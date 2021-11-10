package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class GameBoard {

    //Variables
    @Getter @Setter public List<Tile> playedTiles;

    @Getter @Setter public List<Tile> deck;

    @Getter @Setter public List<Corporation> corporations;
}
