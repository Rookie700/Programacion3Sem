/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.arquitectura.controlador;

import p2.arquitectura.model.Fachada;
import p2.arquitectura.vista.CredentialsVista;
import p2.arquitectura.vista.HomeVista;

/**
 *
 * @author borisperezg
 */
public class HomeControlador {
    
    private HomeVista vista;
    private Fachada fachada;

    public HomeControlador(HomeVista vista) {
        this.vista = vista;
        fachada = Fachada.getInstance();
    }
    
    public void iniciar(){
        CredentialsVista vista = new CredentialsVista();
        vista.setVisible(true);
    }

    public void salir() {
        System.exit(0);
    }
    
    public void mostrarMensajeBienvenida(){
        vista.getLblMensaje().setText(fachada.getWelcomeText());
    }
    
}
