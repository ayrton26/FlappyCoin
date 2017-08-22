package com.example.ayrton.flappycoin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ayrton.flappycoin.engine.Game;

public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game(this);
        FrameLayout frameLayout = findViewById(R.id.container);
        frameLayout.addView(game);

    }

    @Override
    public void onResume(){
        super.onResume();
        game.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        game.end();
    }
}
