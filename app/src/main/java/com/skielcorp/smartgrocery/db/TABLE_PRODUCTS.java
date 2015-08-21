package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public interface TABLE_PRODUCTS {

    public final String TABLE_NAME = "products";
    public final String ID = "_id";
    public final String NAME = "Name";
    public final String NOITEM = "noItem";
    public final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                NAME + " TEXT, " +
                NOITEM + " INTEGER NOT NULL, " +
                "FOREIGN KEY (" + NOITEM + ") REFERENCES " + TABLE_ITEMS.TABLE_NAME + " (" + TABLE_ITEMS.ID + ") " +
            ");";
}
