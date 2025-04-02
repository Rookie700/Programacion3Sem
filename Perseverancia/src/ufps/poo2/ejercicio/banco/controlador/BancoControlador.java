/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {

    private BancoVista vista;
    private Bank fachada;

    public BancoControlador(BancoVista vista) {
        this.vista = vista;
        fachada = new Bank();
    }

    public void crearCuenta() {
        char tipoCuenta = 0;
        if (vista.getRbAhorros().isSelected()) {
            tipoCuenta = 'S';
        } else if (vista.getRbCorriente().isSelected()) {
            tipoCuenta = 'C';
        }

        try {
            fachada.crearCuenta(vista.getTxtNumeroCuenta().getText(), vista.getTxtSaldoCuenta().getText(), tipoCuenta);
            mostrarMensaje("La cuenta " + vista.getTxtNumeroCuenta().getText() + " se creó exitosamente");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }

        vista.getTxtNumeroCuenta().setText("");
        vista.getTxtSaldoCuenta().setText("");
    }

    public void realizarOperacionSeleccionada() {

        if (vista.getRbRetirar().isSelected()) {

            try {
                String msg = fachada.retirar(vista.getTxtNumeroCuentaAcciones().getText(), vista.getTxtValor().getText());
                mostrarMensaje("Se retiró exitosamente. " + msg);
                vista.getTxtNumeroCuentaAcciones().setText("");
                vista.getTxtValor().setText("");
            } catch (Exception e) {
                mostrarMensaje(e.getMessage());
            }

        } else if (vista.getRbDividendos().isSelected()) {
            try {
                String msg = fachada.depositar(vista.getTxtNumeroCuentaAcciones().getText(), vista.getTxtValor().getText());
                mostrarMensaje("Se depositó exitosamente. " + msg);
                vista.getTxtNumeroCuentaAcciones().setText("");
                vista.getTxtValor().setText("");
            } catch (Exception e) {
                mostrarMensaje(e.getMessage());
            }
        }

    }

    public void listarCuentas() {
        try {
            for (int i = 0; i < fachada.listarCuentas().size(); i++) {
                mostrarMensaje(fachada.listarCuentas().get(i).toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(BancoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void mostrarMensaje(String str) {
        vista.getTaMensajes().append(str + "\n");
    }

}
