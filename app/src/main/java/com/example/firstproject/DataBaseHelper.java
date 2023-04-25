package com.example.firstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, "Elements", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists elementTable (id integer primary key autoincrement, item_name text, quantity text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(String itemName, String quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("item_name", itemName);
        c.put("quantity", quantity);
        db.insert("elementTable", null, c);
    }

    public ArrayList readData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from elementTable", null);
        c.moveToFirst();
        ArrayList ans = new ArrayList<>();
        while(c.isAfterLast() == false) {
            String item = c.getString(1);
            String quantity = c.getString(2);
            ans.add(item + "  " + quantity);
            c.moveToNext();
            //Log.d("TEETET", item + "   " + quantity);
        }
        return ans;
    }

}
