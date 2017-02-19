package com.example.android.emprestimos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by matheusmanoel on 19/02/17.
 */

public class BDCore extends SQLiteOpenHelper {
    private static final String NAME = "emprestimos.db";
    private static final int VERSION = 1;

    public BDCore(Context ctx) {
        super(ctx, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creating people table
        db.execSQL("CREATE TABLE people (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                          " name TEXT NOT NULL," +
                                          " email TEXT NOT NULL)," +
                                          " phone TEXT NOT NULL);");

        //Creating loans table
        db.execSQL("CREATE TABLE loans (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        " loanDate TEXT NOT NULL," +
                                        " isMoney TEXT NOT NULL)," +
                                        " phone TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
