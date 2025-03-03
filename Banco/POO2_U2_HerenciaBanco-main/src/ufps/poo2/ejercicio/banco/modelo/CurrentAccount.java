/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author igork
 */
public class CurrentAccount extends Account {

    private double limiteSobregiro = 10;

    public CurrentAccount(int a) {
        super(a);
    }

    @Override
    public void withdraw(double sum) {
        if (sum > 0) {
            if (sum <= getBalance() + getLimiteSobregiro()) {
                super.withdraw(sum);
            } else {
                System.err.println("Account.withdraw(...): " + "cannot withdraw this amount.");
            }
        } else {
            System.err.println("Account.withdraw(...): " + "cannot withdraw negative amount.");
        }
    }

    /**
     * @return the limiteSobregiro
     */
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    /**
     * @param limiteSobregiro the limiteSobregiro to set
     */
    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }

    /**
     * @return the sobreGiro
     */
}
