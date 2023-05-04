package com.example.one_proj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class menu_main extends AppCompatActivity {
private NavigationView mainNavView;
    ImageButton t1;
    ImageButton t2;
    ImageButton c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
        mainNavView=findViewById(R.id.navigation);
        mainNavView.setItemIconTintList(null);

        t1 =findViewById(R.id.test_ic);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),quiz.class);
                startActivity(i);
            }
        });
        t2 =findViewById(R.id.message_ic);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),our_message.class);
                startActivity(i);
            }
        });
        c=findViewById(R.id.count_ic);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c=new Intent(getBaseContext(),counter.class);
                startActivity(c);
            }
        });
    }
}