package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public interface TABLE_GROCERYLIST {
//    CREATE  TABLE "main"."grocerylist" ("id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "Date" DATETIME DEFAULT CURRENT_DATE)

    public final String TABLE_NAME = "grocerylist";
    public final String ID = "_id";
    public final String NAME = "Name";
    public final String DATE = "Date";
    public final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                NAME + " TEXT, " +
                DATE + " DATETIME DEFAULT CURRENT_DATE " +
            ");";
}
