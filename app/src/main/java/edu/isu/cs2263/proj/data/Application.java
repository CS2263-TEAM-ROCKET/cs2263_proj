package edu.isu.cs2263.proj.data;

import lombok.*;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is for keeping track of underlying game attributes
 */
@NoArgsConstructor @AllArgsConstructor @ToString
public class Application {

    //Variables
    @Getter @Setter public GameSettings settings;

    @Getter @Setter public StateManager stateManager;

    @Getter @Setter public StateObject state;

    //Methods
    //initialization methods

    /**
     * Starts the game by initializing game settings
     * @param players is the number of players
     * @param visible is the visibility of assets
     * @return returns an int with the number of players
     */
    public int startGame(int players, boolean visible) {
        settings = new GameSettings();
        settings.setPlayerAmount(players);
        settings.setHiddenAssets(visible);
        return settings.getPlayerAmount();
    }

    //State methods

    /**
     * Saves the game using a stateManager
     * @param filePath sets the path name for the directory to save at
     * @param fileName sets the specific file name to save
     * @return returns a boolean to confirm save
     */
    public boolean saveGame(File filePath, String fileName) {
        return stateManager.saveData(filePath, fileName, state);
    }

    /**
     * Loads the game using a stateManager object
     * @param file is the file to load from
     * @throws FileNotFoundException
     */
    public void loadGame(File file) throws FileNotFoundException {
        state = stateManager.loadData(file);
    }

    /**
     * This updates the stateObject, so it can be saved with current info
     * @param gameManager
     * @param gameBoard
     * @param players
     */
    public void updateState(GameManager gameManager, GameBoard gameBoard, PlayerList players) {
        state.setSettings(settings);
        state.setManager(gameManager);
        state.setBoard(gameBoard);
        state.setPlayers(players);
    }

    /**
     * This returns the gameManager when loading
     * @return GameManager
     */
    public GameManager getManagerState() {
        return state.getManager();
    }

    /**
     * returns the PlayerList when loading
     * @return PlayerList
     */
    public PlayerList getPlayers() {
        return state.getPlayers();
    }

    /**
     * This returns the gameboard when loading
     * @return GameBoard
     */
    public GameBoard getBoard() {
        return state.getBoard();
    }
}
