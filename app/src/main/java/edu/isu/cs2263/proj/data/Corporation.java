package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;
import java.util.ListIterator;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Corporation {

    //Variables
    @Getter @Setter public String name = "";

    @Getter @Setter public List<Tile> tiles;

    @Getter @Setter public List<Stock> stocks;

    @Getter @Setter public boolean safe = false;

    private ListIterator iterator = stocks.listIterator();

    //Methods
    public Stock playerBuysStock() {
        Stock stock = new Stock();
        if(iterator.hasNext()){
            stock = (Stock) iterator.next();
        }
        return stock;
    }
}
