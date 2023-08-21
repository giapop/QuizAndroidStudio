package com.example.tema3dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CorrectActivity extends AppCompatActivity {
 private Button btnRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        ConstraintLayout cLayout=findViewById(R.id.correctBackground);
        AnimationDrawable aDrawable=(AnimationDrawable) cLayout.getBackground();
        aDrawable.setEnterFadeDuration(2500);
        aDrawable.setExitFadeDuration(5000);
        aDrawable.start();
        btnRestart=findViewById(R.id.popescu_georgiana_correct_btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent);
            }
        });
    }
}