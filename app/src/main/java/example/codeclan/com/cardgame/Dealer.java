package example.codeclan.com.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class Dealer {

    public void dealCards(int num, ArrayList<Player> players, Deck deck){
        for (int i = 0; i<num; i++){
            for(Player player:players){
                Card card = deck.topCard();
                player.takeCard(card);
            }
        }
    }

    public void binCards(ArrayList<Player> players) {
        for (Player player : players) {
            player.clearHand();
        }
    }
}
