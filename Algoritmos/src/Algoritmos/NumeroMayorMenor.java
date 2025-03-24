/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

/**
 *
 * @author igork
 */
public class NumeroMayorMenor {

    public int[] numeroMayorMenor(int[] matriz) {
        int mayor = 0;
        int menor = 999999999;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] > mayor) {
                mayor = matriz[i];
            }
            if (matriz[i] < menor) {
                menor = matriz[i];
            }
        }

        return new int[]{mayor, menor};
    }
}
