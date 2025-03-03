package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> cuentas = new ArrayList<>();

    public void withdrawAccount(int numeroCuenta, double sum) {
        int index = indexCuenta(numeroCuenta);
        if (index != -1) {
            cuentas.get(index).withdraw(sum);
        }
    }

    public void payDividend(int numeroCuenta, double sum) {
        int index = indexCuenta(numeroCuenta);
        if (index != -1) {
            cuentas.get(index).deposit(sum);
        }
    }

    public double getBalance(int numeroCuenta) {
        double balance = 0;
        int index = indexCuenta(numeroCuenta);
        if (index != -1) {
            balance = cuentas.get(index).getBalance();
        }
        return balance;
    }

    public void sendLetterToOverdraftAccounts() {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getBalance() < 0) {
                System.out.println("Numero de Cuenta: " + cuentas.get(i).getAccountNumber() + " esta en sobregiro");
            }
        }
    }

    public void cerrarCuenta(int numeroCuenta) {
        int index = indexCuenta(numeroCuenta);
        if (index != -1) {
            if (cuentas.get(index).getBalance() == 0) {
                cuentas.remove(index);
            } else {
                if (cuentas.get(index).getBalance() > 0) {
                    System.out.println("La cuenta aun tiene dinero");
                }
                if (cuentas.get(index).getBalance() < 0) {
                    System.out.println("La cuenta esta en sobregiro");
                }
            }
        } else {
            System.out.println("La cuenta no existe");
        }
    }

    public void openAccount(char tipoCuenta, int numeroCuenta) {
        Account nuevaCuenta;
        if (tipoCuenta == 'A') {
            nuevaCuenta = new SavingsAccount(0, numeroCuenta);
            cuentas.add(nuevaCuenta);
        }
        if (tipoCuenta == 'C') {
            nuevaCuenta = new CurrentAccount(numeroCuenta);
            cuentas.add(nuevaCuenta);
        }
    }

    public void abrirCuentaCorriente(int numeroCuenta, double limiteSobreGiro) {
        SavingsAccount nuevaCuenta = new SavingsAccount(limiteSobreGiro, numeroCuenta);
        cuentas.add(nuevaCuenta);
    }

    public int indexCuenta(int numeroCuenta) {
        int index = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getAccountNumber() == numeroCuenta) {
                index = i;
            }
        }
        return index;
    }

    /**
     * @return the cuentas
     */
    public ArrayList<Account> getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(ArrayList<Account> cuentas) {
        this.cuentas = cuentas;
    }

}
