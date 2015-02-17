package Game;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	private int maxPlayers = 6;
	
	public Game() {
		players = new ArrayList<Player>();
	}
	
	public void newPlayer(String playerName) {
		Player player = new Player(playerName);
		players.add(player);
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
	
	
	

	
}
