package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class PlayerTest {

    Deck deck;
    Card card;
    Player player;

    @Before
    public void setUp() throws Exception {
        deck = new Deck(1);
        player = new Player("Joe");

        for(int i=0;i<2;i++){
            card = deck.topCard();
            player.takeCard(card);
        }

    }

    @Test
    public void testCardsDeltFromDeck() throws Exception {
        assertEquals(Suit.DIAMONDS,player.getCard(0).getSuit());
        assertEquals(Value.ACE,player.getCard(0).getValue());

        assertEquals(Suit.DIAMONDS,player.getCard(1).getSuit());
        assertEquals(Value.TWO, player.getCard(1).getValue());
    }

    @Test
    public void clearHand() throws Exception {
        player.clearHand();
        assertEquals(0, player.getHandSize());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Joe", player.getName());
    }

    @Test
    public void testGetHandSize() throws Exception {
        assertEquals(2, player.getHandSize());

    }

}