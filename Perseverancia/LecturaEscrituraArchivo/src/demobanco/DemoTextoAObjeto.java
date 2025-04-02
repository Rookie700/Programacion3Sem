/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demobanco;

/**
 *
 * @author ing
 */
public class DemoTextoAObjeto {
    public static void main(String[] args) {
        Banco b = new Banco();
        b.cargarCuentasArchivo();
        b.printNames();
    }
}
