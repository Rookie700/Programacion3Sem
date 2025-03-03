/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import java.awt.event.ActionListener;
import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {

    BancoVista bankView = new BancoVista();
    Bank bank;

    public BancoControlador(BancoVista bankView) {
        this.bankView = bankView;
        bank = new Bank();
    }

    public void cancelarCuenta() {
        String numeroCuenta = bankView.getTxtNumeroCuenta().getText();
    }

    public void abrirCuenta() {

    }

    public void aplicar() {

    }
}
