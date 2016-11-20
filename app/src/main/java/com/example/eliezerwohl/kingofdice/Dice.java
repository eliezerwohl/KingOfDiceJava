
package com.example.eliezerwohl.kingofdice;

        import android.view.View;
        import android.widget.ImageButton;

/**
 * Created by Elie on 11/16/2016.
 */

public class Dice {
    private int diceCount = 6;
    private int currentCount = 6;

    public int getDiceCount() {
        return diceCount;
    }
    public int getCurrentCount(){
        return currentCount;
    }
    public void setCurrentCount(int currentCount){
        this.currentCount = currentCount;
    }

    public void displayDice(ImageButton image7, ImageButton image8, int diceCount){
        switch (diceCount) {
            case 6:
                image7.setVisibility(View.INVISIBLE);
                image8.setVisibility(View.INVISIBLE);
                image7.setAlpha(0.7f);
                image8.setAlpha(0.7f);
                break;
            case 7:
                image7.setVisibility(View.VISIBLE);
                image8.setVisibility(View.INVISIBLE);
                image8.setAlpha(0.7f);
                break;
            case 8:
                image7.setVisibility(View.VISIBLE);
                image8.setVisibility(View.VISIBLE);;
                break;
        }
    }

    public void setDiceCount(int view) {
        switch (view) {
            case R.id.radio6:
                this.diceCount = 6;
                break;
            case R.id.radio7:
                this.diceCount = 7;
                break;
            case R.id.radio8:
                this.diceCount = 8;
                break;
        }
    }
}
