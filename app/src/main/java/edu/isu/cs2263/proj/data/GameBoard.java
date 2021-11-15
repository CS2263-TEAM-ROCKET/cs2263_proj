package edu.isu.cs2263.proj.data;

import lombok.*;
import org.checkerframework.checker.units.qual.C;

import java.util.*;

/**
 * This class represents the game board for the game
 */
@NoArgsConstructor @AllArgsConstructor @ToString
public class GameBoard {

    //Variables
    @Getter @Setter private List<Tile> playedTiles;

    @Getter @Setter private List<Tile> deck;

    @Getter @Setter private CorporationList corporations = new CorporationList();

    //Methods

    /**
     * Used to initialize the game board tiles
     */
    public void initialize() {
        initTiles();
        playedTiles = new ArrayList<>();
        corporations.initializeCorps();
    }

    public void initTiles() {
        deck = new ArrayList<>();
        char tileNum = 1;
        char tileLet = 'A';
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                Tile newTile = new Tile(tileLet, tileNum);
                deck.add(newTile);
                tileLet++;
            }
            tileNum++;
        }
    }

    /**
     * Returns the currently played tiles
     *
     * @return List of tiles played
     */
    public List<Tile> currentBoard() {
        return getPlayedTiles();
    }

    /**
     * Used to return a random tile for drawing from the pile
     *
     * @return Random Tile
     */
    public Tile getRandomTile() {
        Random random = new Random();
        int numberOfTiles = deck.size();
        int randomIndex = random.nextInt(numberOfTiles);
        return deck.remove(randomIndex);
    }

    /**
     * This plays a given tile on the game board
     *
     * @param tile to be played
     */
    public void playTile(Tile tile) {
        playedTiles.add(tile);
    }

    /**
     * Returns a given tile to the pile of unplaced tiles
     *
     * @param tile to be returned
     */
    public void tileReturn(Tile tile) {
        deck.add(tile);
    }

    public void showBoard(){
        char tileNum = 1;
        char tileLet = 'A';
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(tileLet + tileNum + " ");
                tileLet++;
            }
            System.out.println();
            tileNum++;
        }
    }

    /**
     * Merges two corps. The smaller loses. In a tie a choice is made by scanner input.
     * @param corp1 fist corp
     * @param corp2 second corp
     * @return the failing corp
     */
    public Corporation mergeCorporations(Corporation corp1, Corporation corp2) {
        Corporation failingCorp = new Corporation();
        if (corp1.getTilesOwned() > corp2.getTilesOwned()) {
            for (Tile tiles : playedTiles) {
                if (tiles.getOwner().equals(corp2)) { //for all tiles owned by the smaller corp
                    tiles.setOwner(corp1); // They are now owned by larger
                    failingCorp = corp2;
                }
            }
        } else if (corp1.getTilesOwned() < corp2.getTilesOwned()) {
            for (Tile tiles : playedTiles) {
                if (tiles.getOwner().equals(corp1)) { //for all tiles owned by the smaller corp
                    tiles.setOwner(corp2); // They are now owned by larger
                    failingCorp = corp1;
                }
            }
        } else if (corp1.getTilesOwned() == corp2.getTilesOwned()) {
            boolean decision = false;
            while (!decision) {
                Scanner getWinner = new Scanner(System.in);
                System.out.println("Merging Corps are the same size who wins " + corp1.getName() + "(1), or " + corp2.getName() + "(2).");
                String winner = getWinner.nextLine();
                getWinner.close();
                Corporation winningCorp = new Corporation();
                Corporation losingCorp = new Corporation();
                if (Objects.equals(winner, "1")) {
                    winningCorp = corp1;
                    losingCorp = corp2;
                    decision = true;
                } else if (Objects.equals(winner, "2")){
                    winningCorp = corp2;
                    losingCorp = corp1;
                    decision = true;
                } else {
                    System.out.println("Selection invalid please choose 1 or 2");
                }
                for (Tile tiles : playedTiles) {
                    if (tiles.getOwner().equals(losingCorp)) {
                        tiles.setOwner(winningCorp);
                        failingCorp = losingCorp;
                    }
                }
            }
        }
        return failingCorp;
    }
}
