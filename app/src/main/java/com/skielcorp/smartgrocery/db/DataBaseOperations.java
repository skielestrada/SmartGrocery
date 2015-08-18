package com.skielcorp.smartgrocery.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ezequiel.estrada on 15/08/2015.
 */
public class DataBaseOperations extends SQLiteOpenHelper {

    private static final int dbVersion = 1;

    public DataBaseOperations(Context context) {
        super(context, DBInfo.DATABASE_NAME, null, dbVersion);

        Log.d("SmartGrocery", "Database initialized");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SmartGrocery","Database created");

        db.execSQL(DBInfo.CREATE_TABLE_ITEM);
        Log.d("SmartGrocery","Table ITEM created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
