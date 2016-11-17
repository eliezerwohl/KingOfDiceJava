package com.example.eliezerwohl.kingofdice;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

import java.util.Random;

/**
 * Created by Elie on 11/16/2016.
 */

public class Click {
    public void roll(int[] images, ImageButton[] buttonIDs){
        for(int i=0; i<buttonIDs.length; i++) {
            ImageButton temp = buttonIDs[i];

            if (temp.getAlpha() != 1.0f) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(images.length);
                temp.setImageResource(images[randomIndex]);
                temp.setTag(Integer.toString(images[randomIndex]));
            }
        }
    }
    public void reset(ImageButton[] buttonIDs, RadioButton radio6, ImageButton image7, ImageButton image8){
        for(int i=0; i<buttonIDs.length; i++) {
            ImageButton temp = buttonIDs[i];
            temp.setAlpha(0.7f);
        }
       radio6.setChecked(true);
        image7.setAlpha(0.7f);
        image8.setAlpha(0.7f);
        image7.setVisibility(View.INVISIBLE);
        image8.setVisibility(View.INVISIBLE);
    }
}
