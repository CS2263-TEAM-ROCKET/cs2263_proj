package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Player {

    //Variables
    @Getter @Setter public int money = 0;

    @Getter @Setter public List<Tile> hand;

    @Getter @Setter public List<Stock> stocks;

    //Methods
    public void playTile() {

    }

    public void buyStock() {

    }

    public void trade() {

    }

    public void drawTile() {

    }

    public void discardTiles() {

    }

    public void endTurn() {

    }

    public void endGame() {

    }
}
