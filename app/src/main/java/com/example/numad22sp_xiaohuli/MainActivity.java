package com.example.numad22sp_xiaohuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_am = findViewById(R.id.button_aboutMe);

        button_am.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openMainActivity3();
                //Context context = getApplicationContext();
                //CharSequence text = "Xiaohu Li li.xiaohu3@northeastern.edu";
                //int duration = Toast.LENGTH_SHORT;
                //Toast.makeText(context, text, duration).show();
            }
        });

        final Button button_cl = findViewById(R.id.button_click);
        button_cl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openMainActivity2();
            }
        });

        final Button button_lc = findViewById(R.id.button_collector);
        button_lc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openMainActivity4();
            }
        });
    }
    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openMainActivity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void openMainActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

}