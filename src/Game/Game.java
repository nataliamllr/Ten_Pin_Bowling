package Game;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private int maxPlayers = 6;
    private int strikeScore = 10;
    private int maxFrames = 10;
    private int maxScore = 10;

    public Game() {
        players = new ArrayList<Player>();
    }

    public void newPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    public boolean isStrike(int score) {
        return score == 10;
    }

    public void setPlayerScore(int bowl1Score, int bowl2Score,  int playerNum,  boolean isStrike, int currentFrameNum) {
        players.get(playerNum).addScoreToScoreCard(bowl1Score, bowl2Score, isStrike);
        if(isPreviousFrameSpare(playerNum, currentFrameNum) && currentFrameNum > 0) {
            updatePlayerScoreForSpare(bowl1Score, playerNum, currentFrameNum);
        }
        if(isPreviousFrameStrike(playerNum, currentFrameNum) && currentFrameNum > 0) {

        }
    }

    public boolean isPreviousFrameSpare(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getScoreCard().get(currentFrameNum-1).getFrameTotalScore() == getMaxScore();
    }

    public void updatePlayerScoreForSpare(int score, int playerNum, int currentFrameNum) {
        getPreviousFrame(playerNum, currentFrameNum).updateFrameScore(score);
    }

    public boolean isPreviousFrameStrike(int playerNum, int currentFrameNum) {
        return getPreviousFrame(playerNum, currentFrameNum).getFirstBowl() == getStrikeScore();
    }

    public void updatePlayerScoreForStrike(int playerNum, int currentFrameNum, int bowl1Score, int bowl2Score) {
     //   if(isPreviousFrameStrike(playerNum, currentFrameNum) && getPreviousFrame() ){

     //
     //   }
    }

    public Frame getPreviousFrame(int playerNum, int currentFrameNum) {
        return players.get(playerNum).getScoreCard().get(currentFrameNum-1);
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return the maxPlayers
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * @param maxPlayers the maxPlayers to set
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public void setStrikeScore(int strikeScore) {
        this.strikeScore = strikeScore;
    }

    public int getMaxFrames() {
        return maxFrames;
    }

    public void setMaxFrames(int maxFrames) {
        this.maxFrames = maxFrames;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
