package edu.isu.cs2263.proj.data;

import com.google.gson.Gson;
import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Application {

    //Variables
    @Getter @Setter public GameManager manager;

    @Getter @Setter public GameSettings settings;

    @Getter @Setter public StateManager stateManager;

    @Getter @Setter public StateObject state;

    //Methods
    //initialization methods

    public GameManager startGame(int players, boolean visible) {
        settings.setPlayerAmount(players);
        settings.setHiddenAssets(visible);
        initManager(settings.getPlayerAmount());
        return getManager();
    }

    public void initManager(int players) {
        manager.initPlayers(players);
    }

    //State methods
    public boolean saveGame(File filePath, String fileName) {
        return stateManager.saveData(filePath, fileName, state);
    }

    public boolean loadGame(File file) throws FileNotFoundException {
        boolean loaded = false;
        if (stateManager.loadData(file, state)) {
            loaded = true;
        }
        return loaded;
    }
}
