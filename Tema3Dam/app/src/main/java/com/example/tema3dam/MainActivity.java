package com.example.tema3dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tema3dam.util.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Fragment detailFragment;
    private Button btnDetalii;
    private Button btnNext;
    private List<Question> questions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout cLayout=findViewById(R.id.mainBackground);
        AnimationDrawable aDrawable=(AnimationDrawable) cLayout.getBackground();
        aDrawable.setEnterFadeDuration(2500);
        aDrawable.setExitFadeDuration(5000);
        aDrawable.start();

        btnDetalii=findViewById(R.id.popescu_georgiana_btnDetalii);
        btnDetalii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             detailFragment=new DetailFragment();
             openDetailFragment();
            }
        });

        btnNext=findViewById(R.id.popescu_georgiana_btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openDetailFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.popescu_georgiana_framelayout,detailFragment)
                .commit();
    }
}