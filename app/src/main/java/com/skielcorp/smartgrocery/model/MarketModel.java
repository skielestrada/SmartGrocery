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

}
