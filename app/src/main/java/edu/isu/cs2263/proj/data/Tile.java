package edu.isu.cs2263.proj.data;

import lombok.*;

/**
 * Used to make tile objects
 */
@NoArgsConstructor @ToString
public class Tile {

    //Constructor
    public Tile(char letter, char number) {
        setLetter(letter);
        setNumber(number);
    }

    //Variables
    @Getter @Setter public char letter;

    @Getter @Setter public char number;

    @Getter @Setter public Corporation owner;
}
