/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author estudiante
 */
public class Node<E> {

    private E dato;
    private Node<E> next;

    public Node() {
    }

    public Node(E dato) {
        this.dato = dato;
    }

    public Node(E dato, Node<E> next) {
        this.dato = dato;
        this.next = next;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
