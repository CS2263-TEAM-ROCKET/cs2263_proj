package edu.isu.cs2263.proj.data;

import lombok.*;

@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor @ToString
public class StateObject {

    //Variables // This all needs to be filled out for saving to retain a state
    @Getter @Setter GameManager manager;

    @Getter @Setter GameSettings settings;

    @Getter @Setter PlayerList players;

    @Getter @Setter GameBoard board;
}
