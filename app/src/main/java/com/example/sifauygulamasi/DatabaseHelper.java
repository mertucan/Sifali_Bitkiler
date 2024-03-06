package com.example.sifauygulamasi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "SifaliBitkiler.db";
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String DESCRIPTION = "Description";
    private static final int DB_VERSION = 2;

    private static final String query1 = "CREATE TABLE Bitkiler ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
            + DESCRIPTION + " TEXT);";

    private static final String query2 = "CREATE TABLE Taslar ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
            + DESCRIPTION + " TEXT);";

    private static final String query3 = "CREATE TABLE Dualar ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
            + DESCRIPTION + " TEXT);";

    private static final String query4 = "CREATE TABLE Yaglar ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
            + DESCRIPTION + " TEXT);";

    private static final String query5 = "CREATE TABLE Caylar ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
            + DESCRIPTION + " TEXT);";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Tablo değişikliği yapılacaksa burada güncellemeleri ekleyin
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE Bitkiler ADD COLUMN " + DESCRIPTION + " TEXT");
            db.execSQL("ALTER TABLE Taslar ADD COLUMN " + DESCRIPTION + " TEXT");
            db.execSQL("ALTER TABLE Dualar ADD COLUMN " + DESCRIPTION + " TEXT");
            db.execSQL("ALTER TABLE Yaglar ADD COLUMN " + DESCRIPTION + " TEXT");

            // Caylar tablosuna DESCRIPTION sütunu ekle
            db.execSQL("ALTER TABLE Caylar ADD COLUMN " + DESCRIPTION + " TEXT");

            Log.d("DatabaseHelper", "Tables created successfully");
        }
    }

    public boolean insertData(String name, String desc, final String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(DESCRIPTION, desc);

        long result = db.insert(table, null, cv);

        return result != -1;
    }

    public Cursor viewData(String table){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + table + " ORDER BY NAME ASC";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void deleteAllData(String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table, null, null);
        db.close();
    }
}
