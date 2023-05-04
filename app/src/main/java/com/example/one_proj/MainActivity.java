package com.example.one_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//splash screen
    Button bu_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu_logo=findViewById(R.id.bu_logo);
    bu_logo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getBaseContext(),login.class);
            startActivity(i);
        }
    });
    }
}