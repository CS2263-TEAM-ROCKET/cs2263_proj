package edu.isu.cs2263.proj.data;

import lombok.*;

/**
 * Used to make stock objects
 */
@NoArgsConstructor @RequiredArgsConstructor @ToString
public class Stock {

    //Variables
    @Getter @Setter @NonNull public Corporation corporation;

    @Getter @Setter public int price = 0;

    @Getter @Setter public Player owner;

    //Methods

    /**
     * Gets the current value of the stock
     * @return an int of the current value
     */
    public int getValue() {
       return corporation.getStockValue();
    }
}
