package com.example.itachi.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=0; //for zero
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameover=false;
    public void gameLogic(View view){
        ImageView tappedimage=(ImageView) view;
        int tappedLocation= Integer.parseInt(view.getTag().toString());
        if(gamestate[tappedLocation]==2&& !gameover){
            gamestate[tappedLocation]=player;
            tappedimage.setTranslationY(-3000f);
            if (player == 0) {
                tappedimage.setImageResource(R.drawable.zero);
                player = 1;
            } else if (player == 1) {
                tappedimage.setImageResource(R.drawable.x);
                player = 0;
            }
            tappedimage.animate().translationYBy(3000f).setDuration(300);
        }
        for(int[]winningpostion: win){
            if(gamestate[winningpostion[0]]==gamestate[winningpostion[1]] &&gamestate[winningpostion[1]]==gamestate[winningpostion[2]]
                    &&gamestate[winningpostion[0]]!=2){
                if(player==0){
                    Toast.makeText(getApplicationContext(),"Cross is winner!",Toast.LENGTH_LONG).show();
                    gameover=true;
                }else if (player==1){
                    Toast.makeText(getApplicationContext(),"zero is winner!",Toast.LENGTH_LONG).show();
                    gameover=true;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
