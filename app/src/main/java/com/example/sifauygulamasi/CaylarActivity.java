package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class CaylarActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button buttonBitkiler;
    Button buttonTaslar;
    Button buttonDualar;
    Button buttonYaglar;
    Button buttonCaylar;
    Button buttonVeriEkle;
    EditText editTextAra;
    Button buttonAra;
    ListView caylarList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    int myColor = Color.parseColor("#4CAF50");

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caylar);

        db = new DatabaseHelper(this);
        caylarList = findViewById(R.id.listView);
        listItem = new ArrayList<>();

        buttonBitkiler = findViewById(R.id.buttonBitkiler);
        buttonTaslar = findViewById(R.id.buttonTaslar);
        buttonDualar = findViewById(R.id.buttonDualar);
        buttonYaglar = findViewById(R.id.buttonYaglar);
        buttonCaylar = findViewById(R.id.buttonCaylar);
        buttonVeriEkle = findViewById(R.id.buttonVeriEkle);
        editTextAra = findViewById(R.id.editTextAra);
        buttonAra = findViewById(R.id.buttonSearch);

        viewData();

        setButtonSelected(buttonCaylar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Şifacı - Çaylar");

        buttonAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchByName();
            }
        });

        caylarList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTitle = parent.getItemAtPosition(position).toString();
                Cursor cursor = db.getDataByTitle(selectedTitle, "Caylar");

                if (cursor != null && cursor.moveToFirst()) {
                    int nameColumnIndex = cursor.getColumnIndex("Name");
                    int descriptionColumnIndex = cursor.getColumnIndex("Description");

                    if (nameColumnIndex != -1 && descriptionColumnIndex != -1) {
                        String title = cursor.getString(nameColumnIndex);
                        String description = cursor.getString(descriptionColumnIndex);

                        Intent intent = new Intent(CaylarActivity.this, GosterActivity.class);
                        intent.putExtra("Name", title);
                        if(description.equals(""))
                        {
                            intent.putExtra("Description", "Açıklama yok.");
                        }
                        else
                        {
                            intent.putExtra("Description", description);
                        }
                        startActivity(intent);
                    } else {
                        Log.e("CaylarActivity", "Belirtilen sütun adları bulunamadı.");
                    }

                    cursor.close();
                }
            }
        });
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

        buttonVeriEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonSelected(buttonVeriEkle);

                buttonTaslar.setTextColor(Color.WHITE);
                buttonTaslar.setBackgroundColor(myColor);
                buttonCaylar.setTextColor(Color.WHITE);
                buttonCaylar.setBackgroundColor(myColor);
                buttonYaglar.setTextColor(Color.WHITE);
                buttonYaglar.setBackgroundColor(myColor);
                buttonDualar.setTextColor(Color.WHITE);
                buttonDualar.setBackgroundColor(myColor);

                Intent intent = new Intent(v.getContext(), AddActivity.class);

                intent.putExtra("kategori", "Caylar");
                startActivity(intent);
            }
        });
    }

    private void setButtonSelected(Button button) {
        button.setTextColor(myColor);
        button.setBackgroundColor(Color.WHITE);
    }

    private void viewData(){
        Cursor cursor = db.viewData("Caylar");

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show.", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            caylarList.setAdapter(adapter);
        }
    }

    private void searchByName() {
        String searchQuery = editTextAra.getText().toString().trim();

        if (searchQuery.isEmpty()) {
            viewData();
            return;
        }

        Cursor cursor = db.searchByName(searchQuery, "Caylar");

        if (cursor != null && cursor.moveToFirst()) {
            listItem.clear();

            do {
                listItem.add(cursor.getString(1));
            } while (cursor.moveToNext());

            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Sonuç bulunamadı.", Toast.LENGTH_SHORT).show();
        }

        if (cursor != null) {
            cursor.close();
        }
    }
}