package edu.isu.cs2263.proj.data;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @ToString
public class GameSettings {

    //Variables
    @Getter @Setter public int playerAmount = 0;

    @Getter @Setter public boolean hiddenAssets = false;

    //Methods
    public void changePlayerAmount() {

    }

    public void changeHiddenAssets() {

    }
}
