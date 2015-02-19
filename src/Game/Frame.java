package Game;

/**
 * Created by Natalia on 18/02/2015.
 */
public class Frame {
    private int firstBowl;
    private int secondBowl;
    private boolean strike;
    private int extraBowl;
    private int extraPoints;

    public Frame(int bow1, int bowl2, boolean isStrike) {
        firstBowl = bow1;
        secondBowl = bowl2;
        strike = isStrike;
        extraBowl = 0;
        extraPoints = 0;
    }

    public int getFrameTotalScore() {
        return firstBowl + secondBowl;
    }

    public int getFrameTotalScorePlusExtra() {
        return firstBowl + secondBowl + extraPoints + extraBowl;
    }

    public void updateFrameScore(int score) {
        extraPoints += score;
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

    public int getExtraBowl() {
        return extraBowl;
    }

    public void setExtraBowl(int extraBowl) {
        this.extraBowl = extraBowl;
    }

    public String toString() {
        return "    Frame Total: " + getFrameTotalScorePlusExtra();
    }

}
