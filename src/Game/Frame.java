package Game;

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

    public boolean isSpare() {
        return getFrameTotalScore() == 10;
    }

    public boolean isStrike() {
        return strike;
    }

    public int getSecondBowl() {
        return secondBowl;
    }

    public int getFirstBowl() {
        return firstBowl;
    }

    public String toString() {
        return "    Frame Total: " + getFrameTotalScorePlusExtra();
    }

}
