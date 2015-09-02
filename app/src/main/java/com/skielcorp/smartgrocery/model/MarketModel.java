package com.skielcorp.smartgrocery.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.skielcorp.smartgrocery.db.*;

public class MarketModel {

    private String TAG = "SmartGrocery";

    private Model model;

    public MarketModel(Context ctx) {
        model = Model.getInstance(ctx);
    }

    public Cursor getAllMarkets() {
        SQLiteDatabase SQ = model.getReadableDatabase();
        String[] columns = {TABLE_MARKETS.ID, TABLE_MARKETS.NAME};
        Cursor CR = SQ.query(TABLE_MARKETS.TABLE_NAME, columns, null, null, null, null, null);

        return CR;
    }

    public void addMarket(String name) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_MARKETS.NAME, name);

        SQLiteDatabase SQ = model.getWritableDatabase();
        SQ.insert(TABLE_MARKETS.TABLE_NAME, null, cv);

        Log.d(TAG, "New market added: " + name);
    }

    public void updateMarket(String id, String name) {
        ContentValues cv = new ContentValues();
            cv.put(TABLE_MARKETS.NAME, name);

        String where = TABLE_MARKETS.ID + " LIKE ?";
        String[] args = {id};

        SQLiteDatabase SQ = model.getWritableDatabase();
            SQ.update(TABLE_MARKETS.TABLE_NAME, cv, where, args);

        Log.d(TAG, "Market info updated: " + id);
    }

    public void deleteMarket(String id) {
        String where = TABLE_MARKETS.ID + " = ?";
        String[] args = {id};

        SQLiteDatabase SQ = model.getWritableDatabase();
            SQ.delete(TABLE_MARKETS.TABLE_NAME, where, args);

        Log.d(TAG, "Item deleted: " + id);
    }
}
