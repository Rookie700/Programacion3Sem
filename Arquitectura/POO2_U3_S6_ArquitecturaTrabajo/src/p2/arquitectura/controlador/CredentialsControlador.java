/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.arquitectura.controlador;

import javax.swing.JOptionPane;
import p2.arquitectura.model.Fachada;
import p2.arquitectura.util.DataTransfer;
import p2.arquitectura.vista.CredentialsVista;
import p2.arquitectura.vista.WelcomeScreenVista;

/**
 *
 * @author borisperezg
 */
public class CredentialsControlador {

    private CredentialsVista vista;
    private Fachada fachada;

    public CredentialsControlador(CredentialsVista vista) {
        this.vista = vista;
        fachada = Fachada.getInstance();
    }

    public void validarCredenciales() {
        String usuario = vista.getTxtUser().getText();
        String pass = vista.getTxtPass().getText();
        
//        System.out.println("P = "+pass);

        try {
            String nombreCompleto = fachada.validarCredenciales(usuario, pass);

            DataTransfer d = DataTransfer.getInstance();
            d.setNombreCompleto(nombreCompleto);
            
//            System.out.println("Sube a DT");
            
            WelcomeScreenVista wVista = new WelcomeScreenVista();
            wVista.setVisible(true);

            vista.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
