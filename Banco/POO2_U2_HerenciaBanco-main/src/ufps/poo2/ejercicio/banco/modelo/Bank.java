package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> cuentas = new ArrayList<>();

    public boolean withdrawAccount(int numeroCuenta, double sum) {
        int index = indexCuenta(numeroCuenta);
        double valorActual = 0;
        double valorViejo = 0;
        if (index != -1) {
            valorViejo = getCuentas().get(index).getBalance();
            getCuentas().get(index).withdraw(sum);
            valorActual = getCuentas().get(index).getBalance();
        }

        return valorViejo != valorActual;
    }

    public boolean payDividend(int numeroCuenta, double sum) {
        double valorActual = 0;
        double valorViejo = 0;
        int index = indexCuenta(numeroCuenta);
        if (index != -1) {
            valorViejo = getCuentas().get(index).getBalance();
            getCuentas().get(index).deposit(sum);
            valorActual = getCuentas().get(index).getBalance();
        }
        return valorViejo != valorActual;
    }

    public double getBalance(int numeroCuenta) {
        double balance = 0;
        int index = indexCuenta(numeroCuenta);
        if (index != -1) {
            balance = getCuentas().get(index).getBalance();
        }
        return balance;
    }

    public void sendLetterToOverdraftAccounts() {
        for (int i = 0; i < getCuentas().size(); i++) {
            if (getCuentas().get(i).getBalance() < 0) {
                System.out.println("Numero de Cuenta: " + cuentas.get(i).getAccountNumber() + " esta en sobregiro/n");
            }
        }
    }

    public boolean cerrarCuenta(int numeroCuenta) {
        int index = indexCuenta(numeroCuenta);
        boolean sePudoCerrar = false;
        if (index != -1) {
            if (getCuentas().get(index).getBalance() == 0) {
                getCuentas().remove(index);
                sePudoCerrar = true;
            } else {
                if (getCuentas().get(index).getBalance() > 0) {
                    System.out.println("La cuenta aun tiene dinero");
                }
                if (getCuentas().get(index).getBalance() < 0) {
                    System.out.println("La cuenta esta en sobregiro");
                }
            }
        } else {
            System.out.println("La cuenta no existe");
        }
        return sePudoCerrar;
    }

    public boolean openAccount(char tipoCuenta, int numeroCuenta, double saldo) {
        Account nuevaCuenta;
        boolean existe = indexCuenta(numeroCuenta) != -1;
        if (!existe) {
            if (tipoCuenta == 'A') {
                nuevaCuenta = new SavingsAccount(0, numeroCuenta);
                getCuentas().add(nuevaCuenta);
            }
            if (tipoCuenta == 'C') {
                nuevaCuenta = new CurrentAccount(numeroCuenta);
                getCuentas().add(nuevaCuenta);
            }
        } else {
            System.out.println("ya existe esta cuenta");
        }

        return !existe;
    }

    public int indexCuenta(int numeroCuenta) {
        int index = -1;
        for (int i = 0; i < getCuentas().size(); i++) {
            if (getCuentas().get(i).getAccountNumber() == numeroCuenta) {
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
