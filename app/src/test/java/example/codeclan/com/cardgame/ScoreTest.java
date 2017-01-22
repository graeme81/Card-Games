package example.codeclan.com.cardgame;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 22/01/2017.
 */
public class ScoreTest {

    Score score;

    @Test
    public void canReturnNoChangeNumber(){
        score = new Score(0);
        assertEquals(4,score.getScore(4));
    }

    @Test
    public void canReturnAcesAs11(){
        score = new Score(0);
        assertEquals(11,score.getScore(1));
    }

    @Test
    public void canReturnRoyalsAs10(){
        score = new Score(0);
        assertEquals(10,score.getScore(12));
    }



}