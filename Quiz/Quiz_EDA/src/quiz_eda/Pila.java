/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz_eda;

/**
 *
 * @author auxiliarsc
 * @param <E>
 */
public class Pila<E> {

    private Node<E> cima;
    private int size;

    public Pila() {
    }

    public Pila(Node<E> cima, int size) {
        this.cima = cima;
        this.size = size;
    }

    public void apilar(E dato) {
        if (cima == null) {
            Node<E> nuevo = new Node(dato, null);
            cima = nuevo;
            size++;
        } else {
            Node<E> nuevo = new Node(dato, cima);
            cima = nuevo;
            size++;
        }
    }

    public E desapilar() {
        if (size != 0) {
            Node<E> temporal = cima;
            cima = cima.getNext();
            size--;
            return temporal.getDato();
        } else {
            return null;
        }
    }

    public void printPila() {
        Node node = this.cima;
        while (node != null) {
            System.out.println(node.getDato() + " ");
            node = node.getNext();
        }
    }

    /**
     * @return the cima
     */
    public Node<E> getCima() {
        return cima;
    }

    /**
     * @param cima the cima to set
     */
    public void setCima(Node<E> cima) {
        this.cima = cima;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

}
