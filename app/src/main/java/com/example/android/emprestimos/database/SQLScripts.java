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
            "date BIGINT NOT NULL," +
            "devolutionDate BIGINT," +
            "isMoney CHAR NOT NULL," +
            "value TEXT," +
            "loan_person INTEGER NOT NULL," +
            "description TEXT," +
            "FOREIGN KEY(loan_person) REFERENCES people(_id));";

    public static final String DELETE_PEOPLE = "DROP TABLE people;";

    public static final String DELETE_LOANS = "DROP TABLE loans;";
}
