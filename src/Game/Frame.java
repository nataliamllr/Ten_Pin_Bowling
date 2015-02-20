package Game;

public class Frame {
    private int firstBowl;
    private int secondBowl;
    private int firstExtraBowl;
    private int secondExtraBowl;
    private int extraPoints;

    /**
     * Constructor for frame
     * @param bow1
     * @param bowl2
     */
    public Frame(int bow1, int bowl2) {
        firstBowl = bow1;
        secondBowl = bowl2;
        firstExtraBowl = 0;
        secondExtraBowl = 0;
        extraPoints = 0;

    }

    /**
     * Return the score for the frame
     * @return
     */
    public int getFrameTotalScore() {
        return firstBowl + secondBowl;
    }

    /**
     * Return the total for the frame including extraPoints & extraBowl
     * @return
     */
    public int getFrameTotalScorePlusExtra() {
        return firstBowl + secondBowl + extraPoints + firstExtraBowl + secondExtraBowl;
    }

    /**
     * Update the frame score with extra points won from strike or spare
     * @param score
     */
    public void updateFrameScore(int score) {
        extraPoints += score;
    }

    /**
     * Return whether the frame is spare. It is a spare if bowl 1 and bowl 2 score equals 10.
     * @return
     */
    public boolean isSpare() {
        return getFrameTotalScore() == 10;
    }

    /**
     * Return whether the frame is a strike. It is a strike if the first bowl is 10.
     * @return
     */
    public boolean isStrike() {
        return firstBowl == 10;
    }

    /**
     * Return second bowl value
     * @return
     */
    public int getSecondBowl() {
        return secondBowl;
    }

    /**
     * Return first bowl value
     * @return
     */
    public int getFirstBowl() {
        return firstBowl;
    }

    /**
     * Return a string of the score total of  the frame
     * @return
     */
    public String toString() {
        return  String.valueOf(getFrameTotalScorePlusExtra());
    }

    /**
     * Set an extra bowl score. This is achieved if the last frame is a spare or strike
     * @param extraScore
     */
    public void setFirstExtraBowl(int extraScore){
        firstExtraBowl = extraScore;
    }

    public void setSecondExtraBowl(int extraScore) {
        secondExtraBowl  = extraScore;
    }

    public int getFirstExtraBowl() {
        return firstExtraBowl;
    }

}
