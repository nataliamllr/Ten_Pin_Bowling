package Game;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by Natalia on 18/02/2015.
 */
public class Frame {
   // private HashMap<Player, Integer[]> bowls;
    private int firstBowl;
    private int secondBowl;
    private boolean strike;

    public Frame(int bow1, int bowl2, boolean isStrike) {
        firstBowl = bow1;
        secondBowl = bowl2;
        strike = isStrike;
    }

    public int getSecondBowl() {
        return secondBowl;
    }

    public void setSecondBowl(int secondBowl) {
        this.secondBowl = secondBowl;
    }

    public int getFirstBowl() {
        return firstBowl;
    }

    public void setFirstBowl(int firstBowl) {
        this.firstBowl = firstBowl;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }
}
