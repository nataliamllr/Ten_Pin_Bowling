package Game;

import java.util.Scanner;

public class Play {
    private static Game game;
    private static Scanner scanner;

    /**
     * Main method which starts the game
     * @param args
     */
    public static void main(String[] args) {
        game = new Game();
        scanner = new Scanner(System.in);
        playGame();

    }

    /**
     * Play game method creates the players and stars the game. At the end of the game it prints out the scorecard of each player.
     */
    public static void playGame() {
        System.out.println("How many players?");
        int noOfPlayers = scanner.nextInt();
        checkAndCreateNumOfPlayers(noOfPlayers);
        //iterate through each frame
        for (int frameNum = 0; frameNum < game.getMaxFrames(); frameNum++) {
            playFrame(frameNum);
        }
        System.out.println(game.printFullScoreCard());
    }

    /**
     * Play frame method iterates through each player. Each player then bowls.
     * @param frameNum
     */
    private static void playFrame(int frameNum) {
        for (int playerNum = 0; playerNum < game.getPlayers().size(); playerNum++) {
            playerBowl(frameNum, playerNum);
        }
    }

    /**
     * Player bowl method takes in bowl score. It then validates and determines whether the bowl is a strike or whether the player gets another bowl/
     * @param frameNum
     * @param playerNum
     */
    private static void playerBowl(int frameNum, int playerNum) {

        System.out.println("Please enter player - " + game.getPlayer(playerNum).getName() + ", Frame - " + frameNum + ", bowl - 1, score:");
        int bowl1Score = scanner.nextInt();
        // if the bowl is valid
        if (game.isBowl1Valid(bowl1Score)) {
            // if the bowl is a strike and this is the last frame
            if(game.isStrike(bowl1Score) && frameNum == game.getMaxFrames()-1){
                System.out.println("You have achieved two extra bowls! - Enter Bowl 1 Score");
                int extraScore1 = scanner.nextInt();
                System.out.println("Enter Bowl 2 score");
                int extraScore2 = scanner.nextInt();
                // you achieve an extra bowl and the points are saved as extra points in the frame
                game.getPlayer(playerNum).extraBowl(bowl1Score, 0, extraScore1, extraScore2);
                game.updateScore(playerNum, frameNum);
            // if the bowl is a strike in a normal frame
            } else if (game.isStrike(bowl1Score)) {
                game.getPlayer(playerNum).bowl(bowl1Score, 0);
                game.updateScore(playerNum, frameNum);
            // else play second bowl
            } else {
                playerSecondBowl(frameNum, playerNum, bowl1Score);
            }
        } else {
            //else your bowl is invalid so try again
            System.out.println("Sorry your first bowl score has to be between 0 & 10 - Try Again");
            playerBowl(frameNum, playerNum);
        }
    }


    /**
     * Player second bowl allows the player to take a second bowl. Adds the score to the player.
     * @param frameNum
     * @param playerNum
     * @param bowl1Score
     */
    private static void playerSecondBowl(int frameNum, int playerNum, int bowl1Score) {
        System.out.println("Please enter player - " + game.getPlayer(playerNum).getName() + ", Frame - " + frameNum + ", bowl -  2, score:");
        int bowl2Score = scanner.nextInt();
        // if bowl is valid and its a spare and its the last frame, then you have achieved an extra bowl
        if(game.isBowl2Valid(bowl1Score, bowl2Score) && game.isSpare(bowl1Score, bowl2Score) && game.getMaxFrames()-1 == frameNum) {
            System.out.println("You have achieved an extra bowl! - Enter Bowl Score");
            int extraBowl = scanner.nextInt();
            ;game.getPlayer(playerNum).extraBowl(bowl1Score, bowl2Score, extraBowl, 0);
            game.updateScore(playerNum, frameNum);
        // else if the frame is normal and the bowl is valid. update the score afterwards to check previous frames for spares or strikes
        } else if (game.isBowl2Valid(bowl1Score, bowl2Score)) {
            game.getPlayer(playerNum).bowl(bowl1Score, bowl2Score);
            game.updateScore(playerNum, frameNum);
        // else the bowl is invalid so try again
        } else {
            System.out.println("Sorry your second bowl score is invalid - Try again");
            playerSecondBowl(frameNum, playerNum,  bowl1Score);
        }
    }


    /**
     * Iterates through the number of player specified. Requests a name for each player and creates them.
     * @param noOfPlayers
     */
    private static void createPlayers(int noOfPlayers) {
        for (int i = 0; i < noOfPlayers; i++) {
            System.out.print("Enter Player " + i + " name");
            game.newPlayer(scanner.next());
        }
    }

    /**
     * Checks whether the number of players is valid. If not requests number again. Recursive checking. Once player number is
     * satisfactory it creates the players.
     * @param noOfPlayers
     */
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
