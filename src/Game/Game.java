package Game;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private int maxPlayers = 6;
    private int maxFrames = 10;
    private int maxScore = 10;

    public Game() {
        players = new ArrayList<Player>();
    }

    public void newPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    public void updateScore(int playerNum, int currentFrameNum) {
        if (currentFrameNum > 0) {
            checkAndScoreForSpare(playerNum, currentFrameNum);
            checkAndScoreForStrike(playerNum, currentFrameNum);
        }
    }

    private void checkAndScoreForStrike(int playerNum, int currentFrameNum) {
        // if previous frame is a strike and this frame is not a strike, then add these two bowls to the previous frame.
        if (isPreviousFrameStrike(playerNum, currentFrameNum) && !(getCurrentFrame(playerNum, currentFrameNum).isStrike())) {
            // extra points calculated from current frame first bowl and second bowl
            int extraPoints = getCurrentFrame(playerNum, currentFrameNum).getFirstBowl() + getCurrentFrame(playerNum, currentFrameNum).getSecondBowl();
            updatePreviousFrameScore(extraPoints, playerNum, currentFrameNum);
            // if previous frame is a strike, and the frame previous to that is a strike and there have been enough frames to calculate this,
            // add the strike points from last frame and the first bowl from this frame
        } else if (isPreviousFrameStrike(playerNum, currentFrameNum) && getPreviousPreviousFrame(playerNum, currentFrameNum).isStrike() && currentFrameNum > 1) {
                int extraPoints = getPreviousFrame(playerNum, currentFrameNum).getFirstBowl() + getCurrentFrame(playerNum, currentFrameNum).getFirstBowl();
                getPreviousPreviousFrame(playerNum, currentFrameNum).updateFrameScore(extraPoints);
        }
    }

    private void checkAndScoreForSpare( int playerNum, int currentFrameNum) {
        if (isPreviousFrameSpare(playerNum, currentFrameNum)) {
            updatePreviousFrameScore(getCurrentFrame(playerNum, currentFrameNum).getFirstBowl(), playerNum, currentFrameNum);
        }
    }

    public boolean isPreviousFrameSpare(int playerNum, int currentFrameNum) {
        return getPreviousFrame(playerNum, currentFrameNum).isSpare() && !(getPreviousFrame(playerNum, currentFrameNum).isStrike());
    }

    public void updatePreviousFrameScore(int score, int playerNum, int currentFrameNum) {
        getPreviousFrame(playerNum, currentFrameNum).updateFrameScore(score);
    }

    public boolean isPreviousFrameStrike(int playerNum, int currentFrameNum) {
        return getPreviousFrame(playerNum, currentFrameNum).isStrike();
    }

    public Frame getPreviousPreviousFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getFrame(currentFrameNum - 2);
    }

    public Frame getCurrentFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getFrame(currentFrameNum);
    }


    public Frame getPreviousFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getFrame(currentFrameNum - 1);
    }

    public String printFullScoreCard() {
        String scoreCard = "";
        for (Player player : players) {
            scoreCard = player.getName() + " " + player.printScoreCard() + " \n ";
        }
        return scoreCard;
    }

    public Player getPlayer(int playerNum) {
        return getPlayers().get(playerNum);
    }

    public boolean isBowl1Valid(int score) {
        return score <= getMaxScore() && score >= 0;
    }

    public boolean isBowl2Valid(int bowl1Score, int bowl2Score) {
        return  (bowl1Score + bowl2Score) < getMaxScore();
    }

    public boolean isNoOfPlayersValid(int noOfPlayers) {
        return noOfPlayers <= getMaxPlayers() && noOfPlayers > 0;
    }

    public boolean isStrike(int bowlScore) {
        return bowlScore == getMaxScore();
    }

    public boolean isStrikeOrSpare(int playerNum, int frameNum) {
        return getCurrentFrame(playerNum, frameNum).isSpare() || getCurrentFrame(playerNum, frameNum).isStrike();
    }
    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @return the maxPlayers
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }


    public int getMaxFrames() {
        return maxFrames;
    }

    public int getMaxScore() {
        return maxScore;
    }
}
