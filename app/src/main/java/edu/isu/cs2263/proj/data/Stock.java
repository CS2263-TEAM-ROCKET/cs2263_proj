package edu.isu.cs2263.proj.data;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Stock {

    //Variables
    @Getter @Setter public Corporation corporation;

    @Getter @Setter public int price = 0;

    @Getter @Setter public Player owner;

    //Methods
    public int getValue() {
       return corporation.getStockValue();
    }
}
