package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        View button = findViewById(R.id.back);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        });

        LinearLayout linearLayout = findViewById(R.id.linear_events);
        addImageFromResourcesToLayout("marathon", linearLayout);
        addImageFromResourcesToLayout("sushi", linearLayout);
    }

    private void addImageFromResourcesToLayout(String name, LinearLayout linearLayout) {
        int imageResourceId = getResources().getIdentifier(name, "drawable", getPackageName());
        ImageButton imageButton = new ImageButton(this);
        imageButton.setImageResource(imageResourceId);
        linearLayout.addView(imageButton);

        TextView textView = new TextView(this);
        textView.setText(name);
        linearLayout.addView(textView);
    }
}
