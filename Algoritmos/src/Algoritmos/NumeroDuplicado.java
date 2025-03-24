/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

/**
 *
 * @author igork
 */
public class NumeroDuplicado {
    public int numeroDuplicado(int[] numeros){
        int duplicado = 0;
        int numeroFinal = -1;
        int resultadoEsperado = numeros.length * (numeros.length-1) / 2;
        
        for (int i = 0; i < numeros.length; i++) {
            duplicado += numeros[i];
            numeroFinal++;
        }
        
        duplicado = numeroFinal-(resultadoEsperado - duplicado);
        
        
        return duplicado;
    }
}
