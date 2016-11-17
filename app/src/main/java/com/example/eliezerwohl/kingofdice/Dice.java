
package com.example.eliezerwohl.kingofdice;

        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.RadioGroup;

        import static com.example.eliezerwohl.kingofdice.R.id.image7;
        import static com.example.eliezerwohl.kingofdice.R.id.image8;

/**
 * Created by Elie on 11/16/2016.
 */

public class Dice {
    private int diceCount = 6;

    public int getDiceCount() {
        return diceCount;
    }

    public void displayDice(ImageButton image7, ImageButton image8){
        switch (this.diceCount) {
            case 6:
                image7.setVisibility(View.INVISIBLE);
                image8.setVisibility(View.INVISIBLE);
                break;
            case 7:
                image7.setVisibility(View.VISIBLE);
                image8.setVisibility(View.INVISIBLE);
                break;
            case 8:
                image7.setVisibility(View.VISIBLE);
                image8.setVisibility(View.VISIBLE);;
                break;
        }
    }



    public void setDiceCount(RadioGroup radioGroup, int view) {
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
