package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> cuentas;

    public Bank() {
        cuentas = new ArrayList<>();
    }

    /**
     *
     * @param numero
     * @param saldo
     * @param tipo S para SavingAccount, C para CurrentAccount
     * @throws java.lang.Exception
     */
    public void crearCuenta(String numero, String saldo, char tipo) throws Exception {

        int numCuenta = 0;

        try {
            numCuenta = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            throw new Exception("El número de cuenta es numérico");
        }

        double balance = 0;

        try {
            balance = Double.parseDouble(saldo);
        } catch (NumberFormatException e) {
            throw new Exception("El número del saldo es numérico");
        }
        switch (tipo) {
            case 'S':
                new SavingAccount(numCuenta, 0.15, balance);
                break;
            case 'C':
                double valorSobregiro = balance * 0.2;
                new CurrentAccount(numCuenta, valorSobregiro, balance);
                break;
        }

        /*try {
            cuenta.deposit(balance);
            cuentas.add(cuenta);
        } catch (NullPointerException e) {
            throw new Exception("La cuenta no se pudo crear");
        }*/
    }

    public String depositar(String numeroCuenta, String valor) throws Exception {
        Account cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new Exception("No se encontró la cuenta");
        }

        double balance = 0;

        try {
            balance = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new Exception("El número del saldo es numérico");
        }

        cuenta.deposit(balance);

        return "Cuenta " + numeroCuenta + "::: Nuevo saldo = " + cuenta.getBalance();

    }

    public String retirar(String numeroCuenta, String valor) throws Exception {
        Account cuenta = buscarCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new Exception("No se encontró la cuenta");
        }

        double balance = 0;

        try {
            balance = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            throw new Exception("El número del saldo es numérico");
        }

        cuenta.withdraw(balance);
        return "Cuenta " + numeroCuenta + "::: Nuevo saldo = " + cuenta.getBalance();
    }

    public ArrayList<Account> listarCuentas() throws Exception {
        ArrayList<Account> listaAhorros = new SavingAccount().listAccounts();
        ArrayList<Account> listaCorriente = new CurrentAccount().listAccounts();
        ArrayList<Account> lista = new ArrayList();
        lista.addAll(listaAhorros);
        lista.addAll(listaCorriente);

        return lista;
    }

    private Account buscarCuenta(String numeroCuenta) throws Exception {

        int numCuenta = 0;

        try {
            numCuenta = Integer.parseInt(numeroCuenta);
        } catch (NumberFormatException e) {
            throw new Exception("El número de cuenta es numérico");
        }
        
        ArrayList<Account> lista = listarCuentas();
        
        for (int i = 0; i < lista.size(); i ++) {
            if (lista.get(i).getAccountNumber() == numCuenta) {
                return lista.get(i);
            }
        }
        return null;
    }

}
