package Game;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	
	public Game() {
		players = new ArrayList<Player>();
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

	
}
