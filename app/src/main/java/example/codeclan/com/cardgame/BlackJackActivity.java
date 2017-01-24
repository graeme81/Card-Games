package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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
    TextView result;
    TextView dw;
    TextView pw;
    TextView playerHeading;
    Button dealButton;
    Button hitButton;
    Button stayButton;

    int dwins = 0, pwins = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        dealerHand = (TextView) findViewById(R.id.dHand);
        dealerCount = (TextView) findViewById(R.id.dCount);
        playerHand = (TextView) findViewById(R.id.pHand);
        playerCount = (TextView) findViewById(R.id.pCount);
        playerHeading = (TextView) findViewById((R.id.txtPlayer));

        result = (TextView) findViewById(R.id.txtResult);
        dw = (TextView)findViewById(R.id.txtDealerCount);
        pw = (TextView)findViewById(R.id.txtPlayerCount);

        dealButton = (Button) findViewById(R.id.btnDeal);
        hitButton = (Button) findViewById(R.id.btnHit);
        stayButton = (Button) findViewById(R.id.btnStay);

        hitButton.setVisibility(View.INVISIBLE);
        stayButton.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String name = extras.getString("name");

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
        playerHeading.setText(name+"s Cards:");

        dealButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                player.clearHand();
                dealer.clearHand();

                deals.dealCards(2, players, deck);
                String dout = dealer.getCard(0).getValue() + " of " + dealer.getCard(0).getSuit();

                int dnum = number.getScore(dealer.getCard(0).getValue().ordinal() + 1);

                dealerHand.setText(dout);
                dealerCount.setText("" + dnum);

                String pout = player.getCard(0).getValue() + " of " + player.getCard(0).getSuit() + "\n" +
                        player.getCard(1).getValue() + " of " + player.getCard(1).getSuit();

                int pnum = 0;
                for (int i = 0; i < player.getHandSize(); i++) {
                    pnum = pnum + number.getScore(player.getCard(i).getValue().ordinal() + 1);
                }

                if (pnum == 21) {
                    playerHand.setText(pout);
                    playerCount.setText("" + pnum);
                    result.setText("BLACKJACK!");
                    pwins++;
                    pw.setText("Player Wins: " + pwins);

                } else {
                    playerHand.setText(pout);
                    playerCount.setText("" + pnum);

                    dealButton.setVisibility(View.INVISIBLE);
                    hitButton.setVisibility(View.VISIBLE);
                    stayButton.setVisibility(View.VISIBLE);
                    result.setVisibility(View.INVISIBLE);
                }
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

                int num = getCount(player);
                int aces = countAces(player);
//                for(int i = 0; i < player.getHandSize(); i++){
//                    num = num + number.getScore(player.getCard(i).getValue().ordinal()+1);
//                }

                while(num > 21 && aces !=0){
                    num = num -10;
                    aces --;
                }

                playerCount.setText(""+num);

                if (num == 21)
                    stayButton.performClick();
                    // dealer to go
                else if(num >21 && aces == 0){

                    result.setText("Bust, Dealer Wins");
                    dwins ++;
                    dw.setText("Dealer Wins: "+dwins);

                    result.setVisibility(View.VISIBLE);
                    dealButton.setVisibility(View.VISIBLE);
                    hitButton.setVisibility(View.INVISIBLE);
                    stayButton.setVisibility(View.INVISIBLE);
                }

            }
        });

        stayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dout = dealer.getCard(0).getValue() + " of " + dealer.getCard(0).getSuit() + "\n" +
                        dealer.getCard(1).getValue() + " of " + dealer.getCard(1).getSuit();

                dealerHand.setText(dout);

                int num = getCount(dealer);
                int aces = countAces(dealer);
//                for(int i = 0; i < dealer.getHandSize(); i++){
//                    num = num + number.getScore(dealer.getCard(i).getValue().ordinal()+1);
//                }
                while(num > 21 && aces !=0){
                    num = num -10;
                    aces --;
                }

                dealerCount.setText(""+num);

                while (num < 17){
                    dealer.takeCard(deck.topCard());
                    String out = "";
                    for(int i = 0; i <  dealer.getHandSize();i++){
                        out = out + dealer.getCard(i).getValue()+" of "+ dealer.getCard(i).getSuit()+"\n";
                    }
                    dealerHand.setText(out);

                    num = getCount(dealer);
                    aces = countAces(dealer);
//                    for(int i = 0; i < dealer.getHandSize(); i++){
//                        num = num + number.getScore(dealer.getCard(i).getValue().ordinal()+1);
//                    }
                    while(num > 21 && aces !=0){
                        num = num -10;
                        aces --;
                    }

                    int num2 = num;
                    dealerCount.setText(""+num2);

//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

                int total1 = getCount(player);
                int total2 = getCount(dealer);

                if (total2 > 21){
                    result.setText("Dealer Bust!");
                    pwins++;
                    pw.setText("Player Wins: "+pwins);
                }
                else if (total1 == total2){
                    result.setText("PUSH!");
                }
                else if (total1 > total2){
                    result.setText("You Win!");
                    pwins++;
                    pw.setText("Player Wins: "+pwins);
                }
                else{
                    result.setText("Dealer Wins");
                    dwins++;
                    dw.setText("Dealer Wins: "+dwins);
                }

                result.setVisibility(View.VISIBLE);
                dealButton.setVisibility(View.VISIBLE);
                hitButton.setVisibility(View.INVISIBLE);
                stayButton.setVisibility(View.INVISIBLE);
           }
        });



    }


    public int getCount(Player player){
        Score number = new Score(0);
        int num = 0;

        for(int i = 0; i < player.getHandSize(); i++){
             num = num + number.getScore(player.getCard(i).getValue().ordinal()+1);
        }
        return num;
    }


    public int countAces(Player player){
        Score number = new Score(0);
        int num = 0,aces =0;

        for(int i=0;i<player.getHandSize();i++){
            num = number.getScore(player.getCard(i).getValue().ordinal()+1);
            if(num == 11){
                aces++;
            }
        }
        return aces;
    }


}
