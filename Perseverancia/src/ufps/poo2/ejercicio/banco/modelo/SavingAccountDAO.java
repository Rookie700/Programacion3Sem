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
public class SavingAccountDAO implements IDAO {

    String archivo = "src/ufps/poo2/ejercicio/banco/textoPlano/savingAccounts.txt";

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(String numeroCuenta, Account dto) {

    }

    @Override
    public ArrayList<Account> list() {
        ArrayList<Account> lista = ArchivoCuentas.listar(archivo, 'A');
        return lista;
    }

    @Override
    public Account find(int numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarSaldo(String numeroCuenta, double nuevoSaldo) {
        ArchivoCuentas.actualizarSaldo(archivo, numeroCuenta, nuevoSaldo);
    }

}
