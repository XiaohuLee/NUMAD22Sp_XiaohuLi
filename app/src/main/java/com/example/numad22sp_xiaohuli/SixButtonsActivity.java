package com.example.numad22sp_xiaohuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SixButtonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_buttons);

        changeText();
    }

    private void changeText() {
        final String[] letters = {"Pressed: A", "Pressed: B", "Pressed: C", "Pressed: D", "Pressed: E", "Pressed: F"};
        final TextView changeText = (TextView) findViewById(R.id.textView2);
        Button Button_a = (Button) findViewById(R.id.button_a);
        Button Button_b = (Button) findViewById(R.id.button_b);
        Button Button_c = (Button) findViewById(R.id.button_c);
        Button Button_d = (Button) findViewById(R.id.button_d);
        Button Button_e = (Button) findViewById(R.id.button_e);
        Button Button_f = (Button) findViewById(R.id.button_f);
        Button_a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                changeText.setText(letters[0]);
            }
        });
        Button_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                changeText.setText(letters[1]);
            }
        });
        Button_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                changeText.setText(letters[2]);
            }
        });
        Button_d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                changeText.setText(letters[3]);
            }
        });
        Button_e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                changeText.setText(letters[4]);
            }
        });
        Button_f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                changeText.setText(letters[5]);
            }
        });
    }
}