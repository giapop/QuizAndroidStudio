package com.example.tema3dam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tema3dam.util.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private List<Question> questions=new ArrayList<>();
    private TextView txtTotalQ, txtQuestion;
    private Button btn1,btn2,btn3,btnSubmit;
   private int indexFirstQuestion=0,index=0, totalCorrect=0;
    private String clickedAns="";
    private Fragment scoreFragment;
    int totalQ=0;
    private Button btnCorrect;
    Fragment correctFragment;
    TextView txtviewName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ConstraintLayout cLayout=findViewById(R.id.quizBackground);
        AnimationDrawable aDrawable=(AnimationDrawable) cLayout.getBackground();
        aDrawable.setEnterFadeDuration(2500);
        aDrawable.setExitFadeDuration(5000);
        aDrawable.start();


        txtviewName=findViewById(R.id.popescu_georgiana_txtview_hellouser);
        String[] as1={"Roșu","Alb","Rose"};
        String[] as2={"20000","4650","3030"};
        String[] as3={"Feteasca Alba","Feteasca Regala","Feteasca Neagră"};
        Question question1=new Question(getString(R.string.question1),as1,getString(R.string.correct1));
        Question question2=new Question(getString(R.string.question2),as2,getString(R.string.correct2));
        Question question3=new Question(getString(R.string.question3),as3,getString(R.string.correct3));
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        txtTotalQ=findViewById(R.id.popescu_georgiana_quiz_txtview_totalquestions);
        txtQuestion=findViewById(R.id.popescu_georgiana_quiz_txtview_question);
        btn1=findViewById(R.id.popescu_georgiana_quiz_btnAnswer1);
        btn2=findViewById(R.id.popescu_georgiana_quiz_btnAnswer2);
        btn3=findViewById(R.id.popescu_georgiana_quiz_btnAnswer3);
        btnSubmit=findViewById(R.id.popescu_georgiana_quiz_btnSubmit);
        totalQ=questions.size();
       // txtTotalQ.setText("Total "+totalQ);
        txtTotalQ.setText(getString(R.string.total_questions,totalQ));

        btn1.setOnClickListener(btnClick());
        btn2.setOnClickListener(btnClick());
        btn3.setOnClickListener(btnClick());
        btnSubmit.setOnClickListener(btnClick());

       setQuestionsQuiz();
       btnCorrect=findViewById(R.id.popescu_georgiana_quiz_btnCorrect);
        Toast.makeText(getApplicationContext(),R.string.termina_quiz,Toast.LENGTH_SHORT).show();

      Intent intent=getIntent();
      String nameReceived=intent.getStringExtra(UserActivity.NAME_KEY);
      txtviewName.setText(getString(R.string.name_user,nameReceived));
    }

    private void openCorrectFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.popescu_georgiana_quiz_framelayout,correctFragment)
                .commit();
    }

    private View.OnClickListener btnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.WHITE);
                //btnSubmit.setBackgroundColor(Color.RED);
            Button btnClicked= (Button) view;


            if(btnClicked.getId()==R.id.popescu_georgiana_quiz_btnSubmit )
            {
                if(clickedAns.equals(questions.get(indexFirstQuestion).getAnswerCorrect()))
                {
                    totalCorrect++;
                  //  Toast.makeText(getApplicationContext(),totalCorrect,Toast.LENGTH_SHORT).show();
                }

                indexFirstQuestion++;
                setQuestionsQuiz();

            }else
            {
                 clickedAns=btnClicked.getText().toString();
                btnClicked.setBackgroundColor(Color.CYAN);

            }

            }
        };
    }

    private void setQuestionsQuiz() {
        if(indexFirstQuestion==totalQ){
            finishQuiz();
            btnCorrect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(),CorrectActivity.class);
                    startActivity(intent);
                }
            });
        }
        txtQuestion.setText(getString(R.string.index_question,indexFirstQuestion+1,questions.get(indexFirstQuestion).getQuestion()));
        btn1.setText(questions.get(indexFirstQuestion).getAnswers()[0]);
        btn2.setText(questions.get(indexFirstQuestion).getAnswers()[1]);
        btn3.setText(questions.get(indexFirstQuestion).getAnswers()[2]);

    }

    private void finishQuiz() {
        scoreFragment=ScoreFragment.newInstance(totalCorrect,totalQ);
        openScoreFragment();
       // Toast.makeText(getApplicationContext(),totalCorrect,Toast.LENGTH_LONG).show();
        restartQuiz();



    }

    private void restartQuiz() {
        totalCorrect=0;
        indexFirstQuestion=0;

        setQuestionsQuiz();

       // Toast.makeText(getApplicationContext(),totalCorrect,Toast.LENGTH_LONG).show();

    }

    private void openScoreFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.popescu_georgiana_quiz_framelayout,scoreFragment)
                .commit();
    }


}