package example.codeclan.com.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 22/01/2017.
 */

public class MenuActivity extends AppCompatActivity {

    Button blackJackButton;
    Intent intent;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        name = extras.getString("name");

        blackJackButton = (Button) findViewById(R.id.btnBlackJack);

    }

    public void onBlackJackButtonPressed(View Button){

        intent = new Intent(MenuActivity.this, BlackJackActivity.class);
        intent.putExtra("name",name);

        startActivity(intent);
    }
}
