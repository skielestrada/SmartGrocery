package com.skielcorp.smartgrocery.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.skielcorp.smartgrocery.db.*;

public class MarketModel {

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

}
