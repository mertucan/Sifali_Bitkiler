package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class BazalActivity extends AppCompatActivity {

    Button buttonBack;
    Button btnCalculateBMR;
    EditText editTextWeight, editTextHeight, editTextAge;
    TextView textViewBMR;
    int myColor = Color.parseColor("#4CAF50");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazal);

        buttonBack = findViewById(R.id.btnBack);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextAge = findViewById(R.id.editTextAge);
        textViewBMR = findViewById(R.id.textViewResult);
        btnCalculateBMR = findViewById(R.id.btnCalculateBMR);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Bazal Metabolizma Hesaplama");

        buttonBack.setTextColor(Color.WHITE);
        buttonBack.setBackgroundColor(myColor);
        btnCalculateBMR.setTextColor(Color.WHITE);
        btnCalculateBMR.setBackgroundColor(myColor);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(myColor);
                buttonBack.setBackgroundColor(Color.WHITE);
                btnCalculateBMR.setTextColor(Color.WHITE);
                btnCalculateBMR.setBackgroundColor(myColor);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnCalculateBMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCalculateBMR.setTextColor(myColor);
                btnCalculateBMR.setBackgroundColor(Color.WHITE);
                calculateBMR();
            }
        });
    }

    private void calculateBMR() {
        try {
            double weight = Double.parseDouble(editTextWeight.getText().toString());
            double height = Double.parseDouble(editTextHeight.getText().toString());
            int age = Integer.parseInt(editTextAge.getText().toString());

            double bmr = 10 * weight + 6.25 * height - 5 * age + 5;

            textViewBMR.setText("BMR: " + bmr + " kcal/gün");
        } catch (NumberFormatException e) {

            textViewBMR.setText("Lütfen geçerli bir sayı girin.");
        }
    }
}
