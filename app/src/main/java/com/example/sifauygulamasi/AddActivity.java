package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class AddActivity extends AppCompatActivity {

    Button buttonBack;
    Button btnEkle;
    EditText editTextAd, editTextAciklama;
    int myColor = Color.parseColor("#4CAF50");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        buttonBack = findViewById(R.id.btnBack);
        btnEkle = findViewById(R.id.btnEkle);
        editTextAciklama = findViewById(R.id.editTextAciklama);
        editTextAd = findViewById(R.id.editTextAd);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Veri Ekle");

        buttonBack.setTextColor(Color.WHITE);
        buttonBack.setBackgroundColor(myColor);
        btnEkle.setTextColor(Color.WHITE);
        btnEkle.setBackgroundColor(myColor);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBack.setTextColor(myColor);
                buttonBack.setBackgroundColor(Color.WHITE);
                btnEkle.setTextColor(Color.WHITE);
                btnEkle.setBackgroundColor(myColor);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEkle.setTextColor(myColor);
                btnEkle.setBackgroundColor(Color.WHITE);

                String ad = editTextAd.getText().toString();
                String aciklama = editTextAciklama.getText().toString();

                if (ad.isEmpty() || aciklama.isEmpty()) {
                    Toast.makeText(AddActivity.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseHelper dbHelper = new DatabaseHelper(AddActivity.this);

                    Intent intent = getIntent();
                    String kategori = intent.getStringExtra("kategori");

                    boolean success = dbHelper.insertData(ad, aciklama, kategori);

                    if (success) {
                        Toast.makeText(AddActivity.this, "Veri başarıyla eklendi", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddActivity.this, "Veri eklenirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                    }

                    dbHelper.close();
                }
            }
        });

    }
}
