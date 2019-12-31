package com.example.tictactoe;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

public class NewButton extends AppCompatButton {
    private Player owner;
    public NewButton(Context context) {
        super(context);
        owner = null;
    }

    public NewButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        owner = null;
    }

    public NewButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        owner = null;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void clearOwnership(){
        owner = null;
    }
}
