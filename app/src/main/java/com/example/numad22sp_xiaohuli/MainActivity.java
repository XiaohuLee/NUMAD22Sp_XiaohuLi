package com.example.numad22sp_xiaohuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_am = findViewById(R.id.button_aboutMe);

        button_am.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openAboutMeActivity();
            }
        });

        final Button button_cl = findViewById(R.id.button_click);
        button_cl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSixButtonsActivity();
            }
        });

        final Button button_lc = findViewById(R.id.button_collector);
        button_lc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openLinkCollectorActivity();
            }
        });
    }
    public void openSixButtonsActivity() {
        Intent intent = new Intent(this, SixButtonsActivity.class);
        startActivity(intent);
    }
    public void openAboutMeActivity() {
        Intent intent = new Intent(this, AboutMeActivity.class);
        startActivity(intent);
    }

    public void openLinkCollectorActivity() {
        Intent intent = new Intent(this, LinkCollectorActivity.class);
        startActivity(intent);
    }

}