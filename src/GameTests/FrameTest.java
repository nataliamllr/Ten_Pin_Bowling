package GameTests;

import junit.framework.TestCase;
import org.junit.*;
import Game.Frame;

public class FrameTest extends TestCase {
    Frame frame;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        frame = new Frame(2,4,false);

    }

    @Test
    public void testGetFrameTotalScore() {
        assertEquals("Frame total score is: ", 6, frame.getFrameTotalScore());
    }

    @Test
    public void testGetFrameTotalScorePlusExtra() {
        frame.updateFrameScore(4);
       assertEquals("Frame Total Score: " , 10, frame.getFrameTotalScorePlusExtra());
    }

    @Test
    public void testUpdateFrameScore() {
        frame.updateFrameScore(3);
        assertEquals("Frame Total Score: ", 9, frame.getFrameTotalScorePlusExtra());
    }




}