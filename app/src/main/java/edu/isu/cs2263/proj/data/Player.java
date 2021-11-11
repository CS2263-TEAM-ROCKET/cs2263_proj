package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor @AllArgsConstructor @ToString
public class Player {

    //Variables
    @Getter @Setter private int money = 0;

    @Getter @Setter public List<Tile> hand;

    @Getter @Setter public List<Stock> stocks;

    @Getter @Setter @NonNull public final int playerId;

    //Methods
    public void playTile() {

    }

    public void buyStock(Corporation corporation) {
        Stock boughtStock = corporation.playerBuysStock();
        stocks.add(boughtStock);
    }

    public void trade() {

    }

    public void addTile(Tile tile) {
        hand.add(tile);
    }

    public void discardTiles() {

    }

    public void endTurn() {

    }

    public void endGame() {

    }
}
