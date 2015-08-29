package com.skielcorp.smartgrocery.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.skielcorp.smartgrocery.db.*;

public class ItemModel {

    private Model model;

    public ItemModel(Context ctx) {
        model = Model.getInstance(ctx);
    }

    public Cursor getAllItems() {
        SQLiteDatabase SQ = model.getReadableDatabase();
        String[] columns = {TABLE_ITEMS.ID, TABLE_ITEMS.NAME};
        Cursor CR = SQ.query(TABLE_ITEMS.TABLE_NAME, columns, null, null, null, null, null);

        return CR;
    }

    public Cursor getAllMatchingItems(String toMatch) {
        String where = TABLE_ITEMS.NAME + " LIKE ?";
        String[] args = {"%" + toMatch + "%"};
        String[] columns = {TABLE_ITEMS.ID, TABLE_ITEMS.NAME};

        SQLiteDatabase SQ = model.getReadableDatabase();
        Cursor CR = SQ.query(TABLE_ITEMS.TABLE_NAME, columns, where, args, null, null, null);

        return CR;
    }

    public void addItem(String name) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_ITEMS.NAME, name);

        SQLiteDatabase SQ = model.getWritableDatabase();
        SQ.insert(TABLE_ITEMS.TABLE_NAME, null, cv);

        Log.d("SmartGrocery", "New item added: " + name);
    }

    public void updateItem(int id, String name) {
        ContentValues cv = new ContentValues();
        cv.put(TABLE_ITEMS.NAME, name);

        String where = TABLE_ITEMS.ID + " =?";
        String[] args = {String.valueOf(id)};

        SQLiteDatabase SQ = model.getWritableDatabase();
        SQ.update(TABLE_ITEMS.TABLE_NAME, cv, where, args);

        Log.d("SmartGrocery", "Item info updated: " + id);
    }

    public void deleteItem(int id) {
        String where = TABLE_ITEMS.ID + " = ?";
        String[] args = {String.valueOf(id)};

        SQLiteDatabase SQ = model.getWritableDatabase();
        SQ.delete(TABLE_ITEMS.TABLE_NAME, where, args);

        Log.d("SmartGrocery", "Item deleted: " + id);
    }
}
