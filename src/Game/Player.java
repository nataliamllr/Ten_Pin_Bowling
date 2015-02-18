package Game;
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Integer> scores;

    public Player(String playerName) {
        name = playerName;
        scores = new ArrayList<Integer>();
    }

    public void appendScore(int newScore) {

        scores.add(newScore);
    }

    public void bowl(){

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



}
