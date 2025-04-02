/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IDAO {

    public void add(Account dto);

    public void delete(String numeroCuenta);

    public void update(String numeroCuenta, Account dto);

    public List<Account> list();

    public Account find(int numeroCuenta);
    
    public void actualizarSaldo(String numeroCuenta, double nuevoSaldo);
}
