package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private AppDatabase db;
    private EditText nameText, mailText,  passwordText,  languageText, phoneText;
    private RadioGroup inputPreference;
    private  String preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // get all the necessary data for creating a new user and storing it
        db = AppDatabase.getInstance(getApplicationContext());
        nameText = findViewById(R.id.signUpName);
        mailText = findViewById(R.id.signUpEmail);
        passwordText = findViewById(R.id.signUpPassword);
        languageText = findViewById(R.id.signUpLanguage);
        phoneText = findViewById(R.id.signUpNumber);
        inputPreference = findViewById(R.id.preferences);
        int selectedPreferenceID = inputPreference.getCheckedRadioButtonId();
        if(selectedPreferenceID == R.id.culturalbutton){
             preferences = "cultural";
        } else if(selectedPreferenceID == R.id.socialbutton){
            preferences = "social";
        } else if(selectedPreferenceID == R.id.nightlifebutton){
            preferences = "night_life";
        } else if(selectedPreferenceID == R.id.sportsbutton){
            preferences = "sports";
        }else if(selectedPreferenceID == R.id.restaurantbutton){
            preferences = "restaurant";
        }

        // change all the EditText types to Strings
        String name = nameText.getText().toString();
        String mail = mailText.getText().toString();
        String password = passwordText.getText().toString();
        String language = languageText.getText().toString();
        String phone = phoneText.getText().toString();

        // store buttons values at variables
        Button back = findViewById(R.id.back);
        Button insert = findViewById(R.id.signUp);

        // If press return button go back
        back.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent); });

        // If press sign up button
        insert.setOnClickListener(view -> {
            // look for a user with that email at the db. In case it is null, we create the user and insert it.
            User user = db.userDao().selectByEmail(mail);
            if (user == null){
                User new_user = new User (name, mail, password, language, preferences, phone);
                long id = db.userDao().insert(new_user);
                Toast.makeText(getApplicationContext(), "Inserted user " + name,
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "User " + name + "already exists",
                        Toast.LENGTH_LONG).show();
            }


        });


    }

}
