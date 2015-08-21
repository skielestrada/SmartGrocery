package com.skielcorp.smartgrocery.db;

/**
 * Created by ezequiel.estrada on 20/08/2015.
 */
public interface TABLE_CARTS_PRODUCTS {

    public final String TABLE_NAME = "carts_products";
    public final String NOCART = "noCart";
    public final String NOPRODUCT = "noProduct";
    public final String NOMARKET = "noMarket";
    public final String PRICE = "Price";
    public final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                NOCART + " INTEGER NOT NULL, " +
                NOPRODUCT + " INTEGER NOT NULL, " +
                NOMARKET + " INTEGER NOT NULL, " +
                PRICE + " FLOAT NOT NULL, " +
                "PRIMARY KEY (" + NOCART + ", " + NOPRODUCT + "), " +
                "FOREIGN KEY (" + NOCART + ") REFERENCES " + TABLE_CARTS.TABLE_NAME + " (" + TABLE_CARTS.ID + "), " +
                "FOREIGN KEY (" + NOPRODUCT + ") REFERENCES " + TABLE_PRODUCTS.TABLE_NAME + " (" + TABLE_PRODUCTS.ID + "), " +
                "FOREIGN KEY (" + NOMARKET + ") REFERENCES " + TABLE_MARKETS.TABLE_NAME + " (" + TABLE_MARKETS.ID + ") " +
            ");";
}