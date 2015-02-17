package Game;

import java.util.Scanner;

public class Play {
	static Game game;
	static Scanner scanner;

	public static void main(String[] args) {
		game = new Game();
		scanner = new Scanner(System.in);
		playGame();

	}
	
	public static void playGame() {
		System.out.println("How many players?");
		int noOfPlayers = scanner.nextInt();
		checkNumOfPlayers(noOfPlayers);	
		
		for (int i = 0; i < 10; i++) {
			
		}
	}

	private static void createPlayers(int noOfPlayers) {
		for(int i = 1; i <= noOfPlayers; i++) {
			System.out.print("Enter Player " + i + " name");
			game.newPlayer(scanner.next());
		}
	}

	private static void checkNumOfPlayers(int noOfPlayers) {
		if(noOfPlayers > game.getMaxPlayers()) {
			System.out.println("Sorry you cannot have more than 6 players");
			System.out.println("How many players?");
			checkNumOfPlayers(scanner.nextInt());
		} else {
			createPlayers(noOfPlayers);
		}
	}
}
