package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Player player = Player.PLAYERX;
    int turnCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) (findViewById(R.id.textView));
        t.setText("Player X's turn.");
    }
    public void buttonPress(View view){
        if (!(view instanceof NewButton) || ((NewButton) view).getOwner() != null || player == null) return;
        TextView t = (TextView) (findViewById(R.id.textView));
        if(player.equals(Player.PLAYERX)){
            ((NewButton)view).setOwner(Player.PLAYERX);
            ((NewButton)view).setText("X");
            if(checkWin()) {
                player = null;
                t.setText("Player X wins");
                //setContentView(R.layout.activity_main);
                return;
            }
            if(turnCount == 8){
                player = null;
                t.setText("Tie");
                return;
            }
            player = Player.PLAYERY;
            turnCount++;
            t.setText("Player Y's turn.");
        }
        else if (player.equals(Player.PLAYERY)){
            ((NewButton)view).setOwner(Player.PLAYERY);
            ((NewButton)view).setText("Y");
            if(checkWin()) {
                player = null;
                t.setText("Player Y wins");
                //setContentView(R.layout.activity_main);
                return;
            }
            if(turnCount == 8){
                player = null;
                t.setText("Tie");
                return;
            }
            player = Player.PLAYERX;
            turnCount++;
            t.setText("Player X's turn.");
        }
    }

    private boolean checkWin(){
        for(int i = 0; i < 3; i++) {
            //Check each row
            int c1 = this.getResources().getIdentifier("b"+(1+(3*i)), "id", this.getPackageName());
            int c2 = this.getResources().getIdentifier("b"+(2+(3*i)), "id", this.getPackageName());
            int c3 = this.getResources().getIdentifier("b"+(3+(3*i)), "id", this.getPackageName());
            if(((NewButton)findViewById(c1)).getOwner() == ((NewButton)findViewById(c2)).getOwner()
                    && ((NewButton)findViewById(c2)).getOwner() == ((NewButton)findViewById(c3)).getOwner()
                    && ((NewButton)findViewById((c3))).getOwner() != null) return true;
            //Check each column
            int row1 = this.getResources().getIdentifier("b"+(1+i), "id", this.getPackageName());
            int row2 = this.getResources().getIdentifier("b"+(4+i), "id", this.getPackageName());
            int row3 = this.getResources().getIdentifier("b"+(7+i), "id", this.getPackageName());
            if(((NewButton)findViewById(row1)).getOwner() == ((NewButton)findViewById(row2)).getOwner()
                    && ((NewButton)findViewById(row2)).getOwner() == ((NewButton)findViewById(row3)).getOwner()
                    && ((NewButton)findViewById((row3))).getOwner() != null) return true;
        }
        //Check diagonals
        if(((NewButton) findViewById(R.id.b1)).getOwner() == ((NewButton) findViewById(R.id.b5)).getOwner() &&
                ((NewButton) findViewById(R.id.b5)).getOwner() == ((NewButton) findViewById(R.id.b9)).getOwner()
                && (((NewButton) findViewById(R.id.b9)).getOwner() != null)) return true;
        if(((NewButton) findViewById(R.id.b3)).getOwner() == ((NewButton) findViewById(R.id.b5)).getOwner() &&
                ((NewButton) findViewById(R.id.b5)).getOwner() == ((NewButton) findViewById(R.id.b7)).getOwner()
                && (((NewButton) findViewById(R.id.b7)).getOwner() != null)) return true;
        return false;
    }

    public void restartGame(View view){
        turnCount = 0;
        player = Player.PLAYERX;
        TextView t = (TextView) (findViewById(R.id.textView));
        t.setText("Player X's turn.");
        //Reset ownership of grid
        for(int i = 1; i<10; i++){
            int b = this.getResources().getIdentifier("b"+i, "id", this.getPackageName());
            ((NewButton)findViewById(b)).clearOwnership();
            ((NewButton)findViewById(b)).setText("");
        }
    }
}
