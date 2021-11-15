package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor @AllArgsConstructor @ToString
public class Player {

    //Variables
    @Getter @Setter private int money = 6000;

    @Getter @Setter public List<Tile> hand = new ArrayList<>();

    @Getter @Setter public List<Stock> stocks;

    @Getter public final int playerId;

    //Methods

    /**
     * is used to buy stocks for players. Players must payer for available stocks
     * @param corporation is the corp to buy from
     */
    public void buyStock(Corporation corporation) {
        int currentStockValue = corporation.getStockValue();
        if (corporation.hasStock() & money >= currentStockValue) {
            money -= currentStockValue;
            Stock boughtStock = corporation.playerBuysStock();
            stocks.add(boughtStock);
        }
    }

    public void trade() {

    }

    /**
     * Is used to add tiles to the players hand
     * @param tile to be added
     */
    public void addTile(Tile tile) {
        hand.add(tile);
    }

    /**
     * Used to discard tiles from the player hand back to the board pile
     * @param tile to discard
     * @return boolean to confirm that the tile was discarded. (Maybe useless)
     */
    public boolean discardTiles(Tile tile) {
        boolean tileDiscarded = false;
        if(hand.contains(tile)) {
            hand.remove(tile);
            tileDiscarded = true;
        }
        return tileDiscarded;
    }

    /**
     * removes money from player when paying for things
     * @param payed money
     * @return a boolean confirming that the player could pay
     */
    public boolean pay(int payed){
        boolean didPay = false;
        if(money >= payed) {
            money -= payed;
            didPay = true;
        }
        return didPay;
    }

    /**
     * Adds money to the players funds
     * @param moneyGot to add
     */
    public void receiveMoney(int moneyGot) {
        money += moneyGot;
    }

    /**
     * Removes a stock from the player
     * @param stock to be removed
     * @return a boolean to confirm
     */
    public boolean tradeAwayStock(Stock stock) {
        return stocks.remove(stock);
    }

    public boolean addStock(Stock stock) {
        return stocks.add(stock);
    }

    public void endTurn() { // Not sure if we want this here or in GM

    }

    public void endGame() { // Not sure if we want this here or in GM

    }
}
