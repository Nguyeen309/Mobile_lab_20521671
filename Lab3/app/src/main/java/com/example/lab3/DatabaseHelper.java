package com.example.lab3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String INFO_TABLE = "INFO_TABLE";
    private static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PHONE = "Phone";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "info.db", null, 1);
    }

    //this is called the first time a dtb is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + INFO_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " Text)";

        db.execSQL(createTableStatement);
    }

    //this is called if the database version number changes. It prevents previous users app from breaking when you changing the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(InfoActivity info){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, info.getName());
        cv.put(COLUMN_PHONE, info.getPhone());

        long insert = db.insert(INFO_TABLE, null, cv);
        if (insert == -1)
            return false;
        else
            return true;

    }

    public boolean deleteOne(InfoActivity infoActivity){

        //find info in the database. Then if it found, delete and return true. If it is not found, return false.
        SQLiteDatabase db = this.getWritableDatabase();
        String string = "DELETE FROM " + INFO_TABLE + " WHERE " + COLUMN_ID + " = " + infoActivity.getId();

        Cursor cursor = db.rawQuery(string, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }
    public List<InfoActivity> getEveryone(){

        List<InfoActivity> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + INFO_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            //loop through the cursor (result set) and create new info objects. Put them into the return list.
            do{
                int info_id = cursor.getInt(0);
                String info_name = cursor.getString(1);
                String info_phone = cursor.getString(2);

                InfoActivity newInfo = new InfoActivity(info_id, info_name, info_phone);
                returnList.add(newInfo);
            } while(cursor.moveToNext());
        }
        else{
            //failure. do not add anything to the list.
        }
        cursor.close();;
        db.close();
        return returnList;

    }
}
