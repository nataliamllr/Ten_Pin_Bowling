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
    }

    @Test
    public void testNewPlayer() throws Exception {
        game.newPlayer("Nat");
        assertEquals("Game has 1 player", "Nat", game.getPlayers().get(0).getName());
    }

    @Test
    public void testUpdateScore() throws Exception {
        game.newPlayer("Nat");
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
    public void testIsPreviousFrameSpare() throws Exception {
        game.newPlayer("Nat");
        game.getPlayer(0).bowl(5,5);
        game.getPlayer(0).bowl(2,3);
        assertEquals("Previous frame is spare", true, game.isPreviousFrameSpare(0,1));
    }

    @Test
    public void testUpdatePreviousFrameScore() throws Exception {

    }

    @Test
    public void testIsPreviousFrameStrike() throws Exception {

    }

    @Test
    public void testGetPreviousPreviousFrame() throws Exception {

    }

    @Test
    public void testGetCurrentFrame() throws Exception {

    }

    @Test
    public void testGetPreviousFrame() throws Exception {

    }

    @Test
    public void testPrintFullScoreCard() throws Exception {

    }

    @Test
    public void testGetPlayer() throws Exception {

    }

    @Test
    public void testIsBowl1Valid() throws Exception {

    }

    @Test
    public void testIsBowl2Valid() throws Exception {

    }

    @Test
    public void testIsNoOfPlayersValid() throws Exception {

    }

    @Test
    public void testIsStrike() throws Exception {

    }

    @Test
    public void testIsStrikeOrSpare() throws Exception {

    }

    @Test
    public void testGetPlayers() throws Exception {

    }

    @Test
    public void testGetMaxPlayers() throws Exception {

    }

    @Test
    public void testGetMaxFrames() throws Exception {

    }

    @Test
    public void testGetMaxScore() throws Exception {

    }
}