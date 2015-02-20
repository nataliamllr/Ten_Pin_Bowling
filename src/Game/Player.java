package Game;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Frame> scoreCard;

    /**
     * Constructor for player
     * @param playerName
     */
    public Player(String playerName) {
        name = playerName;
        scoreCard = new ArrayList<Frame>();
    }

    /**
     * @return the name of player
     */
    public String getName() {
        return name;
    }

    /**
     * Return the scorecard of the player (list of frames)
     * @return
     */
    public ArrayList<Frame> getScoreCard() {
        return scoreCard;
    }

    /**
     * Player bowls and stores the new frame with scores
     * @param score1
     * @param score2
     */
    public void bowl(int score1, int score2) {
        Frame frame = new Frame(score1, score2);
        scoreCard.add(frame);
    }

    /**
     * Print the scorecard with the grand total of scores
     * @return
     */
    public String printScoreCard() {
        String results = "";
        for (int i = 0; i < scoreCard.size()-1; i++) {
            results = results+  i + scoreCard.get(i).toString() + " |  ";
        }
        return results + "Total: " + getTotalFromScoreCard();
    }

    /**
     * Add up each score from each frame and return the grand total
     * @return
     */
    public int getTotalFromScoreCard() {
        int total = 0;
        for (Frame sC : scoreCard) {
            total += sC.getFrameTotalScorePlusExtra();
        }
        return total;
    }

    /**
     * Return a specified frame.
     * @param frameNum
     * @return
     */
    public Frame getFrame(int frameNum) {
            return getScoreCard().get(frameNum);
    }

}
