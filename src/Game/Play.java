package Game;

import java.util.Scanner;

public class Play {
    private static Game game;
    private static Scanner scanner;

    public static void main(String[] args) {
        game = new Game();
        scanner = new Scanner(System.in);
        playGame();

    }

    public static void playGame() {
        System.out.println("How many players?");
        int noOfPlayers = scanner.nextInt();
        checkAndCreateNumOfPlayers(noOfPlayers);

        for (int frameNum = 0; frameNum < 10; frameNum++) {
            playFrame(frameNum);
        }
        System.out.println(game.printFullScoreCard());
    }

    private static void playFrame(int frameNum) {
        for (int playerNum = 0; playerNum < game.getPlayers().size(); playerNum++) {
            playerBowl(frameNum, playerNum);
        }
    }

    private static void playerBowl(int frameNum, int playerNum) {
        boolean isStrike = false;
        int bowl1Score = 0;
        int bowl2Score = 0;

        System.out.println("Please enter player - " + game.getPlayers().get(playerNum).getName() + ", Frame - " + frameNum + ", bowl - 1, score:");
        bowl1Score = scanner.nextInt();
        if (game.isStrike(bowl1Score)) {
            isStrike = true;
            game.setPlayerScore(bowl1Score, bowl2Score, playerNum, isStrike, frameNum);
            return;
        } else {
            System.out.println("Please enter player - " + game.getPlayers().get(playerNum).getName() + ", Frame - " + frameNum + ", bowl -  2, score:");
            bowl2Score = scanner.nextInt();
            game.setPlayerScore(bowl1Score, bowl2Score, playerNum, isStrike, frameNum);
        }
    }

    private static void createPlayers(int noOfPlayers) {
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print("Enter Player " + i + " name");
            game.newPlayer(scanner.next());
        }
    }

    private static void checkAndCreateNumOfPlayers(int noOfPlayers) {
        if (noOfPlayers > game.getMaxPlayers()) {
            System.out.println("Sorry you cannot have more than 6 players");
            System.out.println("How many players?");
            checkAndCreateNumOfPlayers(scanner.nextInt());
        } else {
            createPlayers(noOfPlayers);
        }
    }
}
