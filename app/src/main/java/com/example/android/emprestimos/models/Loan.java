package com.example.android.emprestimos.models;

/**
 * Created by matheusmanoel on 18/04/17.
 */

public class Loan {
    private int day;
    private int month;
    private int year;
    private int devolutionDay;
    private int devolutionMonth;
    private int devolutionYear;
    private boolean isMoney;
    private double value;
    private String description;
    private Person person;
    private boolean emprestou;

    public Loan() {}

    public Loan(int day, int month, int year, int devolutionDay, int devolutionMonth,
                int devolutionYear, boolean isMoney, double value, String description,
                Person person, boolean emprestou) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.devolutionDay = devolutionDay;
        this.devolutionMonth = devolutionMonth;
        this.devolutionYear = devolutionYear;
        this.isMoney = isMoney;
        this.value = value;
        this.description = description;
        this.person = person;
        this.emprestou = emprestou;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDevolutionDay() {
        return devolutionDay;
    }

    public int getDevolutionMonth() {
        return devolutionMonth;
    }

    public int getDevolutionYear() {
        return devolutionYear;
    }

    public boolean isMoney() {
        return isMoney;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isEmprestou() {
        return emprestou;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDevolutionDay(int devolutionDay) {
        this.devolutionDay = devolutionDay;
    }

    public void setDevolutionMonth(int devolutionMonth) {
        this.devolutionMonth = devolutionMonth;
    }

    public void setDevolutionYear(int devolutionYear) {
        this.devolutionYear = devolutionYear;
    }

    public void setMoney(boolean money) {
        isMoney = money;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setEmprestou(boolean emprestou) {
        this.emprestou = emprestou;
    }
}
