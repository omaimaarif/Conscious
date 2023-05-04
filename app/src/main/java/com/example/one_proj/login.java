package com.example.one_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.xml.validation.Validator;

public class login extends AppCompatActivity {
    private TextView log_text, dont_ac;
    private EditText user, pass;
    private Button sign_bu, log_bu;
    private String username = "Admin";
    private String PassWord = "12345678";
    boolean isValid=false;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        log_text = findViewById(R.id.log_text);
        dont_ac = findViewById(R.id.dont_ac);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        log_bu = findViewById(R.id.log_bu);
        log_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myname=database.getReference("Name");
                DatabaseReference mypass=database.getReference("pass");
                String usern = user.getText().toString();
                String password = pass.getText().toString();
                myname.push().setValue(usern);
                mypass.push().setValue(password);

                Intent i=new Intent(getBaseContext(),menu_main.class);
                startActivity(i);
                if (usern.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all the details correctly", Toast.LENGTH_LONG).show();
                } else {

                    isValid= valid(usern,password);
                    if(isValid){

                    counter--;
                        Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                        if(counter==0){
                            log_bu.setEnabled(false);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
        sign_bu = findViewById(R.id.sign_bu);
        sign_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, sign_up.class));
            }
        });

    }

    private boolean valid(String name, String passw) {
        if (name.equals(username) && passw.equals(PassWord)) {
            return true;
        }
        return false;
    }
}