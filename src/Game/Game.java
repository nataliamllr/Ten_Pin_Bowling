package Game;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private static int MAX_PLAYERS = 6;
    private static int MAX_FRAMES = 10;
    private static int MAX_SCORE = 10;

    /**
     * Constructor for game
     */
    public Game() {
        players = new ArrayList<Player>();
    }

    /**
     * Create a new player with the player name. Add the new player to the list of players.
     *
     * @param playerName
     */
    public void newPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    /**
     * Checks whether the previous frames need to be updated with a new score. Check whether previous frames are either spare or strike.
     *
     * @param playerNum
     * @param currentFrameNum
     */
    public void updateScore(int playerNum, int currentFrameNum) {
        if (currentFrameNum > 0) {
            checkAndScoreForSpare(playerNum, currentFrameNum);
            checkAndScoreForStrike(playerNum, currentFrameNum);
        }
    }

    /**
     * Check whether the previous frame(s) are strikes. If so add the points from this frame to them.
     *
     * @param playerNum
     * @param currentFrameNum
     */
    private void checkAndScoreForStrike(int playerNum, int currentFrameNum) {
        // if previous frame is a strike and this frame is not a strike, then add these two bowls to the previous frame.
        if (isPreviousFrameStrike(playerNum, currentFrameNum) && !(getCurrentFrame(playerNum, currentFrameNum).isStrike())) {
            // extra points calculated from current frame first bowl and second bowl
            int extraPoints = getCurrentFrame(playerNum, currentFrameNum).getFirstBowl() + getCurrentFrame(playerNum, currentFrameNum).getSecondBowl();
            updatePreviousFrameScore(extraPoints, playerNum, currentFrameNum);
        }
        // if the previous and previous previous frames are strikes and this is the last frame which is also a strike, then add the points to the previous previous strike
        // and to the previous strike, add the first bowl and first extra bowl of the current frame
        if(currentFrameNum > 1) {
            if (isPreviousFrameStrike(playerNum, currentFrameNum) && getPreviousPreviousFrame(playerNum, currentFrameNum).isStrike()
                    && currentFrameNum == getMaxFrames() - 1 && getCurrentFrame(playerNum, currentFrameNum).isStrike()) {

                int extraPointsForPPS = getPreviousFrame(playerNum, currentFrameNum).getFirstBowl() + getCurrentFrame(playerNum, currentFrameNum).getFirstBowl();
                getPreviousPreviousFrame(playerNum, currentFrameNum).updateFrameScore(extraPointsForPPS);

                int extraPointsForPS = getCurrentFrame(playerNum, currentFrameNum).getFirstBowl() + getCurrentFrame(playerNum, currentFrameNum).getFirstExtraBowl();
                getPreviousFrame(playerNum, currentFrameNum).updateFrameScore(extraPointsForPS);

            }
            // if previous frame is a strike, and the frame previous to that is a strike
            // add the strike points from last frame and the first bowl from this frame
            else if (isPreviousFrameStrike(playerNum, currentFrameNum) && getPreviousPreviousFrame(playerNum, currentFrameNum).isStrike()) {
                int extraPoints = getPreviousFrame(playerNum, currentFrameNum).getFirstBowl() + getCurrentFrame(playerNum, currentFrameNum).getFirstBowl();
                getPreviousPreviousFrame(playerNum, currentFrameNum).updateFrameScore(extraPoints);
            }
        }
    }

    /**
     * Check whether the previous frame is a spare. If so then add the first bowl score from this frame to that frame.
     *
     * @param playerNum
     * @param currentFrameNum
     */
    private void checkAndScoreForSpare(int playerNum, int currentFrameNum) {
        if (isPreviousFrameSpare(playerNum, currentFrameNum)) {
            updatePreviousFrameScore(getCurrentFrame(playerNum, currentFrameNum).getFirstBowl(), playerNum, currentFrameNum);
        }
    }

    /**
     * Returns whether the previous frame is a spare
     *
     * @param playerNum
     * @param currentFrameNum
     * @return
     */
    public boolean isPreviousFrameSpare(int playerNum, int currentFrameNum) {
        return getPreviousFrame(playerNum, currentFrameNum).isSpare() && !(getPreviousFrame(playerNum, currentFrameNum).isStrike());
    }

    /**
     * Updates the previous frame score
     *
     * @param score
     * @param playerNum
     * @param currentFrameNum
     */
    public void updatePreviousFrameScore(int score, int playerNum, int currentFrameNum) {
        getPreviousFrame(playerNum, currentFrameNum).updateFrameScore(score);
    }

    /**
     * Returns whether the previous frame is a strike
     *
     * @param playerNum
     * @param currentFrameNum
     * @return
     */
    public boolean isPreviousFrameStrike(int playerNum, int currentFrameNum) {
        return getPreviousFrame(playerNum, currentFrameNum).isStrike();
    }

    /**
     * Returns the previous previous frame
     *
     * @param playerNum
     * @param currentFrameNum
     * @return
     */
    public Frame getPreviousPreviousFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getFrame(currentFrameNum - 2);
    }

    /**
     * Returns the current frame
     *
     * @param playerNum
     * @param currentFrameNum
     * @return
     */
    public Frame getCurrentFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getFrame(currentFrameNum);
    }

    /**
     * Returns the previous frame
     *
     * @param playerNum
     * @param currentFrameNum
     * @return
     */
    public Frame getPreviousFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getFrame(currentFrameNum - 1);
    }

    /**
     * Prints a string of each player and their scorecard
     *
     * @return
     */
    public String printFullScoreCard() {
        String scoreCard = "";
        for (Player player : players) {
            scoreCard = scoreCard + player.getName() + " " + player.printScoreCard() + " \n ";
        }
        return scoreCard;
    }

    /**
     * Returns the player at specified index
     *
     * @param playerNum
     * @return
     */
    public Player getPlayer(int playerNum) {
        return getPlayers().get(playerNum);
    }

    /**
     * Returns whether bowl 1 is valid. Bowl 1 can be between 0 & 10.
     *
     * @param score
     * @return
     */
    public boolean isBowl1Valid(int score) {
        return score <= getMaxScore() && score >= 0;
    }

    /**
     * Checks whether bowl 2 is valid.
     * @param bowl1Score
     * @param bowl2Score
     * @return
     */
    public boolean isBowl2Valid(int bowl1Score, int bowl2Score) {
        return (bowl1Score + bowl2Score) <= getMaxScore();
    }

    /**
     * Checks whether the number of players is valid. The max number is 6.
     * @param noOfPlayers
     * @return
     */
    public boolean isNoOfPlayersValid(int noOfPlayers) {
        return noOfPlayers <= getMaxPlayers() && noOfPlayers > 0;
    }

    /**
     * Returns whether the score is a strike. A strike is 10.
     * @param bowlScore
     * @return
     */
    public boolean isStrike(int bowlScore) {
        return bowlScore == getMaxScore();
    }

    /**
     * Returns whether the combined bowls are a spare
     * @param bowl1Score
     * @param bowl2Score
     * @return
     */
    public boolean isSpare(int bowl1Score, int bowl2Score) {
        return (bowl1Score + bowl2Score) == getMaxScore();
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
        return MAX_PLAYERS;
    }

    /**
     * Returns the max number of frames which is 10.
     * @return
     */
    public int getMaxFrames() {
        return MAX_FRAMES;
    }

    /**
     * Returns the max score which is 10.
     * @return
     */
    public int getMaxScore() {
        return MAX_SCORE;
    }
}
