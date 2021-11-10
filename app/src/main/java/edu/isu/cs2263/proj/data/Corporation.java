package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Corporation {

    //Variables
    @Getter @Setter public String name = "";

    @Getter @Setter public List<Tile> tiles;

    @Getter @Setter public List<Stock> stocks;

    @Getter @Setter public boolean safe = false;
}
