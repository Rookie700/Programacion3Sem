/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

/**
 *
 * @author borisperezg
 */
public class SavingAccount extends Account {

    private double interest;
    SavingAccountDAO dao;

    public SavingAccount() {
    }

    public SavingAccount(int accnum, double interest, double balance) {
        super(accnum, balance);
        dao = new SavingAccountDAO();
        this.interest = interest;
        dao.add(this);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void withdraw(double sum) throws Exception {
        if (sum > super.getBalance()) {
            throw new Exception("Cuenta " + super.getAccountNumber() + ": No puede retirar valores mayores al saldo disponible");
        }

        super.withdraw(sum);
        dao.actualizarSaldo(String.valueOf(this.getAccountNumber()), this.getBalance());
    }

    @Override
    public void deposit(double sum) throws Exception {

        double newVal = super.getBalance() * interest + sum;

        super.deposit(newVal);
        dao.actualizarSaldo(String.valueOf(this.getAccountNumber()), this.getBalance());
    }

    @Override
    public ArrayList<Account> listAccounts() {
        ArrayList<Account> lista = (new SavingAccountDAO().list());

        return lista;
    }

}
