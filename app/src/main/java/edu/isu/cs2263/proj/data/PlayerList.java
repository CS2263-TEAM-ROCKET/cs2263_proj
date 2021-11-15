package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Holds the players and does operations on them
 */
@NoArgsConstructor @RequiredArgsConstructor @ToString
public class PlayerList {

    //Variables
    @Getter @Setter @NonNull private List<Player> players;

    @Getter @Setter @NonNull private ListIterator<Player> turnTracker;

    @Getter @Setter @NonNull private Player currentPlayer;

    //Methods

    /**
     * Chooses the first player
     * @return an int representing the first player
     */
    public int chooseFirstPlayer() {
        turnTracker = players.listIterator();
        Collections.shuffle(players);
        setCurrentPlayer(turnTracker.next());
        return getCurrentPlayer().getPlayerId();
    }

    /**
     * gets the current player's ID
     * @return int of ID
     */
    public int getCurrentPlayerId() {
        return getCurrentPlayer().getPlayerId();
    }

    /**
     * Gets the player for a given player ID int
     * @param Id of player
     * @return the player object
     */
    public Player idToPlayer(int Id) {
        Player playerWithId = getCurrentPlayer();
        for (Player player : players) {
            if (player.getPlayerId() == Id) {
                playerWithId = player;
            }
        }
        return playerWithId;
    }

    /**
     * Creates the number of players for the game
     * @param numPlayers to make
     */
    public void addPlayers(int numPlayers) {
        players = new ArrayList<Player>();
        for (int i = 0; i <= numPlayers - 1; i++) { //Creates all the players
            Player player = new Player(i);
            players.add(player);
        }
    }

    /**
     * Ends the current turn and start the next
     * @return player object for the next turn.
     */
    public Player nextTurn () {
        if (turnTracker.hasNext()) {
            currentPlayer = turnTracker.next();
        }
        else {
            while (turnTracker.hasPrevious()) {
                turnTracker.previous();
                currentPlayer = turnTracker.next();
            }
        }
        return currentPlayer;
    }
}

