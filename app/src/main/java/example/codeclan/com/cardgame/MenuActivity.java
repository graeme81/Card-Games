package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 22/01/2017.
 */

public class MenuActivity extends AppCompatActivity {

    Button blackJackButton;
    Button warButton;
    Button pokerButton;
    Intent intent;
    String name;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        name = extras.getString("name");

        blackJackButton = (Button)findViewById(R.id.btnBlackJack);
        warButton = (Button)findViewById(R.id.btnWar);
        pokerButton = (Button)findViewById(R.id.btnPoker);
        welcome = (TextView)findViewById(R.id.txtWelcome);

        welcome.setText("Hey "+name+ ",\n Please choose a game." );

    }

    public void onBlackJackButtonPressed(View Button){

        intent = new Intent(MenuActivity.this, BlackJackActivity.class);
        intent.putExtra("name",name);

        startActivity(intent);
    }

    public void onWarButtonPressed(View Button){

        intent = new Intent(MenuActivity.this, WarActivity.class);
        intent.putExtra("name",name);

        startActivity(intent);
    }

    public void onPokerButtonPressed(View Button){

        intent = new Intent(MenuActivity.this, FiveStudActivity.class);
        intent.putExtra("name",name);

        startActivity(intent);
    }
}
