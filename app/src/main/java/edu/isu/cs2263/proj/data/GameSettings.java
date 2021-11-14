package edu.isu.cs2263.proj.data;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @ToString
public class GameSettings { // This class is bare but could be added to

    //Variables
    @Getter @Setter public int playerAmount = 0;

    @Getter @Setter public boolean hiddenAssets = false;

    //Methods
    public void changePlayerAmount() { // Not sure if needed

    }

    public void changeHiddenAssets() { //Not sure if needed

    }
}
