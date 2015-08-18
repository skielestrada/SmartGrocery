package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 15/08/2015.
 */
public interface DBInfo {
    public final String DATABASE_NAME = "smartgrocery_db";

    public final String TABLE_ITEM = "item";
    public final String ITEM_ID = "id";
    public final String ITEM_NAME = "name";
    public final String CREATE_TABLE_ITEM =
        "CREATE TABLE" + TABLE_ITEM + " (" +
                ITEM_ID + " INTEGER, " +
                ITEM_NAME + " TEXT" +
                ");";

}
