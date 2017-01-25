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

public class FiveStudActivity extends AppCompatActivity {

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();
    String name = extras.getString("name");

    TextView c1,c2,c3,c4,c5;
    TextView p1,p2,p3,p4,p5;
    Button b1,b2,b3,b4,b5;
    Button deal, swap;

    Deck deck = new Deck(1);
    Player dealer = new Player("Dealer");
    Player player = new Player(name);
    ArrayList<Player>players = new ArrayList<>();
    Dealer deals = new Dealer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fivestud);

        
        //computer card views
        c1 = (TextView)findViewById(R.id.c1);
        c2 = (TextView)findViewById(R.id.c2);
        c3 = (TextView)findViewById(R.id.c3);
        c4 = (TextView)findViewById(R.id.c4);
        c5 = (TextView)findViewById(R.id.c5);
        //player card views
        p1 = (TextView)findViewById(R.id.p1);
        p2 = (TextView)findViewById(R.id.p2);
        p3 = (TextView)findViewById(R.id.p3);
        p4 = (TextView)findViewById(R.id.p4);
        p5 = (TextView)findViewById(R.id.p5);
        //swap buttons
        b1 = (Button)findViewById(R.id.btn1);
        b2 = (Button)findViewById(R.id.btn2);
        b3 = (Button)findViewById(R.id.btn3);
        b4 = (Button)findViewById(R.id.btn4);
        b5 = (Button)findViewById(R.id.btn5);

        deal =(Button)findViewById(R.id.btnDeal);
        swap = (Button)findViewById(R.id.btnSwap);

        deck.shuffle();

        players.add(player);
        players.add(dealer);

    }

    public void onDealButtonPressed(View button){

        player.clearHand();
        dealer.clearHand();

        deals.dealCards(5, players, deck);

        p1.setText(player.getCard(0).getValue() + "\n of\n" + player.getCard(0).getSuit());
        p2.setText(player.getCard(1).getValue() + "\n of\n" + player.getCard(1).getSuit());
        p3.setText(player.getCard(2).getValue() + "\n of\n" + player.getCard(2).getSuit());
        p4.setText(player.getCard(3).getValue() + "\n of\n" + player.getCard(3).getSuit());
        p5.setText(player.getCard(4).getValue() + "\n of\n" + player.getCard(4).getSuit());


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}