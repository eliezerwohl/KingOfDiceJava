package com.example.eliezerwohl.kingofdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.button;
import static android.R.attr.checked;
import static com.example.eliezerwohl.kingofdice.R.id.radio6;
import static com.example.eliezerwohl.kingofdice.R.id.radioGroup;

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
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int view) {
                switch (view) {
                    case R.id.radio6:
                        Log.d("SWITCH", "GOT 6");
                        break;
                    case R.id.radio7:
                        Log.d("SWITCH", "GOT 7");
                        break;
                    case R.id.radio8:
                        Log.d("SWITCH", "GOT 8");
                        break;
                }

            }
        });


    }
}
