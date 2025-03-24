/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viaje;

import java.util.LinkedList;

/**
 *
 * @author igork
 */
public class Test {
    public static void main(String[]args){
        LinkedList<Gasto> gastos = new LinkedList<>();
        Viaje viaje = new Viaje("Viaje a Panama", gastos);
        
        Gasto gasto1 = new Gasto("ropa", 111111, 20240225);
        Gasto gasto2 = new Gasto("transporte", 10, 20240226);
        Gasto gasto3 = new Gasto("hospedaje", 100, 20240227);
        Gasto gasto4 = new Gasto("comida", 1000, 20240228);
        Gasto gasto5 = new Gasto("ropa", 1, 20240229);
        Gasto gasto6 = new Gasto("transporte", 10, 20240301);
        Gasto gasto7 = new Gasto("hospedaje", 100, 20240302);
        Gasto gasto8 = new Gasto("comida", 1000, 20240303);
        Gasto gasto9 = new Gasto("ropa", 1, 20240304);
        Gasto gasto10 = new Gasto("transporte", 10, 20240305);
        Gasto gasto11 = new Gasto("hospedaje", 100, 20240306);
        Gasto gasto12 = new Gasto("comida", 1000, 20240307);
        
        viaje.aniadirGasto(gasto1);
        viaje.aniadirGasto(gasto2);
        viaje.aniadirGasto(gasto3);
        viaje.aniadirGasto(gasto4);
        viaje.aniadirGasto(gasto5);
        viaje.aniadirGasto(gasto6);
        viaje.aniadirGasto(gasto7);
        viaje.aniadirGasto(gasto8);
        viaje.aniadirGasto(gasto9);
        viaje.aniadirGasto(gasto10);
        viaje.aniadirGasto(gasto11);
        viaje.aniadirGasto(gasto12);
        
        
        //viaje.dicriminarGastos();
        
        //System.out.println("el gasto mayor es de " + viaje.gastosMayor());
        
        System.out.println("Gastos en comida: " + viaje.gastosEn("comida"));
        
        viaje.comidas.imprimirLista();
        viaje.ropa.imprimirLista();
        viaje.transportes.imprimirLista();
        viaje.hospedajes.imprimirLista();
        
    }
}
