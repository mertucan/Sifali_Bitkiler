package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class YaglarActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button buttonBitkiler;
    Button buttonTaslar;
    Button buttonDualar;
    Button buttonYaglar;
    Button buttonCaylar;
    Button buttonanaSayfa;
    Button buttonEkle;
    Button buttonTemizle;
    ListView plantList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    int myColor = Color.parseColor("#4CAF50");

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaglar);

        db = new DatabaseHelper(this);
        plantList = findViewById(R.id.listView);
        listItem = new ArrayList<>();

        buttonBitkiler = findViewById(R.id.buttonBitkiler);
        buttonTaslar = findViewById(R.id.buttonTaslar);
        buttonDualar = findViewById(R.id.buttonDualar);
        buttonYaglar = findViewById(R.id.buttonYaglar);
        buttonCaylar = findViewById(R.id.buttonCaylar);
        buttonanaSayfa = findViewById(R.id.buttonAnaSayfa);
        buttonEkle = findViewById(R.id.buttonEkle);
        buttonTemizle = findViewById(R.id.buttonTemizle);

        viewData();

        setButtonSelected(buttonYaglar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Yağlar");
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

                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        buttonEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonEkle);

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

                db.insertData("Magnezyum Yağı", "", "Yaglar");
                db.insertData("Nane Ruhu", "", "Yaglar");
                db.insertData("Nane Yağı", "", "Yaglar");
                db.insertData("Acı Elma Yağı", "", "Yaglar");
                db.insertData("Soğan Yağı", "", "Yaglar");
                db.insertData("Sedir Ağacı Yağı", "", "Yaglar");
                db.insertData("Safran Yağı", "", "Yaglar");
                db.insertData("Pelin Otu Yağı", "", "Yaglar");
                db.insertData("Nergis Yağı", "", "Yaglar");
                db.insertData("Mısır Yağı", "", "Yaglar");
            }
        });
        buttonTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonTemizle);

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

                db.deleteAllData("Yaglar");

            }
        });
    }

    private void setButtonSelected(Button button) {
        button.setTextColor(myColor);
        button.setBackgroundColor(Color.WHITE);
    }

    private void viewData(){
        Cursor cursor = db.viewData("Yaglar");

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show.", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            plantList.setAdapter(adapter);
        }
    }
}