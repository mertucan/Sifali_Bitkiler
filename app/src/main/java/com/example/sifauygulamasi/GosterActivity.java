package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class GosterActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button buttonBitkiler;
    Button buttonTaslar;
    Button buttonDualar;
    Button buttonYaglar;
    Button buttonCaylar;
    Button buttonanaSayfa;
    TextView aciklamaTextView;
    TextView baslikTextView;
    int myColor = Color.parseColor("#4CAF50");
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goster);

        db = new DatabaseHelper(this);

        buttonBitkiler = findViewById(R.id.buttonBitkiler);
        buttonTaslar = findViewById(R.id.buttonTaslar);
        buttonDualar = findViewById(R.id.buttonDualar);
        buttonYaglar = findViewById(R.id.buttonYaglar);
        buttonCaylar = findViewById(R.id.buttonCaylar);
        buttonanaSayfa = findViewById(R.id.buttonAnaSayfa);
        baslikTextView = findViewById(R.id.baslikTextView);
        aciklamaTextView = findViewById(R.id.aciklamaTextView);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Name");
        String description = intent.getStringExtra("Description");

        baslikTextView.setText(title);
        aciklamaTextView.setText(description);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı");

        buttonBitkiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonBitkiler);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), BitkilerActivity.class);
                startActivity(intent);
            }
        });

        buttonTaslar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonTaslar);

                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), TaslarActivity.class);
                startActivity(intent);
            }
        });

        buttonDualar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonDualar);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), DualarActivity.class);
                startActivity(intent);
            }
        });

        buttonYaglar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonYaglar);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), YaglarActivity.class);
                startActivity(intent);
            }
        });

        buttonCaylar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonCaylar);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), CaylarActivity.class);
                startActivity(intent);

            }
        });

        buttonanaSayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonanaSayfa);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setButtonSelected(Button button) {
        button.setTextColor(myColor);
        button.setBackgroundColor(Color.WHITE);
    }
}