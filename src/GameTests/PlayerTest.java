package GameTests;

import org.junit.Before;
import org.junit.Test;
import Game.Player;
import Game.Frame;

import static org.junit.Assert.*;

public class PlayerTest {

    Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("Nat");
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Name is: ", "Nat", player.getName());
    }

    @Test
    public void testGetScoreCard() throws Exception {
        Frame frame = new Frame(3,7);
        player.getScoreCard().add(frame);
        assertEquals("Player has one frame", 1, player.getScoreCard().size());
    }

    @Test
    public void testBowl() throws Exception {
        player.bowl(5,4);
        assertEquals("PLayer has bowled one frame", 1, player.getScoreCard().size());
    }

    @Test
    public void testGetTotalFromScoreCard() throws Exception {
        player.bowl(3,3);
        player.bowl(2,2);
        assertEquals("Total of frames is ", 10, player.getTotalFromScoreCard());
    }

    @Test
    public void testGetFrame() throws Exception {
        player.bowl(1,1);
        assertEquals("Frame has 1 point for firstbowl", 1, player.getFrame(0).getFirstBowl());
    }
}