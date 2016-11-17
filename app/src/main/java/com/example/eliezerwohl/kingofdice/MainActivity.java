package com.example.eliezerwohl.kingofdice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = (Button) findViewById(R.id.rollButton);
        final Click click = new Click();
        final Dice dice = new Dice();
        final ImageButton image1 = (ImageButton) findViewById(R.id.image1);
        final ImageButton image2 = (ImageButton) findViewById(R.id.image2);
        final ImageButton image3 = (ImageButton) findViewById(R.id.image3);
        ImageButton image4 = (ImageButton) findViewById(R.id.image4);
        ImageButton image5 = (ImageButton) findViewById(R.id.image5);
        ImageButton image6 = (ImageButton) findViewById(R.id.image6);
        final ImageButton image7 = (ImageButton) findViewById(R.id.image7);
        final RadioButton radio6 = (RadioButton) findViewById(R.id.radio6);
        final ImageButton image8 = (ImageButton) findViewById(R.id.image8);
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
