package com.example.cntinvoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button logButtonActivity;
    private EditText etMobile, etPassword;
    // String mobile, password;
    //final String fixMobile = "01926309002";
    // final String fixPassword = "309002";
    boolean doubleBackToExitPressedOnce = false;
    private TextView regLink;

    String name, email, mobile, password;
    String gender;

    int value = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logButtonActivity = findViewById(R.id.logbutton);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);
        regLink = findViewById(R.id.regLink);

        //etMobile.setText(fixMobile);
        //etPassword.setText(fixPassword);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        mobile = intent.getStringExtra("mobile");
        password = intent.getStringExtra("password");
        gender = intent.getStringExtra("gender");


        logButtonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fixMobile = etMobile.getText().toString().trim();
                String fixPassword = etPassword.getText().toString().trim();

                if (mobile == null || mobile.equals("")) {
                    etMobile.setError("Please Enter Mobile Number");
                } else if (password == null || password.equals("")) {
                    etPassword.setError("Please Enter Password");
                } else {
                    //Toast.makeText(getApplicationContext(),"This is test",Toast.LENGTH_LONG).show();
                    if (mobile.equals(fixMobile) && password.equals(fixPassword)) {
                        Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("email", email);
                        intent.putExtra("mobile", mobile);
                        intent.putExtra("gender", gender);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                        clearLoginPage();


                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Mobile or Password", Toast.LENGTH_LONG).show();

                    }
                }


            }
        });

        regLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    private void clearLoginPage() {
        etMobile.setText("");
        etPassword.setText("");
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);


    }
}