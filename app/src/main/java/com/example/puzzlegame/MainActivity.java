package com.example.puzzlegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonStartGame;
    public static final int REQUEST_CODE = 1;
    private TextView textLastStep;
    private TextView textLastTime;
    private MyBase myBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartGame=findViewById(R.id.button_start_game);
        textLastStep = findViewById(R.id.text_last_step);
        textLastTime = findViewById(R.id.text_last_time);

        myBase = new MyBase(this);
        loadData();

        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,GameActivity.class), REQUEST_CODE);

            }
        });
    }

    private void loadData() {
        textLastStep.setText(String.valueOf(myBase.getLastStep()));
        int lastTime= myBase.getLastTime();
        int lastSecond = lastTime % 60;
        int lastHour = lastTime / 3600;
        int lastMinute = (lastTime - lastHour * 3600) / 60;
        textLastTime.setText(String.format("%02d:%02d:%02d", lastHour, lastMinute, lastSecond));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            textLastStep.setText(String.valueOf(myBase.getLastStep()));

            int lastTime= myBase.getLastTime();
            int lastSecond = lastTime % 60;
            int lastHour = lastTime / 3600;
            int lastMinute = (lastTime - lastHour * 3600) / 60;
            textLastTime.setText(String.format("%02d:%02d:%02d", lastHour, lastMinute, lastSecond));
        }
    }
}