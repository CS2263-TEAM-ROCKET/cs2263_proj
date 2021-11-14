package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.List;
import java.util.ListIterator;

@NoArgsConstructor
public class Corporation {

    //Constructor
    public Corporation(String name, String color, int baseStockValue, int baseMajorityPay, int baseMinorityPay) {
        setName(name);
        setColor(color);
        setBaseStockValue(baseStockValue);
        setBaseMajorityPay(baseMajorityPay);
        setBaseMinorityPay(baseMinorityPay);
    }
    //Variables
    @Getter @Setter @NonNull public String name;

    @Getter @Setter @NonNull public String color;

    @Getter @Setter public int tilesOwned = 0;

    @Getter @Setter public List<Stock> stocks;

    @Getter @Setter public boolean safe = false;

    @Getter @Setter public int baseStockValue;

    @Getter @Setter public int baseMajorityPay;

    @Getter @Setter public int baseMinorityPay;

    private final ListIterator<Stock> iterator = stocks.listIterator();

    //Methods
    public Stock playerBuysStock() {
        Stock stock = new Stock();
        if(iterator.hasNext()){
            stock = (Stock) iterator.next();
        }
        return stock;
    }

    public int getStockValue() {
        int value = baseStockValue;
        if (tilesOwned == 3) {
            value += 100;
        }
        else if (tilesOwned == 4) {
            value += 200;
        }
        else if (tilesOwned == 5) {
            value += 300;
        }
        else if (tilesOwned <= 10) {
            value += 400;
        }
        else if (tilesOwned <= 20) {
            value += 500;
        }
        else if (tilesOwned <= 30) {
            value += 600;
        }
        else if (tilesOwned <= 40) {
            value += 700;
        }
        else {
            value += 800;
        }
        return value;
    }

    public int getMajorityPayout() {
        int value = baseMajorityPay;
        if (tilesOwned == 3) {
            value += 1000;
        }
        else if (tilesOwned == 4) {
            value += 2000;
        }
        else if (tilesOwned == 5) {
            value += 3000;
        }
        else if (tilesOwned <= 10) {
            value += 4000;
        }
        else if (tilesOwned <= 20) {
            value += 5000;
        }
        else if (tilesOwned <= 30) {
            value += 6000;
        }
        else if (tilesOwned <= 40) {
            value += 7000;
        }
        else {
            value += 8000;
        }
        return value;
    }

    public int getMinorityValue() {
        int value = baseMinorityPay;
        if (tilesOwned == 3) {
            value += 500;
        }
        else if (tilesOwned == 4) {
            value += 1000;
        }
        else if (tilesOwned == 5) {
            value += 1500;
        }
        else if (tilesOwned <= 10) {
            value += 2000;
        }
        else if (tilesOwned <= 20) {
            value += 2500;
        }
        else if (tilesOwned <= 30) {
            value += 3000;
        }
        else if (tilesOwned <= 40) {
            value += 3500;
        }
        else {
            value += 4000;
        }
        return value;
    }
}
