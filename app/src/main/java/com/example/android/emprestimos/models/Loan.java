package com.example.android.emprestimos.models;

/**
 * Created by matheusmanoel on 18/04/17.
 */

public class Loan {
    private long date;
    private long devolutionDate;
    private boolean isMoney;
    private double value;
    private String description;
    private Person person;
    private boolean lent;

    public Loan() {}

    public Loan(long date, long devolutionDate, boolean isMoney, double value, String description, Person person, boolean emprestou) {
        this.date = date;
        this.devolutionDate = devolutionDate;
        this.isMoney = isMoney;
        this.value = value;
        this.description = description;
        this.person = person;
        this.lent = emprestou;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(long devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public boolean isMoney() {
        return isMoney;
    }

    public void setMoney(boolean money) {
        isMoney = money;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isLent() {
        return lent;
    }

    public void setLent(boolean lent) {
        this.lent = lent;
    }
}
