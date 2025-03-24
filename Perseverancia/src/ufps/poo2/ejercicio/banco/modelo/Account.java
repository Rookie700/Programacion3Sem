package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public abstract class Account {

    private double bal; // The current balance
    private int accnum; // The account number

    public Account() {
    }

    public Account(int accnum, double balance) {
        bal = balance;
        this.accnum = accnum;
    }

    public void deposit(double sum) throws Exception  {
        if (sum > 0) {
            bal += sum;
        } else {
            throw new Exception("Cuenta " + this.accnum + "::: No puede consignar valores negativos.");
        }
    }

    public void withdraw(double sum) throws Exception {
        if (sum > 0) {
            bal -= sum;
        } else {
            throw new Exception("Cuenta " + this.accnum + "::: No puede retirar valores negativos.");
        }
    }

    public double getBalance() {
        return bal;
    }

    public int getAccountNumber() {
        return accnum;
    }

    @Override
    public String toString() {
        return "Acc " + accnum + ": " + "balance = " + bal;
    }

    public final void print() {
        // Don't override this,
        // override the toString method
        System.out.println(toString());
    }

    public abstract ArrayList<Account> listAccounts(); 
}
