/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.arquitectura.controlador;

import p2.arquitectura.model.Fachada;
import p2.arquitectura.util.DataTransfer;
import p2.arquitectura.vista.WelcomeScreenVista;

/**
 *
 * @author borisperezg
 */
public class WelcomeScreenControlador {
    
    private WelcomeScreenVista vista;
    private Fachada fachada;

    public WelcomeScreenControlador(WelcomeScreenVista vista) {
        this.vista = vista;
        fachada = Fachada.getInstance();
    }
    
    public void obtenerNombreUsuario(){
        DataTransfer df = DataTransfer.getInstance();
        vista.getLblNombreUsuario().setText(df.getNombreCompleto());
    }
    
}
