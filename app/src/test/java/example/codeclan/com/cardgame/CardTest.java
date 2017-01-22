package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class CardTest {
    Card card;
    @Before
    public void before(){
        card = new Card(Suit.CLUBS, Value.FOUR);
    }
    @Test
    public void getValue() throws Exception {
        assertEquals(Value.FOUR, card.getValue());
    }

    @Test
    public void getSuit() throws Exception {
        assertEquals(Suit.CLUBS, card.getSuit());

    }

}