package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class DeckTest {

    Deck deck;
    Card card;

    @Before
    public void setUp() throws Exception {
        deck = new Deck(4);
    }

    @Test
    public void deckSize() throws Exception {
        assertEquals(208, deck.deckSize());
    }

    @Test
    public void testCardIsTakenFromTheDeck() throws Exception {
        for(int i =0; i<4; i++){
            card = deck.topCard();
        }
        assertEquals(204,deck.deckSize());
    }

    @Test
    public void testFirstCardIsAceOfDiamonds() throws Exception{
        card = deck.topCard();
        assertEquals(Suit.DIAMONDS, card.getSuit());
        assertEquals(Value.ACE, card.getValue());
    }

    @Test
    public void testCard15IsTheTwoOfClubs() throws Exception {
        card = deck.card15();
        assertEquals(Suit.CLUBS, card.getSuit());
        assertEquals(Value.TWO, card.getValue());
    }

    @Test
    public void testCard102IsTheJackOfSpades() throws Exception {
        card = deck.card102();
        assertEquals(Suit.SPADES, card.getSuit());
        assertEquals(Value.JACK, card.getValue());
    }

    @Test
    public void testCanGetAnIntegerValue() throws Exception{
        card = deck.card15();
        assertEquals(2,card.getValue().ordinal()+1);
    }

}