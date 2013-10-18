package org.vabishchevich.lab4.entities;

public class Account {
    private int summ;

    public Account() {
        summ = 0;
    }

    public void deposit(int v) {
        summ += v;
    }

    public void withdraw(int v) {
        summ -= v;
    }

    public int getSumm() {
        return summ;
    }
}
