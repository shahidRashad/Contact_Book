package com.example.contactbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "contactdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "contacts";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_NUMBER = "number";
    private static final String COL_EMIAL = "email";

    public MyHandler(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+" ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_NAME+" TEXT, "+COL_NUMBER+" TEXT, "+COL_EMIAL+" TEXT);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addContact(String contactName, String contactNo, String contactEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAME,contactName);
        values.put(COL_NUMBER,contactNo);
        values.put(COL_EMIAL,contactEmail);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<ContactModel> readContact() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        ArrayList<ContactModel> contactModelArrayList = new ArrayList<>();

        if (cursor.moveToFirst()){
            do{
                contactModelArrayList.add(new ContactModel(cursor.getString(1),cursor.getString(2),cursor.getString(3)));

            }while(cursor.moveToNext());
        }
        cursor.close();
        return contactModelArrayList;
    }
}
