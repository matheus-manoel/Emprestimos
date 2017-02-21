package com.example.android.emprestimos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by matheusmanoel on 19/02/17.
 */

public class DBCore extends SQLiteOpenHelper {
    private static final String NAME = "emprestimos.db";
    private static final int VERSION = 1;

    public DBCore(Context ctx) {
        super(ctx, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creating people table
        db.execSQL(SQLScripts.CREATE_PEOPLE);

        //Creating loans table
        db.execSQL(SQLScripts.CREATE_LOANS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLScripts.DELETE_PEOPLE);
        db.execSQL(SQLScripts.DELETE_LOANS);
        onCreate(db);
    }
}
