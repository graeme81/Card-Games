package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 24/01/2017.
 */

public class WarActivity extends AppCompatActivity {

    TextView dealerDeck;
    TextView dealerCard;
    TextView playerDeck;
    TextView playerCard;
    TextView winner;

    Button dealButton;
    Button warButton;
    Button reset;

    ArrayList<Card> pile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war);

        dealerDeck = (TextView)findViewById(R.id.txtDealerDeck);
        dealerCard = (TextView)findViewById(R.id.txtDealerCard);
        playerDeck = (TextView)findViewById(R.id.txtPlayerDeck);
        playerCard = (TextView)findViewById(R.id.txtPlayerCard);
        winner = (TextView)findViewById(R.id.txtWinner);


        dealButton = (Button) findViewById(R.id.btnDealWar);
        warButton = (Button) findViewById(R.id.btnWar);
        reset = (Button)findViewById(R.id.btnRestart);

        pile = new ArrayList<>();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("name");



        final Deck deck = new Deck(1);
        final Player dealer = new Player("Dealer");
        final Player player = new Player(name);
        final ArrayList<Player> players = new ArrayList<>();
        final Dealer deals = new Dealer();

        players.add(player);
        players.add(dealer);

        deck.shuffle();

        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.clearHand();
                dealer.clearHand();

                deals.dealCards(4,players,deck);

                dealerDeck.setText(dealer.getHandSize()+"\n Cards \n Remain");
                playerDeck.setText(player.getHandSize()+"\n Cards \n Remain");

                dealButton.setVisibility(View.INVISIBLE);
                warButton.setVisibility(View.VISIBLE);
            }
        });

        warButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Card card1 = player.playCard();
                Card card2 = dealer.playCard();


                dealerDeck.setText(dealer.getHandSize() + "\n Cards \n Remain");
                playerDeck.setText(player.getHandSize() + "\n Cards \n Remain");

                playerCard.setText(card1.getValue() + "\n of \n" + card1.getSuit());
                dealerCard.setText(card2.getValue() + "\n of \n" + card2.getSuit());

                if (card1.getValue().ordinal() + 1 > card2.getValue().ordinal() + 1) {
                    player.takeCard(card1);
                    player.takeCard(card2);
                    if (pile.size() != 0) {
                        for (int i = 0; i < pile.size(); i++) {
                            Card j = pile.get(i);
                            player.takeCard(j);
                        }
                        pile.clear();
                    }

                } else if (card1.getValue().ordinal() + 1 < card2.getValue().ordinal() + 1) {
                    dealer.takeCard(card1);
                    dealer.takeCard(card2);
                    if (pile.size() != 0) {
                        for (int i = 0; i < pile.size(); i++) {
                            Card j = pile.get(i);
                            player.takeCard(j);
                        }
                        pile.clear();
                    }

                } else {
                    pile.add(card1);
                    pile.add(card2);
                }

                if(player.getHandSize()== 0){
                    winner.setText("Dealer Wins :[");
                    reset.setVisibility(View.VISIBLE);
                    dealButton.setVisibility(View.INVISIBLE);
                    winner.setVisibility(View.VISIBLE);
                }

                if (dealer.getHandSize()==0){
                    winner.setText("You Win!");
                    reset.setVisibility(View.VISIBLE);
                    dealButton.setVisibility(View.INVISIBLE);
                    winner.setVisibility(View.VISIBLE);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                reset.setVisibility(View.INVISIBLE);
                dealButton.setVisibility(View.VISIBLE);
                dealerDeck.setText("Dealer Deck");
                playerDeck.setText("Player Deck");
                dealerCard.setText("");
                playerCard.setText("");

                winner.setVisibility(View.INVISIBLE);


            }


        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
