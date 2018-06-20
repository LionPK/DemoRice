package com.crud.jo.demorice.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "u642857372_rice1";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "rice";
    public static final String Col_id = "id_rice";
    public static final String COL_name = "name_rice";
    public static final String COL_type_rice = "type_rice";
    public static final String COL_detail_rice = "detail_rice";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Col_id + " TEXT, " + COL_name + " INTEGER, "
                + COL_type_rice + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + Col_id + ", " + COL_name
                + ", " + COL_type_rice + ","+ COL_detail_rice + ") VALUES ('Chocolate Fudge', 95, 750);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + Col_id + ", " + COL_name
                + ", " + COL_type_rice + ","+ COL_detail_rice + ") VALUES ('Banana Choc Cake', 55, 500);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + Col_id + ", " + COL_name
                + ", " + COL_type_rice + ","+ COL_detail_rice + ") VALUES ('Banoffee', 75, 700);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + Col_id + ", " + COL_name
                + ", " + COL_type_rice +  ") VALUES ('Cheese Cake', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + Col_id + ", " + COL_name
                + ", " + COL_type_rice + ") VALUES ('Tiramisu', 85, 800);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

public class Database { }
