/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

/**
 *
 * @author igork
 */
public class SumaMatriz {

    public boolean suma(int[] matriz, int numero) {
        boolean siSuma = false;
        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] % 2 == 0) {
                suma += matriz[i];
            }
        }

        if (suma == numero) {
            siSuma = true;
        }

        return siSuma;
    }
}
