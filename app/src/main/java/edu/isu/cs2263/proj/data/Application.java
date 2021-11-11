package edu.isu.cs2263.proj.data;

import com.google.gson.Gson;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Application {

    //Variables
    @Getter @Setter public GameManager manager;

    @Getter @Setter public GameSettings settings;

    Gson gson = new Gson();

    //Methods
    public void saveGame() {

    }

    public void loadGame() {

    }

    public void startGame() {

    }
}
