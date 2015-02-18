package Game;

import java.util.ArrayList;
import java.util.HashMap;

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

    public boolean isSpareScored(int score) {
        return true;
    }

    public void setPlayerScore(int score1, int score2,  int playerNum,  boolean isStrike) {
        players.get(playerNum).addScoreToScoreCard(score1, score2, isStrike);
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
}
