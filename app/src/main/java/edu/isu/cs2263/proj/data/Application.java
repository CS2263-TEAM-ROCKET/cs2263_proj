package edu.isu.cs2263.proj.data;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Application {

    //Variables
    @Getter @Setter public GameManager manager;

    @Getter @Setter public GameSettings settings;

    //Methods
    public void saveGame() {

    }

    public void loadGame() {

    }

    public void startGame() {

    }
}
