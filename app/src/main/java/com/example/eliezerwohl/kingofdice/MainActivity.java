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


public class MainActivity extends AppCompatActivity {
    private ImageButton image1;
    private ImageButton image2;
    private ImageButton image3;
    private ImageButton image4;
    private ImageButton image5;
    private ImageButton image6;
    private ImageButton image7;
    private ImageButton image8;
    private RadioButton radio6;
    private Dice dice = new Dice();

    private ImageButton[] buttonIDs = new ImageButton[]{image1, image2, image3, image4, image5, image6, image7, image8};
    private int[] buttonId = new int[]{R.id.image1, R.id.image2, R.id.image3, R.id.image4, R.id.image5, R.id.image6, R.id.image7, R.id.image8};
    private int[] savedImages = new int[8];
    private float[] buttonAlpha = new float[8];

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        for (int i = 0; i < buttonId.length; i++) {
//            savedImages[i] = buttonIDs[i].getResources().getDrawable( );
            ImageButton tempButton = (ImageButton) findViewById(buttonId[i]);
            String test = (tempButton.getTag()).toString();
            buttonAlpha[i] = tempButton.getAlpha();
            savedImages[i] = Integer.parseInt(test);
        }
        outState.putIntArray("IMAGES_DATA", savedImages);
        outState.putFloatArray("ALPHA_DATA", buttonAlpha);
        outState.putInt("DICE_COUNT", dice.getCurrentCount());
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Click click = new Click();
        final int[] images = new int[]{R.drawable.heart, R.drawable.building, R.drawable.hand, R.drawable.lightning, R.drawable.skull, R.drawable.star};

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
        final ImageButton[] buttonIDs = new ImageButton[]{image1, image2, image2, image3, image4, image5, image6, image7, image8};

        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dice.displayDice(image7, image8, dice.getDiceCount());
                click.roll(images, buttonIDs);
                dice.setCurrentCount(dice.getDiceCount());
            }
        });
        Button reset = (Button) findViewById(R.id.reset);
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
                dice.setDiceCount(view);
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
        if (savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState);
            savedImages = savedInstanceState.getIntArray("IMAGES_DATA");
           buttonAlpha = savedInstanceState.getFloatArray("ALPHA_DATA");
            for (int i = 0; i < buttonId.length; i++) {
                ImageButton tempButton = (ImageButton) findViewById(buttonId[i]);
                tempButton.setAlpha(buttonAlpha[i]);
                tempButton.setImageResource(savedImages[i]);
                tempButton.setTag(Integer.toString(savedImages[i]));
            }
            dice.setCurrentCount(savedInstanceState.getInt("DICE_COUNT"));
            dice.displayDice(image7, image8, dice.getCurrentCount());
        }
        else {
            click.roll(images, buttonIDs);

        }
    }
}
