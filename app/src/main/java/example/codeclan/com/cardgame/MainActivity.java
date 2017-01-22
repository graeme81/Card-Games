package example.codeclan.com.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button startButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton =(Button)findViewById(R.id.btnStart);
        intent = new Intent(MainActivity.this, MenuActivity.class);

    }

    public void onStartButtonPressed(View button){

        startActivity(intent);

    }


}
