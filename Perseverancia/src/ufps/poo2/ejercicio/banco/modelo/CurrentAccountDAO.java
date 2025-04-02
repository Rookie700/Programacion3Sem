/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class CurrentAccountDAO implements IDAO {

    String archivo = "C:\\Users\\igork\\OneDrive\\Escritorio\\Perseverancia\\HerenciaBancoBase\\src\\ufps\\poo2\\ejercicio\\banco\\textoPlano\\currentAccounts.txt";

    @Override
    public void add(Account dto) {
        String numeroCuenta = String.valueOf(dto.getAccountNumber());
        if (!ArchivoCuentas.Contains(numeroCuenta)) {
            ArchivoCuentas.add(archivo, dto);
        } else {
            System.out.println("La cuenta ya existe");
        }
    }

    @Override
    public void delete(String numeroCuenta) {
    }

    @Override
    public void update(String numeroCuenta, Account dto) {
    }

    @Override
    public ArrayList<Account> list() {
        ArrayList<Account> lista = ArchivoCuentas.listar(archivo, 'C');
        return lista;
    }

    @Override
    public Account find(int numeroCuenta) {
        return null;
    }

    @Override
    public void actualizarSaldo(String numeroCuenta, double nuevoSaldo) {
        ArchivoCuentas.actualizarSaldo(archivo, numeroCuenta, nuevoSaldo);
        
    }

}
