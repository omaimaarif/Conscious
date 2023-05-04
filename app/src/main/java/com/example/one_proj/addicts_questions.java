package com.example.one_proj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class addicts_questions extends AppCompatActivity {
    private TextView optiona,optionb,optionc,optiond;
    private TextView questionNum,question,score;
    private TextView check_one,check_two;
    int current;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;
    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;

    private  addictAnswers[] questionBank= new addictAnswers[]{

            new addictAnswers(R.string.question_one,R.string.question_one_A,R.string.question_one_B,R.string.question_one_C,R.string.question_one_D,R.string.answer_one),
            new addictAnswers(R.string.question_two,R.string.question_two_A,R.string.question_two_B,R.string.question_two_C,R.string.question_two_D,R.string.answer_two),
            new addictAnswers(R.string.question_three,R.string.question_three_A,R.string.question_three_B,R.string.question_three_C,R.string.question_three_D,R.string.answer_three),
            new addictAnswers(R.string.question_four,R.string.question_four_A,R.string.question_four_B,R.string.question_four_C,R.string.question_four_D,R.string.answer_four),
            new addictAnswers(R.string.question_five,R.string.question_five_A,R.string.question_five_B,R.string.question_five_C,R.string.question_five_D,R.string.answer_five),
    };
    final int PROGTRESS_BAR= (int) Math.ceil(100/questionBank.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addicts_questions);

        optiona=findViewById(R.id.option_A);
        optionb=findViewById(R.id.option_B);
        optionc=findViewById(R.id.option_C);
        optiond=findViewById(R.id.option_D);

       question=findViewById(R.id.addicts_question);
       score=findViewById(R.id.score);
       questionNum=findViewById(R.id.questionNum);
       check_one=findViewById(R.id.selectoptions);
       check_two=findViewById(R.id.correct_answers);
       progressBar=findViewById(R.id.prograsss_bar);

       CurrentQuestion=questionBank[current].getQuestionid();
       question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[current].getOptionA();
        optiona.setText(CurrentOptionA);

        CurrentOptionB=questionBank[current].getOptionB();
        optionb.setText(CurrentOptionB);

        CurrentOptionC=questionBank[current].getOptionC();
        optionc.setText(CurrentOptionC);

        CurrentOptionD=questionBank[current].getOptionD();
        optiond.setText(CurrentOptionD);

        optiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(CurrentOptionA);
                update();
            }
        });
        optionb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);
                update();

            }
        });
        optionc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);
                update();

            }
        });
        optiond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionD);
                update();

            }
        });


    }


    private void checkAnswer(int userSelection) {

        int correctanswer = questionBank[current].getAnswerid();
        check_one.setText(userSelection);
        check_two.setText(correctanswer);
        String m = check_one.getText().toString().trim();
        String n = check_two.getText().toString().trim();

    }
    private void update() {
        current = (current + 1) % questionBank.length;
        if(current==0) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("ها قد إنتهينا");
            alert.setCancelable(false);
            alert.setMessage("ما زلت تستطيع إعادة الإختبار,إختر ما يناسبك ");
            alert.setPositiveButton("الخروج من الاختبار", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("إعادة الإختبار", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);

                   score.setText("Score" + mscore +"/" +questionBank.length);
                   questionNum.setText(qn + "/" + questionBank.length +"Question");
                }
            });

            alert.show();

        }

        CurrentQuestion=questionBank[current].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[current].getOptionA();
        optiona.setText(CurrentOptionA);

        CurrentOptionB=questionBank[current].getOptionB();
        optionb.setText(CurrentOptionB);

        CurrentOptionC=questionBank[current].getOptionC();
        optionc.setText(CurrentOptionC);

        CurrentOptionD=questionBank[current].getOptionD();
        optiond.setText(CurrentOptionD);
        qn=qn+1;
        if(qn<=questionBank.length){
            questionNum.setText(qn+"/"+questionBank.length+"Question");
        }
        score.setText("score "+mscore+"/"+questionBank.length);
        progressBar.incrementProgressBy(PROGTRESS_BAR);
    }
}