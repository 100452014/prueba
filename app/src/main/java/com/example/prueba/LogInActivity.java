package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private AppDatabase db;
    private EditText mailText,  passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // get values inserted by the user
        db = AppDatabase.getInstance(getApplicationContext());
        mailText = findViewById(R.id.logInMail);
        passwordText = findViewById(R.id.logInPassword);

        // change them to string
        String mail = mailText.getText().toString();
        String password = passwordText.getText().toString();

        // store buttons values at variables
        Button back = findViewById(R.id.back);
        Button logIn = findViewById(R.id.logIn);

        // If we click on return button it returns
        back.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        });

        // If we click on log In button we check the credentials in order of logging in
        logIn.setOnClickListener(view -> {
            User user = db.userDao().selectByEmail(mail); // look for the user with that mail at the db
            if (user == null){
                Toast.makeText(getApplicationContext(), "user not found",
                        Toast.LENGTH_LONG).show();
            }
            if (user.password == password) {
                Toast.makeText(getApplicationContext(), "successful log in",
                        Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "wrong password" + mail,
                        Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(view.getContext(), LogInActivity.class);
            startActivity(intent);

        });




    }
}
