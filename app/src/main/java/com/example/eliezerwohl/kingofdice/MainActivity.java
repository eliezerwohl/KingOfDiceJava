package com.example.eliezerwohl.kingofdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.button;
import static android.R.attr.id;
import static android.R.attr.tag;

public class MainActivity extends AppCompatActivity {
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio6:
                if (checked)
                    Log.d("SWITCH", "GOT 6");
                break;
            case R.id.radio7:
                if (checked)
                    Log.d("SWITCH", "GOT 7");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = (Button) findViewById(R.id.rollButton);


      final  ImageButton image1 = (ImageButton) findViewById(R.id.image1);
       final ImageButton image2 = (ImageButton) findViewById(R.id.image2);
        final ImageButton image3 = (ImageButton) findViewById(R.id.image3);
        ImageButton image4 = (ImageButton) findViewById(R.id.image4);
        ImageButton image5 = (ImageButton) findViewById(R.id.image5);
        ImageButton image6 = (ImageButton) findViewById(R.id.image6);
       final ImageButton image7 = (ImageButton) findViewById(R.id.image7);
       final ImageButton image8 = (ImageButton) findViewById(R.id.image8);
       final ImageButton[] buttonIDs = new ImageButton[] {image1, image2,image2,image3,image4, image5, image6, image7, image8 };
        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i=0; i<buttonIDs.length; i++) {
                   ImageButton temp = buttonIDs[i];
                    if (temp.getAlpha() == 0.5f){

                    }
                    else {
                        temp.setImageResource(R.drawable.building);
                    }


                }
            }
        });
//        for(int i=0; i<buttonIDs.length; i++) {
//            Button b = (Button) findViewById(buttonIDs[i]);
//            b.setOnClickListener(this);
//        }

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int view) {
                switch (view) {
                    case R.id.radio6:
                        image7.setVisibility(View.INVISIBLE);
                        image8.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radio7:
                        Log.d("SWITCH", "GOT 7");
                        image7.setVisibility(View.VISIBLE);
                        image8.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radio8:
                        image7.setVisibility(View.VISIBLE);
                        image8.setVisibility(View.VISIBLE);;
                        break;
                }

            }
        });
        View.OnClickListener buttonSelect = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if(view.getAlpha() == 0.5f){
                    view.setAlpha(1.0f);
                }
                else{
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
