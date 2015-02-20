package GameTests;

import org.junit.Before;
import org.junit.Test;
import Game.Game;

import static org.junit.Assert.*;

public class GameTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        game.newPlayer("Nat");
    }

    @Test
    public void testNewPlayer() throws Exception {
        assertEquals("Game has 1 player", "Nat", game.getPlayers().get(0).getName());
    }

    @Test
    public void testUpdateScore() throws Exception {
        game.getPlayer(0).bowl(10,0);
        game.getPlayer(0).bowl(10,0);
        game.updateScore(0,1);
        game.getPlayer(0).bowl(4,6);
        game.updateScore(0,2);
        game.getPlayer(0).bowl(2,2);
        game.updateScore(0,3);
        assertEquals("Total score is 60", 60, game.getPlayer(0).getTotalFromScoreCard());
    }

    @Test
    public void testUpdateScoreWith10Strikes() throws Exception {
        game.getPlayer(0).bowl(10,0);
        game.updateScore(0, 0);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 1);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 2);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 3);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 4);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 5);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 6);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 7);
        game.getPlayer(0).bowl(10, 0);
        game.updateScore(0, 8);
        game.getPlayer(0).extraBowl(10,0,10,10);
        game.updateScore(0,9);
        assertEquals("Total for player is 300", 300, game.getPlayer(0).getTotalFromScoreCard());

    }

    @Test
    public void testIsPreviousFrameSpare() throws Exception {
        game.getPlayer(0).bowl(5,5);
        game.getPlayer(0).bowl(2,3);
        assertEquals("Previous frame is spare", true, game.isPreviousFrameSpare(0,1));
    }

    @Test
    public void testUpdatePreviousFrameScore() throws Exception {
        game.getPlayer(0).bowl(3,4);
        game.getPlayer(0).bowl(2,2);
        game.updatePreviousFrameScore(2, 0, 1);
        assertEquals("New frame score is 9", 9, game.getPlayer(0).getFrame(0).getFrameTotalScorePlusExtra() );
    }

    @Test
    public void testIsPreviousFrameStrike() throws Exception {
        game.getPlayer(0).bowl(5,5);
        game.getPlayer(0).bowl(3,4);
        assertEquals("Previous frame is spare", true, game.isPreviousFrameSpare(0,1));
    }

    @Test
    public void testGetPreviousPreviousFrame() throws Exception {
        game.getPlayer(0).bowl(2,2);
        game.getPlayer(0).bowl(3,4);
        game.getPlayer(0).bowl(6,3);
        assertEquals("Previous frame first bowl is 2", 2, game.getPreviousPreviousFrame(0, 2).getFirstBowl());
    }

    @Test
    public void testGetCurrentFrame() throws Exception {
        game.getPlayer(0).bowl(2,2);
        assertEquals("Current frame first bowl is 2", 2, game.getCurrentFrame(0,0).getFirstBowl());
    }

    @Test
    public void testGetPreviousFrame() throws Exception {
        game.getPlayer(0).bowl(2,2);
        game.getPlayer(0).bowl(4,4);
        assertEquals("Previous frame first bowl is 2", 2, game.getPreviousFrame(0, 1).getFirstBowl());
    }

    @Test
    public void testGetPlayer() throws Exception {
        assertEquals("Player name is Nat", "Nat", game.getPlayer(0).getName());
    }

    @Test
    public void testIsBowl1Valid() throws Exception {
        assertEquals("Bowl 1 is not valid", false, game.isBowl1Valid(11));
        assertEquals("Bowl 1 is valid", true, game.isBowl1Valid(10));
    }

    @Test
    public void testIsBowl2Valid() throws Exception {
        assertEquals("Bowl 2 is not valid", false, game.isBowl2Valid(4,7));
        assertEquals("Bowl 2 is valid", true, game.isBowl2Valid(4,6));
    }

    @Test
    public void testIsNoOfPlayersValid() throws Exception {
        assertEquals("Num of players is not valid", false, game.isNoOfPlayersValid(7));
        assertEquals("Num of players is valid", true, game.isNoOfPlayersValid(6));
    }

    @Test
    public void testIsStrike() throws Exception {
        assertEquals("Bowl is not a strike", false, game.isStrike(3));
        assertEquals("Bowl is a strike", true, game.isStrike(10));
    }

    @Test
    public void testGetPlayers() throws Exception {
        assertEquals("Game has 1 player", 1, game.getPlayers().size());
    }

    @Test
    public void testGetMaxPlayers() throws Exception {
        assertEquals("max players is 6", 6, game.getMaxPlayers());
    }

    @Test
    public void testGetMaxFrames() throws Exception {
        assertEquals("Max frames is 10", 10, game.getMaxFrames());
    }

    @Test
    public void testGetMaxScore() throws Exception {
        assertEquals("Max Score is 10", 10, game.getMaxScore());
    }
}