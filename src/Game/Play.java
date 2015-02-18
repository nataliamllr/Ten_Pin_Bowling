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
        checkAndCreateNumOfPlayers(noOfPlayers);
        int bowlNum;
        for (int i = 0; i < 10; i++) {
            for(int playerNum = 0; playerNum < game.getPlayers().size(); playerNum++) {
                bowlNum = 1;
                System.out.println("Please enter player " + playerNum + ", Frame " + i + ", bowl 1, score");
                int bowl1Score = scanner.nextInt();
                if(game.isStrike(bowl1Score)){
                    continue;
                } else {
                    game.setPlayerScore(bowl1Score, playerNum, bowlNum);
                    bowlNum = 2;
                    System.out.println("Please enter player " + playerNum + ", Frame " + i + ", bowl 2, score");
                    int bowl2Score = scanner.nextInt();
                    if(game.isSpareScored(bowl2Score)){

                    }
                }

            }
        }
    }

    private static void createPlayers(int noOfPlayers) {
        for (int i = 1; i <= noOfPlayers; i++) {
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
