package com.skielcorp.smartgrocery.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.skielcorp.smartgrocery.db.*;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public class GroceryListModel {

    private Model model;

    public GroceryListModel(Context ctx) {
        model = Model.getInstance(ctx);
    }

    public void addGroceryList(String name, String date) {
        ContentValues cv = new ContentValues();
            cv.put(TABLE_GROCERYLIST.NAME, name);
            cv.put(TABLE_GROCERYLIST.DATE, date);

        SQLiteDatabase SQ = model.getWritableDatabase();
            SQ.insert(TABLE_GROCERYLIST.TABLE_NAME, null, cv);

        Log.d("SmartGrocery", "New Grocery List added: " + name);
    }

    public Cursor getAllGroceryLists() {
        SQLiteDatabase SQ = model.getReadableDatabase();
        String[] columns = {TABLE_GROCERYLIST.ID, TABLE_GROCERYLIST.NAME, TABLE_GROCERYLIST.DATE};
        Cursor CR = SQ.query(TABLE_GROCERYLIST.TABLE_NAME, columns, null, null, null, null, null);

        return CR;
    }
}
