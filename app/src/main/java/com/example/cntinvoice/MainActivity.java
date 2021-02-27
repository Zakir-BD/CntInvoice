package com.example.cntinvoice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button logButtonActivity;
    private EditText etMobile, etPassword;
    String mobile, password;
    final String fixMobile = "01926309002";
    final String fixPassword = "309002";
    boolean doubleBackToExitPressedOnce = false;

    int value = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logButtonActivity = findViewById(R.id.logbutton);
        etMobile = findViewById(R.id.etMobile);
        etPassword = findViewById(R.id.etPassword);

        etMobile.setText(fixMobile);
        etPassword.setText(fixPassword);


        logButtonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = etMobile.getText().toString().trim();
                password = etPassword.getText().toString().trim();

                if (mobile == null || mobile.equals("")) {
                    etMobile.setError("Please Enter Mobile Number");
                } else if (password == null || password.equals("")) {
                    etPassword.setError("Please Enter Password");
                } else {
                    //Toast.makeText(getApplicationContext(),"This is test",Toast.LENGTH_LONG).show();
                    if (mobile.equals(fixMobile) && password.equals(fixPassword)) {
                        Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
                        intent.putExtra("mobile", mobile);
                        intent.putExtra("password", password);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                        clearLoginPage();


                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Mobile or Password", Toast.LENGTH_LONG).show();

                    }
                }


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