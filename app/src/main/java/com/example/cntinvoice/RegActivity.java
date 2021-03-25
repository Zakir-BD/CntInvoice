package com.example.cntinvoice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.cntinvoice.dbpackage.DBManager;

public class RegActivity extends AppCompatActivity {
    private EditText regName, regEmail, regMobile, regPassword;
    private RadioButton radioMale, radioFemale, radiaOthers;
    String name, email, mobile, password, gender;
    RadioButton rmale, rfemale, rothers;
    private Button regButton;
    int count = 0;
    private DBManager dbManager;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        // Bind with input data field.
        regName = findViewById(R.id.etNameReg);
        regEmail = findViewById(R.id.etEmailReg);
        regMobile = findViewById(R.id.etMobileReg);
        regPassword = findViewById(R.id.etPassswordReg);

        radioMale = findViewById(R.id.etGMale);
        radioFemale = findViewById(R.id.etGFemale);
        radiaOthers = findViewById(R.id.etGOthers);

        regButton = findViewById(R.id.eregButton);

        dbManager = new DBManager(this);
        dbManager.open();
// action listener
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //value get
                name = regName.getText().toString().trim();
                email = regEmail.getText().toString().trim();
                mobile = regMobile.getText().toString().trim();
                password = regPassword.getText().toString().trim();
                if (radioMale.isChecked()) {
                    gender = "Male";
                } else if (radioFemale.isChecked()) {
                    gender = "Female";
                } else {
                    gender = "Others";
                }


                if(name.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_LONG).show();
                } else {
                    dbManager.insert(name,email,mobile,password,gender);
                    Toast.makeText(getApplicationContext(), "Sucess", Toast.LENGTH_LONG).show();
                }

                /*
                if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty() || gender.isEmpty()) {
                    if (name.isEmpty()) {
                        regName.setError("Please enter Name");
                    }
                    if (email.isEmpty()) {
                        regEmail.setError("Please enter EMail");
                    }
                    if (mobile.isEmpty()) {
                        regMobile.setError("Please enter mobile");
                    }
                    if (password.isEmpty()) {
                        regPassword.setError("Please enter password");
                    }
                    if (gender.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Move one activity to another activity.
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("mobile", mobile);
                    intent.putExtra("password", password);
                    intent.putExtra("gender", gender);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_LONG).show();
                }*/

            }
        });
    }
}