package com.example.project;

import android.app.admin.DelegatedAdminReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "bus.db";
    public static final String TABLE_NAME = "users_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "user_name";
    public static final String COL_3 = "mail";
    public static final String COL_4 = "password";
    public static final String COL_5 = "tel";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, user_name TEXT, mail TEXT, password TEXT, tel TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String user_name, String mail, String password, String passwordAgain, String tel){
        SQLiteDatabase db = this.getWritableDatabase();
        if (user_name.equals("")){
            return false;
        }
        if (!mail.matches(".+@.+mail[.]com")){
            return false;
        }
        if (!password.equals(passwordAgain)){
            return false;
        }
        if (!tel.matches("[0-9]{11}")){
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, user_name);
        contentValues.put(COL_3, mail);
        contentValues.put(COL_4, password);
        contentValues.put(COL_5, tel);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public String getID(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        while (res.moveToNext()){
            if(res.getString(2).equals(email)){
                return res.getString(0);
            }
        }
        return null;
    }

    public boolean updateUser(String id, String user_name, String mail, String password, String tel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, user_name);
        contentValues.put(COL_3, mail);
        contentValues.put(COL_4, password);
        contentValues.put(COL_5, tel);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

}
