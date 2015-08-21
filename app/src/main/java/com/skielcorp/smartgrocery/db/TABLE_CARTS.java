package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public interface TABLE_CARTS {

    public final String TABLE_NAME = "carts";
    public final String ID = "_id";
    public final String DATE = "Date";
    public final String NOGROCERYLIST = "noGroceryList";
    public final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                DATE + " DATETIME DEFAULT CURRENT_DATE, " +
                NOGROCERYLIST + " INTEGER NOT NULL, " +
                "FOREIGN KEY (" + NOGROCERYLIST + ") REFERENCES " + TABLE_GROCERYLIST.TABLE_NAME + " (" + TABLE_GROCERYLIST.ID + ") " +
            ");";
}
