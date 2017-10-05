package com.example.akirisurely.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
TextView txt1;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "MyData";
    String intName = "MyInt";
    int defaultInt = 0;
    int hiScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    button = (Button) findViewById(R.id.button);
        txt1= (TextView) findViewById(R.id.textHiScore);
        //load our high score or in unavailable, our default of 0
        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        editor = prefs.edit();


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
             Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        hiScore = prefs.getInt(intName, defaultInt);
        txt1.setText("Score: " + hiScore);
    }

}
