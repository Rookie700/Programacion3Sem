/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author igork
 */
public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(double interest, int a) {
        super(a);
        this.interest = interest;
    }

    @Override
    public void deposit(double sum) {
        double actualBalance = super.getBalance() * interest;
        if (sum > 0) {
            super.deposit(actualBalance + sum);
        } else {
            System.err.println("Account.deposit(...): " + "cannot deposit negative amount.");
        }
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

}
