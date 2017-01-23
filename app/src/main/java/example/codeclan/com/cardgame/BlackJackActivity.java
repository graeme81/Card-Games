package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 22/01/2017.
 */

public class BlackJackActivity extends AppCompatActivity{

    TextView dealerHand;
    TextView dealerCount;
    TextView playerHand;
    TextView playerCount;
    Button dealButton;
    Button hitButton;
    Button stayButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        dealerHand = (TextView) findViewById(R.id.dHand);
        dealerCount = (TextView) findViewById(R.id.dCount);
        playerHand = (TextView) findViewById(R.id.pHand);
        playerCount = (TextView) findViewById(R.id.pCount);
        dealButton = (Button) findViewById(R.id.btnDeal);
        hitButton = (Button) findViewById(R.id.btnHit);
        hitButton.setVisibility(View.INVISIBLE);
        stayButton = (Button) findViewById(R.id.btnStay);
        stayButton.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("name");

        //playerHand.setText(name);

        final Deck deck = new Deck(4);
        Card card;
        final Player dealer = new Player("Dealer");
        final Player player = new Player(name);
        final Score number = new Score(0);
        //int total1 = 0, total2 = 0;
        boolean playerTurn, dealerTurn;

        final ArrayList<Player> players = new ArrayList<>();
        final Dealer deals = new Dealer();
        boolean winner = false;

        deck.shuffle();

        players.add(player);
        players.add(dealer);

        dealButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                deals.dealCards(2,players,deck);
                String dout = dealer.getCard(0).getValue() + " of " + dealer.getCard(0).getSuit();

                int total = number.getScore(dealer.getCard(0).getValue().ordinal()+1);

                dealerHand.setText(dout);
                dealerCount.setText(""+total);

                String pout = player.getCard(0).getValue() + " of " + player.getCard(0).getSuit() + "\n" +
                        player.getCard(1).getValue() + " of " + player.getCard(1).getSuit();

                int a = number.getScore(player.getCard(0).getValue().ordinal()+1);
                int b = number.getScore(player.getCard(1).getValue().ordinal()+1);

                int total1 =  a + b;


                playerHand.setText(pout);
                playerCount.setText(""+total1);

                dealButton.setVisibility(View.INVISIBLE);
                hitButton.setVisibility(View.VISIBLE);
                stayButton.setVisibility(View.VISIBLE);
            }
        });

        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.takeCard(deck.topCard());
                String out = "";
                for(int i = 0; i < player.getHandSize();i++){
                    out = out + player.getCard(i).getValue()+" of "+player.getCard(i).getSuit()+"\n";
                }
                playerHand.setText(out);
            }
        });

        stayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

           }
        });



    }


}
