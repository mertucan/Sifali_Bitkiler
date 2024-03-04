package com.example.sifauygulamasi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "SifaliBitkiler.db";
    private static final String TABLE_BITKILER = "Bitkiler";
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String DESCRIPTION = "Description";
    private static final int DB_VERSION = 2;

    private static final String query = "CREATE TABLE " + TABLE_BITKILER + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, "
            + DESCRIPTION + " TEXT);";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Tablo değişikliği yapılacaksa burada güncellemeleri ekleyin
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE " + TABLE_BITKILER + " ADD COLUMN " + DESCRIPTION + " TEXT");
        }
    }

    public boolean insertData(String name, String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(DESCRIPTION, desc);

        long result = db.insert(TABLE_BITKILER, null, cv);

        return result != -1;
    }

    public Cursor viewData(String table){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + table;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void deleteAllData(String table) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table, null, null);
        db.close();

    }
}
