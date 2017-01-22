package example.codeclan.com.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 21/01/2017.
 */

public class Deck {
    private ArrayList<Card> deck;

    public Deck(int num){
        this.deck = new ArrayList<Card>();

        for(int i = 0; i<num; i++){
           populateDeck();
        }
    }

    private void populateDeck(){

        for (int s = 0; s < 4; s++){
            for(int v = 0; v <13; v++){
                deck.add(new Card(Suit.values()[s], Value.values()[v]));
            }
        }
    }

    public void shuffle(){Collections.shuffle(deck);}
    public int deckSize(){return deck.size();}
    public Card topCard(){return deck.remove(0);}


    //for testing purpose
    public Card card15(){return deck.get(14);}
    public Card card102(){return deck.get(101);}
}
