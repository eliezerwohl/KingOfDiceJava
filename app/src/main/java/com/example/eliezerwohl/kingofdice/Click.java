package com.example.eliezerwohl.kingofdice;
import android.widget.ImageButton;

import java.util.Random;

/**
 * Created by Elie on 11/16/2016.
 */

public class Click {
    public void roll(int[] images, ImageButton[] buttonIDs){
        for(int i=0; i<buttonIDs.length; i++) {
            ImageButton temp = buttonIDs[i];

            if (temp.getAlpha() != 0.5f) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(images.length);
                temp.setImageResource(images[randomIndex]);
            }
        }
    }
}
