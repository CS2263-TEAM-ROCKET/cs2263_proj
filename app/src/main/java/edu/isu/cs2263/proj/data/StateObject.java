package edu.isu.cs2263.proj.data;

import lombok.*;

/**
 * Used a vessel for game state info to be saved as a file
 */
@NoArgsConstructor @AllArgsConstructor @ToString
public class StateObject {

    //Variables // This all needs to be filled out for saving to retain a state
    @Getter @Setter GameManager manager;

    @Getter @Setter GameSettings settings;

    @Getter @Setter PlayerList players;

    @Getter @Setter GameBoard board;
}
