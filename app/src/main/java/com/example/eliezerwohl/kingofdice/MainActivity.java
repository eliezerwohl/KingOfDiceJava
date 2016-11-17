package com.example.eliezerwohl.kingofdice;


import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.button;
import static android.R.attr.x;
import static com.example.eliezerwohl.kingofdice.R.id.image1;
import static com.example.eliezerwohl.kingofdice.R.id.image2;
import static com.example.eliezerwohl.kingofdice.R.id.image3;
import static com.example.eliezerwohl.kingofdice.R.id.image4;
import static com.example.eliezerwohl.kingofdice.R.id.image5;
import static com.example.eliezerwohl.kingofdice.R.id.image6;
import static com.example.eliezerwohl.kingofdice.R.id.image7;
import static com.example.eliezerwohl.kingofdice.R.id.image8;
import static com.example.eliezerwohl.kingofdice.R.id.radio6;


public class MainActivity extends AppCompatActivity {
    private ImageButton image1;
     private ImageButton image2;
     private ImageButton image3;
     private ImageButton image4;
    private  ImageButton image5;
    private ImageButton image6;
    private  ImageButton image7;
    private  ImageButton image8;
    private  RadioButton radio6;

    private ImageButton[] buttonIDs = new ImageButton[]{image1, image2,  image3, image4, image5, image6, image7, image8};
    private int[] buttonId = new int[] {R.id.image1, R.id.image2,  R.id.image3, R.id.image4, R.id.image5, R.id.image6, R.id.image7, R.id.image8};
    private int[] savedImages = new int[8];

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        for (int i = 0; i < buttonId.length; i++){
//            savedImages[i] = buttonIDs[i].getResources().getDrawable( );
            ImageButton tempButton = (ImageButton) findViewById(buttonId[i]);
            String test =  (tempButton.getTag()).toString();
           Log.d("This", test) ;
            savedImages[i] = Integer.parseInt(test);
        }
        outState.putIntArray("IMAGES_DATA", savedImages);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedImages = savedInstanceState.getIntArray("IMAGES_DATA");
        for (int i = 0; i < buttonId.length; i++){
            ImageButton tempButton = (ImageButton) findViewById(buttonId[i]);
            tempButton.setImageResource(savedImages[i]);
            tempButton.setTag(Integer.toString(savedImages[i]));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageButton) findViewById(R.id.image1);
        image2 = (ImageButton) findViewById(R.id.image2);
        image3 = (ImageButton) findViewById(R.id.image3);
        image4 = (ImageButton) findViewById(R.id.image4);
        image5 = (ImageButton) findViewById(R.id.image5);
        image6 = (ImageButton) findViewById(R.id.image6);
        image7 = (ImageButton) findViewById(R.id.image7);
        image8 = (ImageButton) findViewById(R.id.image8);
        radio6 = (RadioButton) findViewById(R.id.radio6);

        Button rollButton = (Button) findViewById(R.id.rollButton);
        final Click click = new Click();
        final Dice dice = new Dice();

        final ImageButton[] buttonIDs = new ImageButton[]{image1, image2, image2, image3, image4, image5, image6, image7, image8};
        final int[] images = new int[]{R.drawable.heart, R.drawable.building, R.drawable.hand, R.drawable.lightning, R.drawable.skull, R.drawable.star};
        click.roll(images, buttonIDs);
        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dice.displayDice(image7, image8);
                click.roll(images, buttonIDs);
            }
        });
        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.reset(buttonIDs, radio6, image7, image8);
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int view) {
                dice.setDiceCount(radioGroup, view);
            }
        });
        View.OnClickListener buttonSelect = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (view.getAlpha() == 0.5f) {
                    view.setAlpha(1.0f);
                } else {
                    view.setAlpha(0.5f);
                }
            }
        };
        image1.setOnClickListener(buttonSelect);
        image2.setOnClickListener(buttonSelect);
        image3.setOnClickListener(buttonSelect);
        image4.setOnClickListener(buttonSelect);
        image5.setOnClickListener(buttonSelect);
        image6.setOnClickListener(buttonSelect);
        image7.setOnClickListener(buttonSelect);
        image8.setOnClickListener(buttonSelect);


    }
}
