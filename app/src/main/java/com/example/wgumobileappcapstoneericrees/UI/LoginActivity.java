package com.example.wgumobileappcapstoneericrees.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wgumobileappcapstoneericrees.R;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button btnLogin;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.eTxt_username);
        password = findViewById(R.id.eTxt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnExit = findViewById(R.id.btn_exit);

        // Set login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

        // Set exit button
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    // Method to set username and password
    private void validate(String username, String password) {
        if (username.equals("test") && password.equals("test")) {
            Intent intent = new Intent (LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect username and/or password!", Toast.LENGTH_LONG).show();
        }
    }
}