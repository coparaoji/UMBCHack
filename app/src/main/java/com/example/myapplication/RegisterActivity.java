package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private Button register;
    private Button gotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firstName = (EditText)findViewById(R.id.firstNameInput);
        lastName = (EditText)findViewById(R.id.lastNameInput);
        email = (EditText)findViewById(R.id.EmailAddressInput);
        password = (EditText)findViewById(R.id.PasswordInput);
        register = (Button)findViewById(R.id.RegisterSubmit);
        gotoLogin = (Button)findViewById(R.id.newAccountButton);

        gotoLogin.setOnClickListener(new View.OnClickListener(){
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);


            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                User newUser = new User(firstName.getText().toString(),
                        lastName.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString());
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("key", email.getText().toString());
                startActivity(intent);


            }
        });
    }
}