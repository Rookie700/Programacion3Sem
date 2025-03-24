/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viaje;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author igork
 */
public class Viaje {

    long gastosComida;
    long gastosTransporte;
    long gastosHospedaje;
    long gastosRopa;
    private final String COMIDA, HOSPEDAJE, TRANSPORTE, ROPA;
    String nombre;
    LinkedList<Gasto> gastos;
    ArrayList<LinkedList> gastosTipo;
    LinkedList<Gasto> comidas;
    LinkedList<Gasto> hospedajes;
    LinkedList<Gasto> transportes;
    LinkedList<Gasto> ropa;

    public Viaje(String nombre, LinkedList<Gasto> gastos) {

        COMIDA = "comida";
        HOSPEDAJE = "hospedaje";
        TRANSPORTE = "transporte";
        ROPA = "ropa";
        this.nombre = nombre;
        this.gastos = gastos;
        gastosTipo = new ArrayList<>();
        ropa = new LinkedList<>();
        transportes = new LinkedList<>();
        comidas = new LinkedList<>();
        hospedajes = new LinkedList<>();
        gastosTipo.add(ropa);
        gastosTipo.add(hospedajes);
        gastosTipo.add(comidas);
        gastosTipo.add(transportes);
    }

    public void aniadirGasto(Gasto ultimo) {
        gastos.aniadirFinal(ultimo);
    }

    public LinkedList<Gasto> elegirTipoGasto(String tipo) {
        LinkedList<Gasto> listaGastos = new LinkedList<>();
        if (tipo.equals(COMIDA)) {
            listaGastos = comidas;
        }
        if (tipo.equals(HOSPEDAJE)) {
            listaGastos = hospedajes;
        }
        if (tipo.equals(ROPA)) {
            listaGastos = ropa;
        }
        if (tipo.equals(TRANSPORTE)) {
            listaGastos = transportes;
        }
        return listaGastos;
    }

    public long recorrerGastos(LinkedList tipo) {
        Iterator<Gasto> iterador = tipo.iterator();
        long cantidadGastos = 0;

        while (iterador.hasNext()) {
            Gasto elemento = iterador.hasNext() ? iterador.next() : null;

            cantidadGastos += elemento.getValor();

        }
        return cantidadGastos;
    }

    public void cantidadGastos() {
        gastosComida = recorrerGastos(comidas);
        gastosRopa = recorrerGastos(ropa);
        gastosHospedaje = recorrerGastos(hospedajes);
        gastosTransporte = recorrerGastos(transportes);

    }

    public String gastosMayor() {
        actualizarViaje();
        String valor = "";
        if (gastosComida > gastosHospedaje && gastosComida > gastosRopa && gastosComida > gastosTransporte) {
            valor = COMIDA;
        } else if (gastosRopa > gastosHospedaje && gastosRopa > gastosComida && gastosRopa > gastosTransporte) {
            valor = ROPA;
        } else if (gastosHospedaje > gastosComida && gastosHospedaje > gastosRopa && gastosHospedaje > gastosTransporte) {
            valor = HOSPEDAJE;
        } else {
            valor = TRANSPORTE;
        }

        return valor;
    }

    public void dicriminarGastos() {
        Iterator<Gasto> iterador = gastos.iterator();

        while (iterador.hasNext()) {
            Gasto elemento = iterador.hasNext() ? iterador.next() : null;
            System.out.println(elemento.tipo);
            if (elemento.getTipo().equals(COMIDA)) {
                comidas.aniadirInicio(elemento);
                continue;
            }
            if (elemento.getTipo().equals(ROPA)) {
                ropa.aniadirInicio(elemento);
                continue;
            }
            if (elemento.getTipo().equals(HOSPEDAJE)) {
                hospedajes.aniadirInicio(elemento);
                continue;
            }
            if (elemento.getTipo().equals(TRANSPORTE)) {
                transportes.aniadirInicio(elemento);
                continue;
            }

        }
    }

    public long gastosEn(String tipo) {
        actualizarViaje();
        long gastos = 0;
        LinkedList<Gasto> listaElegida = elegirTipoGasto(tipo);
        gastos = recorrerGastos(listaElegida);
        return gastos;

    }

    public void actualizarViaje() {
        dicriminarGastos();
        cantidadGastos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(LinkedList<Gasto> gastos) {
        this.gastos = gastos;
    }

    public ArrayList<LinkedList> getGastosTipo() {
        return gastosTipo;
    }

    public void setGastosTipo(ArrayList<LinkedList> gastosTipo) {
        this.gastosTipo = gastosTipo;
    }
}
