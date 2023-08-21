package com.example.tema3dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UserActivity extends AppCompatActivity {

    public static final String NAME_KEY = "NAME_KEY";
    private Button btnStart;
    //private TextInputEditText tyeName;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ConstraintLayout cLayout=findViewById(R.id.userBackground);
        AnimationDrawable aDrawable=(AnimationDrawable) cLayout.getBackground();
        aDrawable.setEnterFadeDuration(2500);
        aDrawable.setExitFadeDuration(5000);
        aDrawable.start();
        editTextName=findViewById(R.id.popescu_georgiana_user_edittxt_name);

        btnStart=findViewById(R.id.popescu_georgiana_btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),QuizActivity.class);
                if(existaNume())
                {
                    intent.putExtra(NAME_KEY,editTextName.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }

    private boolean existaNume() {
        if(editTextName.getText().toString().trim().isEmpty()||editTextName.getText()==null)
        {
            Toast.makeText(getApplicationContext(), R.string.error_message,Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}