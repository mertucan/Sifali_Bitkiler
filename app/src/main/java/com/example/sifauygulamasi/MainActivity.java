package com.example.sifauygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    Button add_data;
    EditText add_name;

    ListView plantList;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItem = new ArrayList<>();

        db = new DatabaseHelper(this);
        add_data = findViewById(R.id.add_data);
        add_name = findViewById(R.id.add_name);
        plantList = findViewById(R.id.listView);

        viewData();

        plantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = plantList.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, ""+ text, Toast.LENGTH_SHORT).show();
            }
        });

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add_name.getText().toString();
                if(!name.equals("") && db.insertData(name)){
                    Toast.makeText(MainActivity.this, "Data added", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    listItem.clear();
                    viewData();
                }
                else{
                    Toast.makeText(MainActivity.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewData(){
        Cursor cursor = db.viewData();

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