package example.codeclan.com.cardgame;

/**
 * Created by user on 21/01/2017.
 */

public class Card {

    private  Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public Value getValue(){return this.value;}
    public Suit getSuit(){return this.suit;}

}
