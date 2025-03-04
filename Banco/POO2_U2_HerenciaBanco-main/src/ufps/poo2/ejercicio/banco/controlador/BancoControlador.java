/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {

    BancoVista vista;
    Bank bank;

    public BancoControlador(BancoVista bankView) {
        this.vista = bankView;
        bank = new Bank();
    }

    //vista.getBtnAplicar().
    public void cancelarCuenta() {
        String numeroCuenta = vista.getTxtNumeroCuenta().getText();
        //String saldoCuenta = bankView.getTxtSaldoCuenta().getText();
        /*char tipoCuenta = ' ';
        if(bankView.getRbAhorros().isSelected()){
            tipoCuenta = 'A';
        }
        if(bankView.getRbCorriente().isSelected()){
            tipoCuenta = 'C';
        }*/
        if (bank.cerrarCuenta(Integer.parseInt(numeroCuenta))) {
            vista.getTaMensajes().setText("Se cerro la cuenta de numero" + numeroCuenta);
        } else {
            vista.getTaMensajes().setText("No se pudo cerrar");
        }
        actualizarGUI();
    }

    public void abrirCuenta() {
        String numeroCuenta = vista.getTxtNumeroCuenta().getText();
        String saldoCuenta = vista.getTxtSaldoCuenta().getText();
        char tipoCuenta = ' ';
        if (vista.getRbAhorros().isSelected()) {
            tipoCuenta = 'A';
        }
        if (vista.getRbCorriente().isSelected()) {
            tipoCuenta = 'C';
        }
        if (bank.openAccount(tipoCuenta, Integer.parseInt(numeroCuenta), Double.parseDouble(saldoCuenta))) {
            if (tipoCuenta == 'A') {
                vista.getTaMensajes().setText("Se abrio una cuenta de Ahorros de numero: " + numeroCuenta);
            }
            if (tipoCuenta == 'C') {
                vista.getTaMensajes().setText("Se abrio una cuenta Corriente de numero: " + numeroCuenta);
            }
        } else {
            vista.getTaMensajes().setText("ya existe una cuenta con este numero: " + numeroCuenta + "\n");
        }
        actualizarGUI();
    }

    public void aplicar() {
        String numeroCuenta = vista.getTxtNumeroCuentaAcciones().getText();
        String valor = vista.getTxtValor().getText();
        if (vista.getRbDividendos().isSelected()) {
            if (bank.payDividend(Integer.parseInt(numeroCuenta), Double.parseDouble(valor))) {
                vista.getTaMensajes().setText("Se pagaron dividendos de: " + Double.valueOf(valor));
            }
            actualizarGUI();
        }
        if (vista.getRbRetirar().isSelected()) {
            if (bank.withdrawAccount(Integer.parseInt(numeroCuenta), Double.parseDouble(valor))) {
                vista.getTaMensajes().setText("Se retiro un valor de: " + Double.valueOf(valor));
            }
            actualizarGUI();
        }
    }

    public void enviarCorreos() {
        bank.sendLetterToOverdraftAccounts();
    }

    public void cancelar() {
        actualizarGUI();
    }

    public void actualizarGUI() {
        vista.getTxtNumeroCuenta().setText("");
        vista.getTxtNumeroCuentaAcciones().setText("");
        vista.getTxtSaldoCuenta().setText("");
        vista.getTxtValor().setText("");
        vista.getRbAhorros().setSelected(false);
        vista.getRbCorriente().setSelected(false);
        vista.getRbDividendos().setSelected(false);
        vista.getRbRetirar().setSelected(false);
    }
}
