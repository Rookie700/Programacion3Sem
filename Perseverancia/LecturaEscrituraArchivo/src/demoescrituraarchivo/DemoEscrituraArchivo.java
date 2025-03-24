/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoescrituraarchivo;

/**
 *
 * @author ing
 */
public class DemoEscrituraArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String archivo = "src/cuentas.txt";
        String numeroCuenta = "00017";
        double nuevoSaldo = 1500;

        (new ArchivoCuentas()).actualizarSaldo(archivo, numeroCuenta, nuevoSaldo);
        System.out.println("Saldo actualizado correctamente.");
    }
    
}
