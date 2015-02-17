package Game;

public class Player {
	
	private String name;
	private int score;
	
	public Player(String playerName) {
		name = playerName;
		score = 0;
	}
	
	public void appendScore(int newScore) {
		
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

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	

}
