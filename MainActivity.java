package com.example.tictactoe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    player representation
    //player 0 -x
    //player 1- O
    int activePlayer = 0;
    boolean gameActive = true;
    //gamestate
    int []gameState = {2,2,2,2,2,2,2,2,2};
    //state meaning
    //0 for X
    //1 for O
    //2 for null

    int winPos[][]={{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};


    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImg]==2){
            gameState[tappedImg]=activePlayer;
            img.setTranslationY(-1000f);
                if(activePlayer==0){
                    img.setImageResource(R.drawable.x);
                    activePlayer=1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's turn-Tap to play");
                }
                else{
                    img.setImageResource(R.drawable.o);
                    activePlayer=0;
                    TextView status = findViewById(R.id.status);
                    status.setText("X's turn- Tap to play");
                }
                img.animate().translationYBy(1000f).setDuration(300);



        }
        String winnerStr;
        for(int []winPosi:winPos){
            if(gameState[winPosi[0]]==gameState[winPosi[1]] && gameState[winPosi[1]]==gameState[winPosi[2]] && gameState[winPosi[0]]!=2){
                //someone has one
                if(gameState[winPosi[0]]==0){
                    winnerStr="X has won.Tap again to reset";
                    gameActive=false;
                }
                else{
                    winnerStr = "O has won. Tap again to reset";
                    gameActive=false;
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
    }
    public void gameReset(View view){
        activePlayer = 0;
        gameActive=true;
        for(int i=0;i< gameState.length;i++){
            gameState[i]=2;
        }
        playerTap(view);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's turn-Tap to play");

    }

    private TextView findViewById(int imageView2) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
