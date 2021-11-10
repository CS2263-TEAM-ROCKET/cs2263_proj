package edu.isu.cs2263.proj.data;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Tile {

    //Variables
    @Getter @Setter public String letter = "";

    @Getter @Setter public String number = "";

    @Getter @Setter public Corporation owner;
}
