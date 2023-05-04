package com.example.one_proj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class questions extends AppCompatActivity {

    private TextView optionA, optionB, optionC, optionD;
    private TextView questionnumber, score, question;
    private TextView check1, check2;
    int mscore = 0;
    int qn = 1;
    int currentIndex;
    ProgressBar progressBar;
    int currentquestion, currentoptionA, currentoptionB, currentoptionC, currentoptionD;


    private answerclass[] questionBank = new answerclass[]
            {

                    new answerclass(R.string.question1, R.string.question1_A, R.string.question1_B, R.string.question1_C, R.string.question1_D, R.string.answer_1),
                    new answerclass(R.string.question2, R.string.question2_2A, R.string.question2_2B, R.string.question2_2C, R.string.question2_2D, R.string.answer_2),
                    new answerclass(R.string.question3, R.string.question3_3A, R.string.question3_3B, R.string.question3_3C, R.string.question3_3D, R.string.answer_3),
                    new answerclass(R.string.question4, R.string.question4_4A, R.string.question4_4B, R.string.question4_4C, R.string.question4_4D, R.string.answer_4),
                    new answerclass(R.string.question5, R.string.question5_5A, R.string.question5_5B, R.string.question5_5C, R.string.question5_5D, R.string.answer_5),
            };
    final int prograss = (int) Math.ceil(100 / questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        questionnumber = findViewById(R.id.questionNumber);

        check1=findViewById(R.id.selectoption);
        check2=findViewById(R.id.correctanswer);
        progressBar=findViewById(R.id.prograss_bar);

        currentquestion = questionBank[currentIndex].getQuestionid();
        question.setText(currentquestion);
        currentoptionA = questionBank[currentIndex].getOptionA();
        optionA.setText(currentoptionA);
        currentoptionB = questionBank[currentIndex].getOptionB();
        optionB.setText(currentoptionB);

        currentoptionC = questionBank[currentIndex].getOptionC();
        optionC.setText(currentoptionC);

        currentoptionD = questionBank[currentIndex].getOptionD();
        optionD.setText(currentoptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentoptionA);
                updateQuestion();

            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentoptionB);
                updateQuestion();
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentoptionC);
                updateQuestion();
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(currentoptionD);
                updateQuestion();
            }
        });


    }

    private void checkAnswer(int userselction) {


        int correctanswer=questionBank[currentIndex].getAnswerid();
        check1.setText(userselction);
        check2.setText(correctanswer);
        String m=check1.getText().toString().trim();
        String n=check2.getText().toString().trim();
    }

    @SuppressLint("SetTextI18n")


    private void updateQuestion() {

        currentIndex = (currentIndex + 1) % questionBank.length;
        if(currentIndex==0){


            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("هذا كل ما في الأمر! يمكنك الاحتفاظ بالنتيجة الحالية, أو تغييرها إن أردت");
            alert.setCancelable(false);
            alert.setPositiveButton("نعم, أكملت", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

finish();

                }
            });

            alert.setNegativeButton("كلا, أريد إعادة الاختبار", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score"+mscore+"/"+questionBank.length);
                    questionnumber.setText(qn + "/" + questionBank.length + "Question");
                }
            });
            alert.show();
        }

        currentquestion = questionBank[currentIndex].getQuestionid();
        question.setText(currentquestion);
        currentoptionA = questionBank[currentIndex].getOptionA();
        optionA.setText(currentoptionA);
        currentoptionB = questionBank[currentIndex].getOptionB();
        optionB.setText(currentoptionB);

        currentoptionC = questionBank[currentIndex].getOptionC();
        optionC.setText(currentoptionC);

        currentoptionD = questionBank[currentIndex].getOptionD();
        optionD.setText(currentoptionD);

        qn = qn + 1;
        if (qn <= questionBank.length) {

            questionnumber.setText(qn + "/" + questionBank.length + "Question");
        }
        score.setText("Score"+mscore+"/"+questionBank.length);
        progressBar.incrementProgressBy(prograss);
    }
}