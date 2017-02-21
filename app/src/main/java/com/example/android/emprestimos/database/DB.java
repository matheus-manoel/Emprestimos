package com.example.android.emprestimos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.emprestimos.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matheusmanoel on 21/02/17.
 */

public class DB {
    private SQLiteDatabase db;

    public DB(Context ctx) {
        DBCore dbCore = DBCore.getInstance(ctx);
        db = dbCore.getWritableDatabase();
    }

    public void insertPerson(Person person) {
        ContentValues values = new ContentValues();

        values.put("name", person.getName());
        values.put("email", person.getEmail());
        values.put("phone", person.getPhone());

        db.insert("people", null, values);
    }

    public void updatePerson(Person person) {
        ContentValues values = new ContentValues();

        values.put("name", person.getName());
        values.put("email", person.getEmail());
        values.put("phone", person.getPhone());

        db.update("people", values, "_id = ?", new String[]{""+person.getId()});
    }

    public void deletePerson(Person person) {
        db.delete("people", "_id = ?", new String[]{""+person.getId()});
    }

    public List<Person> queryPeople(String selection, String[] selectionArgs) {
        List people = new ArrayList<Person>();
        String[] columns = new String[]{"_id", "name", "email", "phone"};

        Cursor cursor = db.query("people", columns, selection, selectionArgs, null, null, null,
                                "name ASC");

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {

                Person p = new Person(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3));
                people.add(p);

            } while(cursor.moveToNext());
        }

        return people;
    }
}
