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

public class GunlukKaloriActivity extends AppCompatActivity {

    Button buttonBack;
    Button btnCalculate;
    EditText editTextAge, editTextWeight, editTextHeight, editTextActivityLevel;
    TextView textViewResult;
    int myColor = Color.parseColor("#4CAF50");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalori);

        buttonBack = findViewById(R.id.btnBack);
        editTextAge = findViewById(R.id.editTextAge);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextActivityLevel = findViewById(R.id.editTextActivityLevel);
        textViewResult = findViewById(R.id.textViewResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Günlük Kalori İhtiyacı Hesaplama");

        buttonBack.setTextColor(Color.WHITE);
        buttonBack.setBackgroundColor(myColor);
        btnCalculate.setTextColor(Color.WHITE);
        btnCalculate.setBackgroundColor(myColor);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(myColor);
                buttonBack.setBackgroundColor(Color.WHITE);
                btnCalculate.setTextColor(Color.WHITE);
                btnCalculate.setBackgroundColor(myColor);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCalculate.setTextColor(myColor);
                btnCalculate.setBackgroundColor(Color.WHITE);
                calculateDailyCalories();
            }
        });
    }

    private void calculateDailyCalories() {
        int age = Integer.parseInt(editTextAge.getText().toString());
        int weight = Integer.parseInt(editTextWeight.getText().toString());
        int height = Integer.parseInt(editTextHeight.getText().toString());
        double activityLevel = Double.parseDouble(editTextActivityLevel.getText().toString());

        double bmr = 10 * weight + 6.25 * height - 5 * age;

        double dailyCalories = bmr * activityLevel;

        textViewResult.setText("Günlük Kalori İhtiyacınız: " + String.format("%.2f", dailyCalories) + " kalori");
    }
}
