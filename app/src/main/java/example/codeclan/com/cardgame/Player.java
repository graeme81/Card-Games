package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private Card card;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public void takeCard(Card card){
        hand.add(card);
    }

    public Card getCard(int i){
        return hand.get(i);
    }

    public void clearHand(){ hand.clear();}
    public String getName(){return name;}
    public int getHandSize(){return hand.size();}

}
