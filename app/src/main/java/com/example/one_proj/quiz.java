package com.example.one_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quiz extends AppCompatActivity {

    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),questions.class);
                startActivity(i);
            }
        });
        button2=findViewById(R.id.ready);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(getBaseContext(),addicts_questions.class);
                startActivity(x);
            }
        });
    }
}