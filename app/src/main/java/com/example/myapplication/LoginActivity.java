package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private User currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = (EditText)findViewById(R.id.EmailAddressInput);
        password = (EditText)findViewById(R.id.PasswordInput);
        login = (Button)findViewById(R.id.logInSubmit);
        currentUser = new User(email.getText().toString(), password.getText().toString());

        login.setOnClickListener(new View.OnClickListener(){
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                if(User.loginCheck(currentUser)|| true){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("key", email.getText().toString());
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}