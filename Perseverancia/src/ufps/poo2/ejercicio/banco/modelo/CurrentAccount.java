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
public class CurrentAccount extends Account {

    private double valorSobregiro;
    CurrentAccountDAO dao;

    public CurrentAccount() {
    }

    public CurrentAccount(int accnum, double valorSobregiro, double balance) {
        super(accnum, balance);
        this.valorSobregiro = valorSobregiro;
        dao = new CurrentAccountDAO();
        dao.add(this);
    }

    @Override
    public void deposit(double sum) throws Exception {
        super.deposit(sum);
        dao.actualizarSaldo(String.valueOf(this.getAccountNumber()), this.getBalance());
    }

    @Override
    public void withdraw(double sum) throws Exception {

        if (valorSobregiro == 0) {
            throw new Exception("Cuenta " + super.getAccountNumber() + "::: No tiene valor de sobregiro asignado");
        }

        double valorDisponible = super.getBalance() + valorSobregiro;

        if (valorDisponible > sum) {
            
            super.withdraw(sum);
            dao.actualizarSaldo(String.valueOf(this.getAccountNumber()), this.getBalance());
        } else {
            throw new Exception("Cuenta " + super.getAccountNumber() + "::: No tiene saldo para retirar");
        }
    }

    @Override
    public ArrayList<Account> listAccounts() {
        ArrayList<Account> lista = (new CurrentAccountDAO().list());

        return lista;
    }

}
