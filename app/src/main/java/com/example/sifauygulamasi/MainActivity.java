package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonBitkiler;
    Button buttonTaslar;
    Button buttonDualar;
    Button buttonYaglar;
    Button buttonCaylar;
    Button buttonBMI;
    Button buttonyagOrani;
    Button buttonKalori;
    Button buttonBazal;
    int myColor = Color.parseColor("#4CAF50");

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBitkiler = findViewById(R.id.buttonBitkiler);
        buttonTaslar = findViewById(R.id.buttonTaslar);
        buttonDualar = findViewById(R.id.buttonDualar);
        buttonYaglar = findViewById(R.id.buttonYaglar);
        buttonCaylar = findViewById(R.id.buttonCaylar);
        buttonBMI = findViewById(R.id.buttonBmiHesapla);
        buttonBazal = findViewById(R.id.buttonBazalMetabolizma);
        buttonyagOrani = findViewById(R.id.buttonYagOrani);
        buttonKalori = findViewById(R.id.buttonKaloriMiktari);

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

                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
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

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
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

                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);
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

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
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

                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
            }
        });

        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonBMI);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), BMI_Activity.class);
                startActivity(intent);

                buttonBMI.setTextColor(Color.WHITE);
                buttonBMI.setBackgroundColor(myColor);
            }
        });

        buttonBazal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonBazal);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), BazalActivity.class);
                startActivity(intent);

                buttonBazal.setTextColor(Color.WHITE);
                buttonBazal.setBackgroundColor(myColor);
            }
        });

        buttonyagOrani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonyagOrani);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), YagOraniActivity.class);
                startActivity(intent);

                buttonyagOrani.setTextColor(Color.WHITE);
                buttonyagOrani.setBackgroundColor(myColor);
            }
        });

        buttonKalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonKalori);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonBitkiler.setTextColor(Color.WHITE);
                buttonBitkiler.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), GunlukKaloriActivity.class);
                startActivity(intent);

                buttonKalori.setTextColor(Color.WHITE);
                buttonKalori.setBackgroundColor(myColor);
            }
        });
    }

    private void setButtonSelected(Button button) {
        button.setTextColor(myColor);
        button.setBackgroundColor(Color.WHITE);
    }
}