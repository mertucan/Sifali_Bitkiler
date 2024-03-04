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

public class YagOraniActivity extends AppCompatActivity {

    Button buttonBack;
    int myColor = Color.parseColor("#4CAF50");
    EditText editTextWeight, editTextHeight, editTextAge;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yagorani);

        buttonBack = findViewById(R.id.btnBack);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextAge = findViewById(R.id.editTextAge);
        textViewResult = findViewById(R.id.textViewResult);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Yağ Oranı Hesaplama");

        buttonBack.setTextColor(Color.WHITE);
        buttonBack.setBackgroundColor(myColor);
        btnCalculate.setTextColor(Color.WHITE);
        btnCalculate.setBackgroundColor(myColor);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(myColor);
                buttonBack.setBackgroundColor(Color.WHITE);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(Color.WHITE);
                buttonBack.setBackgroundColor(myColor);
                btnCalculate.setTextColor(myColor);
                btnCalculate.setBackgroundColor(Color.WHITE);
                calculateFatPercentage();
            }
        });
    }

    private void calculateFatPercentage() {
        double weight = Double.parseDouble(editTextWeight.getText().toString());
        double height = Double.parseDouble(editTextHeight.getText().toString());
        int age = Integer.parseInt(editTextAge.getText().toString());

        double fatPercentage = (0.5 * age) + (0.3 * weight) - (0.1 * height);

        textViewResult.setText("Yağ Oranı: " + fatPercentage);
    }
}
