package Game;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Frame> scoreCard;

    public Player(String playerName) {
        name = playerName;
        scoreCard = new ArrayList<Frame>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public ArrayList<Frame> getScoreCard() {
        return scoreCard;
    }

    public void bowl(int score1, int score2) {
        Frame frame = new Frame(score1, score2);
        scoreCard.add(frame);
    }

    public String printScoreCard() {
        String results = "";
        for (int i = 0; i < scoreCard.size()-1; i++) {
            results = results+  i + scoreCard.get(i).toString() + " |  ";
        }
        return results + "Total: " + getTotalFromScoreCard();
    }

    public int getTotalFromScoreCard() {
        int total = 0;
        for (Frame sC : scoreCard) {
            total += sC.getFrameTotalScorePlusExtra();
        }
        return total;
    }

    public Frame getFrame(int frameNum) {
            return getScoreCard().get(frameNum);
    }

}
