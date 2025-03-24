/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_eda;

/**
 *
 * @author auxiliarsc
 */
public class Reemplazar {

    public Pila reemplazar(Pila pila, int nuevo, int viejo) {
        Pila aux = new Pila();
        boolean sePudo = false;
        while (pila.getCima() != null && !sePudo) {
            if (pila.getCima().getDato().equals(viejo)) {
                pila.getCima().setDato(nuevo);
                sePudo = true;
            } else {
                aux.apilar(pila.desapilar());
            }
        }
        if (sePudo) {
            while (aux.getCima() != null) {
                pila.apilar(aux.desapilar());
            }
        }
        return pila;
    }

    public Pila ordenarMenor(Pila pila) {
        Pila aux = new Pila();
        int menor = 0;
        while (pila.getCima() != null) {
            if ((int) pila.getCima().getDato() == menor) {
                pila.desapilar();
            }
            if ((int) pila.getCima().getDato() < menor) {
                menor = (int) pila.getCima().getDato();
                aux.apilar(pila.desapilar());
            }
        }
        while (aux.getCima() != null) {
            pila.apilar(aux.desapilar());
        }
        return pila;
    }

    public Pila agregarPila(Pila pila, int n) {
        boolean existe = false;
        Pila auxN = new Pila();
        Pila auxX = new Pila();

        while (pila.getCima() != null && !existe) {
            if ((int) pila.getCima().getDato() == n) {
                existe = true;
                auxN.apilar(pila.desapilar());
            } else {
                auxX.apilar(pila.desapilar());
            }
        }
        if (existe) {
            while (auxX.getCima() != null) {
                pila.apilar(auxX.desapilar());
                if (auxX.getCima() == null) {
                    pila.apilar(auxN.desapilar());
                }
            }
        } else {
            while (auxX.getCima() != null) {
                pila.apilar(auxX.desapilar());
                if (auxX.getCima() == null) {
                    pila.apilar(n);
                }
            }
        }
        return pila;
    }
    
    
}
