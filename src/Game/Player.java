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

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Frame> getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(ArrayList< Frame> scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void addScoreToScoreCard(int score1, int score2,  boolean isStrike) {
        Frame frame = new Frame(score1, score2, isStrike);
        scoreCard.add(frame);
    }

    public String printScoreCard() {
        String results = "";
        for (int i = 0; i < scoreCard.size(); i++) {
            results = "Frame "+ i + scoreCard.get(i).toString() + "     |     ";
        }
        return results;
    }

    public int getTotalFromScoreCard() {
        int total = 0;
        for(Frame sC : scoreCard) {
            total += sC.getFrameTotalScorePlusExtra();
        }
        return total;
    }
}
