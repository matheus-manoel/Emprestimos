package com.example.android.emprestimos.database;

/**
 * Created by matheusmanoel on 21/02/17.
 */

public final class SQLScripts {

    public static final String CREATE_PEOPLE = "CREATE TABLE people (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL," +
            "email TEXT," +
            "phone TEXT);";

    public static final String CREATE_LOANS = "CREATE TABLE loans (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "loanDate TEXT NOT NULL," +
            "isMoney CHAR NOT NULL," +
            "value TEXT," +
            "phone TEXT NOT NULL," +
            "loan_person INTEGER NOT NULL," +
            "FOREIGN KEY(loan_person) REFERENCES people(_id));";

    public static final String DELETE_PEOPLE = "DROP TABLE people;";

    public static final String DELETE_LOANS = "DROP TABLE loans;";
}
