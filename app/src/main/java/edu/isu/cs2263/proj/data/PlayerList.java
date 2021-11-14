package edu.isu.cs2263.proj.data;

import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor @ToString
public class PlayerList {

    //Variables
    @Getter @Setter @NonNull private List<Player> players;

    @Getter @Setter @NonNull private ListIterator<Player> turnTracker = players.listIterator();

    @Getter @Setter @NonNull private Player currentPlayer;

    //Methods
    public int chooseFirstPlayer() {
        Collections.shuffle(players);
        setCurrentPlayer(turnTracker.next());
        return getCurrentPlayer().getPlayerId();
    }

    public Player currentPlayer() {
        return getCurrentPlayer();
    }

    public int getCurrentPlayerId() {
        return getCurrentPlayer().getPlayerId();
    }

    public Player idToPlayer(int Id) {
        Player playerWithId = getCurrentPlayer();
        for (Player player : players) {
            if (player.getPlayerId() == Id) {
                playerWithId = player;
            }
        }
        return playerWithId;
    }

    public List<Player> addPlayers(int numPlayers) {
        for (int i = 0; i <= numPlayers - 1; i++) { //Creates all the players
            Player player = new Player(i);
            players.add(player);
        }
        return players;
    }

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

