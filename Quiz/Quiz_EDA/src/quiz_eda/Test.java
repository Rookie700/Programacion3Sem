/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_eda;

/**
 *
 * @author auxiliarsc
 */
public class Test {

    public static void main(String[] args) {
        Reemplazar o = new Reemplazar();
        Pila<Integer> p = new Pila();
        p.apilar(5);
        p.apilar(2);
        p.apilar(8);
        p.apilar(6);
        p.apilar(4);
        p = o.reemplazar(p, 7, 2);
        p.printPila();
    }
}
