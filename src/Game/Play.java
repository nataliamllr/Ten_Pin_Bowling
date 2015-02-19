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

        for (int frameNum = 0; frameNum < game.getMaxFrames(); frameNum++) {
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

        System.out.println("Please enter player - " + game.getPlayer(playerNum).getName() + ", Frame - " + frameNum + ", bowl - 1, score:");
        int bowl1Score = scanner.nextInt();
        if (game.isBowl1Valid(bowl1Score)) {
            if (game.isStrike(bowl1Score)) {
                isStrike = true;
                game.getPlayer(playerNum).bowl(bowl1Score, 0, isStrike);
                game.updateScore(playerNum, frameNum);
            } else if(frameNum == 10) {
                game.getPlayer(playerNum).bowl(bowl1Score, 0 , isStrike);
                game.updateScore(playerNum, frameNum);
            } else {
                playerSecondBowl(frameNum, playerNum, isStrike, bowl1Score);
            }
        } else {
            System.out.println("Sorry your first bowl score has to be between 0 & 10 - Try Again");
            playerBowl(frameNum, playerNum);
        }
    }


    private static void playerSecondBowl(int frameNum, int playerNum, boolean isStrike, int bowl1Score) {
        System.out.println("Please enter player - " + game.getPlayer(playerNum).getName() + ", Frame - " + frameNum + ", bowl -  2, score:");
        int bowl2Score = scanner.nextInt();
        if (game.isBowl2Valid(bowl1Score, bowl2Score)) {
            game.getPlayer(playerNum).bowl(bowl1Score, bowl2Score, isStrike);
            game.updateScore(playerNum, frameNum);
        } else {
            System.out.println("Sorry your second bowl score is invalid - Try again");
            playerSecondBowl(frameNum, playerNum, isStrike, bowl1Score);
        }
        // on last frame if player has scored a strike or a spare
        if(frameNum == 9 && game.isStrikeOrSpare(playerNum, frameNum)) {
            System.out.println("You have achieved an extra bowl!");
            playerBowl(10, playerNum);
        }
    }


    private static void createPlayers(int noOfPlayers) {
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print("Enter Player " + i + " name");
            game.newPlayer(scanner.next());
        }
    }

    private static void checkAndCreateNumOfPlayers(int noOfPlayers) {
        if (!game.isNoOfPlayersValid(noOfPlayers)) {
            System.out.println("Sorry you cannot have more than 6 players");
            System.out.println("How many players?");
            checkAndCreateNumOfPlayers(scanner.nextInt());
        } else {
            createPlayers(noOfPlayers);
        }
    }

}
