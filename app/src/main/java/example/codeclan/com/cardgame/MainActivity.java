package example.codeclan.com.cardgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button startButton;
    EditText nameEditText;
    Intent intent;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton =(Button)findViewById(R.id.btnStart);
        nameEditText = (EditText)findViewById(R.id.txtName);
        intent = new Intent(MainActivity.this, MenuActivity.class);

    }

    public void onStartButtonPressed(View button){

        name = nameEditText.getText().toString();
        intent.putExtra("name",name);

        startActivity(intent);

    }


}
