package com.example.alarma;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText hourEditText;
    EditText minuteEditText;
    Button setButton;
    int hour;
    int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourEditText = findViewById(R.id.hourEditText);
        minuteEditText = findViewById(R.id.minuteEditText);
        setButton = findViewById(R.id.setButton);

        setButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (hourEditText.getText().toString().equals("")){
                    hour = 0;
                }else{
                    hour = Integer.parseInt(hourEditText.getText().toString());
                }
                if (minuteEditText.getText().toString().equals("")){
                    minute = 0;
                }else{
                    minute = Integer.parseInt(minuteEditText.getText().toString());
                }

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "New alarm");
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
                startActivity(intent);
            }
        });
    }
}
