/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

/**
 *
 * @author igork
 */
public class NumeroFaltante {

    public int busquedaFaltante(int[] matriz) {
        int numeroFaltante = -1;
        int i = 0;

        while (numeroFaltante == -1) {
            if (i != matriz[i] - 1) {
                numeroFaltante = i + 1;
            }
        }
        return numeroFaltante;
    }
}
