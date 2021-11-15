package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.Arrays;
import java.util.List;

/**
 * This class holds all the corporations
 */
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor @ToString
public class CorporationList {

    //Variables
    @Getter @Setter public List<Corporation> corporations;

    //Methods

    /**
     * Initializes all the corps like they would be in the real game
     */
    public void initializeCorps() {
        Corporation newCorp = new Corporation("Tower", "Yellow", 200, 2000, 1000);
        corporations.add(newCorp);
        newCorp = new Corporation("Luxor", "Red", 200, 2000, 1000);
        corporations.add(newCorp);
        newCorp = new Corporation("American", "Blue", 300, 3000, 1500);
        corporations.add(newCorp);
        newCorp = new Corporation("Worldwide", "Orange", 300, 3000, 1500);
        corporations.add(newCorp);
        newCorp = new Corporation("Festival", "Green", 300, 3000, 1500);
        corporations.add(newCorp);
        newCorp = new Corporation("Imperial", "Pink", 400, 4000, 2000);
        corporations.add(newCorp);
        newCorp = new Corporation("Continental", "Purple", 400, 4000, 2000);
        corporations.add(newCorp);
    }
}