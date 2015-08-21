package com.skielcorp.smartgrocery.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ezequiel.estrada on 15/08/2015.
 */
public class Model extends SQLiteOpenHelper {

    private static final int dbVersion = 1;
    private static Model instance = null;

    public static Model getInstance(Context ctx) {
        Log.d("SmartGrocery", "Database instance required");

        if (instance==null) {
            instance = new Model(ctx);
        }

        return instance;
    }

    public Model(Context context) {
        super(context, DBInfo.DATABASE_NAME, null, dbVersion);

        Log.d("SmartGrocery", "Database initialized");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_ITEMS.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_ITEMS created");

        db.execSQL(TABLE_GROCERYLIST.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_GROCERYLIST created");

        db.execSQL(TABLE_ITEMS_GROCERYLIST.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_ITEMS_GROCERYLIST created");

        db.execSQL(TABLE_MARKETS.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_MARKETS created");

        db.execSQL(TABLE_PRODUCTS.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_PRODUCTS created");

        db.execSQL(TABLE_CARTS.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_CARTS created");

        db.execSQL(TABLE_CARTS_PRODUCTS.CREATE_TABLE);
        Log.d("SmartGrocery", "TABLE_CARTS_PRODUCTS created");

        Log.d("SmartGrocery","Database is ready!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
