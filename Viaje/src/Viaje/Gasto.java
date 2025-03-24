/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viaje;

/**
 *
 * @author igork
 */
public class Gasto {

    String tipo;
    double valor;
    int fecha;

    public Gasto(String tipo, long valor, int fecha) {
        this.tipo = tipo;
        this.valor = valor;
        this.fecha = fecha;
    }

    //
    @Override
    public String toString() {
        return "1)Tipo: " + getTipo() + " 2)Valor: " + getValor() + " 3)Fecha: " + getFecha();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
}
