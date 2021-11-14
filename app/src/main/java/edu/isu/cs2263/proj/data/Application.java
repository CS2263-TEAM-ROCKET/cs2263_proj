package edu.isu.cs2263.proj.data;

import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;

@NoArgsConstructor @AllArgsConstructor @ToString
public class Application {

    //Variables
    @Getter @Setter public GameSettings settings;

    @Getter @Setter public StateManager stateManager;

    @Getter @Setter public StateObject state;

    //Methods
    //initialization methods
    public int startGame(int players, boolean visible) {
        settings.setPlayerAmount(players);
        settings.setHiddenAssets(visible);
        return settings.getPlayerAmount();
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

    public void updateState(GameManager gameManager, GameBoard gameBoard, PlayerList players) {
        state.setSettings(settings);
        state.setManager(gameManager);
        state.setBoard(gameBoard);
        state.setPlayers(players);
    }

    public GameManager getManagerState() {
        return state.getManager();
    }

    public PlayerList getPlayers() {
        return state.getPlayers();
    }

    public GameBoard getBoard() {
        return state.getBoard();
    }
}
