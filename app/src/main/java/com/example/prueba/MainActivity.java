package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button_logIn = findViewById(R.id.logIn);
        button_logIn.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), LogInActivity.class);
            startActivity(intent);
        });

        View button_signUp = findViewById(R.id.signUp);
        button_signUp.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SignUpActivity.class);
            startActivity(intent);
        });

        View button_invited = findViewById(R.id.invited);
        button_invited.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), EventsActivity.class);
            startActivity(intent);
        });
    }
}