package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public interface TABLE_ITEMS_GROCERYLIST {
//    CREATE TABLE "items_grocerylist" ("noItem" INTEGER NOT NULL , "noGroceryList" INTEGER NOT NULL , PRIMARY KEY ("noItem", "noGroceryList"))

    public final String TABLE_NAME = "items_grocerylist";
    public final String NOITEM = "noItem";
    public final String NOGROCERYLIST = "noGroceryList";
    public final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                NOITEM + " INTEGER NOT NULL, " +
                NOGROCERYLIST + " INTEGER NOT NULL, " +
                "PRIMARY KEY (" + NOITEM + ", " + NOGROCERYLIST + "), " +
                "FOREIGN KEY (" + NOITEM + ") REFERENCES " + TABLE_ITEMS.TABLE_NAME + " (" + TABLE_ITEMS.ID + "), " +
                "FOREIGN KEY (" + NOGROCERYLIST + ") REFERENCES " + TABLE_GROCERYLIST.TABLE_NAME + " (" + TABLE_GROCERYLIST.ID + ")" +
            ");";
}
