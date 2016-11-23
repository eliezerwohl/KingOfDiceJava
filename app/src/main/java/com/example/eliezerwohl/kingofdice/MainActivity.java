package com.example.eliezerwohl.kingofdice;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import static com.example.eliezerwohl.kingofdice.R.id.image1;
import static com.example.eliezerwohl.kingofdice.R.id.image2;
import static com.example.eliezerwohl.kingofdice.R.id.image3;
import static com.example.eliezerwohl.kingofdice.R.id.image4;
import static com.example.eliezerwohl.kingofdice.R.id.image5;
import static com.example.eliezerwohl.kingofdice.R.id.image6;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    @Override
    public void onSensorChanged(SensorEvent event) {
        //nothing here
    }
    private ImageButton image7;
    private ImageButton image8;
    private RadioButton radio6;
    private Dice dice = new Dice();
    private int[] buttonId = new int[]{image1, image2, image3, image4, image5, image6, R.id.image7, R.id.image8};
    private int[] savedImages = new int[8];
    private float[] buttonAlpha = new float[8];
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private int[] diceImages = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six };
    private int[] kingImages = new int[]{R.drawable.heart, R.drawable.building, R.drawable.hand, R.drawable.lightning, R.drawable.skull, R.drawable.star};
    private int[] currentArray;
    private Click click = new Click();
    private  ImageButton[] buttonIDs;

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        for (int i = 0; i < buttonId.length; i++) {
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
        currentArray = kingImages;
        ImageButton  image1 = (ImageButton) findViewById(R.id.image1);
        ImageButton  image2 = (ImageButton) findViewById(R.id.image2);
        ImageButton  image3 = (ImageButton) findViewById(R.id.image3);
        ImageButton  image4 = (ImageButton) findViewById(R.id.image4);
        ImageButton  image5 = (ImageButton) findViewById(R.id.image5);
        ImageButton  image6 = (ImageButton) findViewById(R.id.image6);
        image7 = (ImageButton) findViewById(R.id.image7);
        image8 = (ImageButton) findViewById(R.id.image8);
        radio6 = (RadioButton) findViewById(R.id.radio6);

        Button rollButton = (Button) findViewById(R.id.rollButton);
         buttonIDs = new ImageButton[]{image1, image2, image2, image3, image4, image5, image6, image7, image8};

        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rollDice(click, currentArray, buttonIDs);
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
                if (view.getAlpha() == 0.7f) {
                    view.setAlpha(1.0f);
                } else {
                    view.setAlpha(0.7f);
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
            click.roll(currentArray, buttonIDs);
        }
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                rollDice(click, currentArray, buttonIDs);
            }
        });
    }
    @Override
    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void rollDice(Click click, int[] currentArray, ImageButton[] buttonIDs) {
        dice.displayDice(image7, image8, dice.getDiceCount());
        click.roll(currentArray, buttonIDs);
        dice.setCurrentCount(dice.getDiceCount());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String selected;
        if (id == R.id.kingDice){
            currentArray = kingImages;
            click.reset(buttonIDs);
            rollDice(click, currentArray, buttonIDs);

        }
        else{
            currentArray = diceImages;
            click.reset(buttonIDs);
            rollDice(click, currentArray, buttonIDs);
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }
    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);
    }

}
