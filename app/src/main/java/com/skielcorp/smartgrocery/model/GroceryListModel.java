package com.skielcorp.smartgrocery.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.skielcorp.smartgrocery.db.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public class GroceryListModel {

    private String TAG = "SmartGrocery";

    private Model model;
    private Context ctx;

    public GroceryListModel(Context ctx) {
        this.ctx = ctx;
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

    public Cursor getAllMatchingItems(String toMatch) {
        ItemModel itemmodel = new ItemModel(ctx);

        return itemmodel.getAllMatchingItems(toMatch);
    }

    public void addItemsGroceryList(String grocerylist, String item) {
        ContentValues cv = new ContentValues();
            cv.put(TABLE_ITEMS_GROCERYLIST.NOGROCERYLIST, grocerylist);
            cv.put(TABLE_ITEMS_GROCERYLIST.NOITEM, item);

        SQLiteDatabase SQ = model.getWritableDatabase();
        SQ.insert(TABLE_ITEMS_GROCERYLIST.TABLE_NAME, null, cv);
        Log.d("SmartGrocery", "New item added to list " + grocerylist + ": " + item);
    }

    public Map<String, String> getAllItemsGroceryList(String grocerylist) {

        String query =  "SELECT " + TABLE_ITEMS_GROCERYLIST.NOITEM + ", " + TABLE_ITEMS.NAME +
                        " FROM " + TABLE_ITEMS_GROCERYLIST.TABLE_NAME + ", " + TABLE_ITEMS.TABLE_NAME +
                        " WHERE " +
                            TABLE_ITEMS_GROCERYLIST.NOITEM + " = " + TABLE_ITEMS.ID +
                            " AND " + TABLE_ITEMS_GROCERYLIST.NOGROCERYLIST + " LIKE " + grocerylist
                ;

        SQLiteDatabase SQ = model.getReadableDatabase();
        Cursor cursor = SQ.rawQuery(query, null);

        Map<String, String> map = new HashMap<String, String>();
        while(cursor.moveToNext()) {
            String itemID = cursor.getString(cursor.getColumnIndex(TABLE_ITEMS_GROCERYLIST.NOITEM));
            String itemName = cursor.getString(cursor.getColumnIndex(TABLE_ITEMS.NAME));
            map.put(itemID, itemName);
        }

        return map;
    }
}
