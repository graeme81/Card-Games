package example.codeclan.com.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class DealerTest {
    private Player player1 = new Player("Joe");
    private Player player2 = new Player("John");
    private ArrayList<Player> players = new ArrayList<Player>();
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck(1);

    @Before
    public void before(){
        players.add(player1);
        players.add(player2);

    }

    @Test
    public void testDealerWillDealCards() throws Exception {
        dealer.dealCards(2, players, deck);

        assertEquals(2, players.get(0).getHandSize());
        assertEquals(2, players.get(1).getHandSize());

    }

    @Test
    public void testHandsAreEmptied() throws Exception {

        dealer.dealCards(2,players,deck);
        dealer.binCards(players);

        assertEquals(0, players.get(0).getHandSize());
        assertEquals(0, players.get(1).getHandSize());
    }

}