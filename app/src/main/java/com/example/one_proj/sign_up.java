package com.example.one_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    TextView sign_te;
    Button si_bu,google,facebook;
    EditText fname,lname,email,pass;
    RadioButton male,femal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
male=findViewById(R.id.male);
male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
});
        femal=findViewById(R.id.female);
femal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
});

        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass_sign);
        sign_te=findViewById(R.id.sign_t);
        si_bu=findViewById(R.id.si_bu);
        google=findViewById(R.id.google);
        facebook=findViewById(R.id.facebook);
        si_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckCeadentials();
            }
        });

    }

    private void CheckCeadentials() {


        String user_email=email.getText().toString();
        String password=pass.getText().toString();
        String firstName=fname.getText().toString();
        String lastName=lname.getText().toString();

        if(firstName.isEmpty() || firstName.length()<3){

            showError(fname,"Please enter your full name");
        }
        else if(lastName.isEmpty() || lastName.length()<3){

            showError(lname,"Please enter your full last name");
        }
        else if(user_email.isEmpty()){

            showError(email,"It is empty!,please correct it");
        }
        else if(password.isEmpty()|| password.length()<5){
            showError(pass,"So short!");
        }
        si_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),menu_main.class);
                startActivity(i);

            }
        });
    }


    private void showError(EditText edittext, String s) {

        edittext.setError(s);
        edittext.requestFocus();


    }

}