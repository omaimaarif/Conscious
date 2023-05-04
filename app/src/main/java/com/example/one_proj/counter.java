package com.example.one_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class counter extends AppCompatActivity {

   private Button incr;
    private int progress=0,da=0;
    private ProgressBar pro;
    private TextView day,start_co,day_en;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        //declare
        day_en=findViewById(R.id.day_en);
        start_co=findViewById(R.id.start_counter);
        day =findViewById(R.id.day);
        pro = findViewById(R.id.circle_progress);
        incr = findViewById(R.id.incr);
        //Dialog
        dialog=new Dialog(counter.this);
        dialog.setContentView(R.layout.custom_dilog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        Button okay = dialog.findViewById(R.id.btn_okay);
        Button cancel = dialog.findViewById(R.id.btn_cancel);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(counter.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(counter.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //End dialog
        incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var = 1;
                int minas = 30;
                progress = progress + 1;
                pro.setProgress(progress);
                pro.setMax(30);
                da = da + 1;
                for (int i = 1; i <= 30; i++) {
                    start_co.setText("اليوم " + da);
                    day.setText("عدد أيام الالتزام:  " + da);
                    if (da == 30 && i == 30) {
                        dialog.show();
                    }
                }
                --minas;
                    day_en.setText("عدد الأيام المُتبقية: "+minas);


            }
        });
    }

}
