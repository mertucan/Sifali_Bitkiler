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

public class BMI_Activity extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextWeight;
    private Button buttonCalculateBMI;
    private TextView textViewResult;

    Button buttonBack;
    int myColor = Color.parseColor("#4CAF50");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        textViewResult = findViewById(R.id.textViewResult);
        buttonBack = findViewById(R.id.btnBack);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - BMI Hesaplama");

        buttonCalculateBMI.setTextColor(Color.WHITE);
        buttonCalculateBMI.setBackgroundColor(myColor);

        buttonBack.setTextColor(Color.WHITE);
        buttonBack.setBackgroundColor(myColor);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(myColor);
                buttonBack.setBackgroundColor(Color.WHITE);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateBMI() {
        double height = Double.parseDouble(editTextHeight.getText().toString()) / 100; // Convert cm to meters
        double weight = Double.parseDouble(editTextWeight.getText().toString());

        double bmi = weight / (height * height);

        String result;

        if (bmi < 18.5) {
            result = "Zayıf";
        } else if (bmi < 25) {
            result = "Normal";
        } else if (bmi < 40) {
            result = "Kilolu";
        } else {
            result = "Obez";
        }

        textViewResult.setText("BMI: " + String.format("%.2f", bmi) + "\nDurum: " + result);
    }
}
