package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public interface TABLE_ITEMS {
//      CREATE  TABLE "main"."items" ("_id" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , "Name" TEXT NOT NULL )

    public final String TABLE_NAME = "items";
    public final String ID = "_id";
    public final String NAME = "Name";
    public final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                NAME + " TEXT NOT NULL " +
            ");";
}
