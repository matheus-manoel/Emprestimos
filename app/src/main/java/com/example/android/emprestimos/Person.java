package com.example.android.emprestimos;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by matheusmanoel on 18/02/17.
 */

@SuppressWarnings("serial")
public class Person implements Serializable {

    private String name;
    private String email;
    private String phone;
    private int id;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Person(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() { return id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(int id) { this.id = id; }
}
