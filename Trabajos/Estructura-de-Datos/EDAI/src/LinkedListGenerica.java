/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author estudiante
 */
public class LinkedListGenerica<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListGenerica() {
    }

    public LinkedListGenerica(Node<E> head, Node<E> tail) {
        this.head = head;
        this.tail = tail;
        size = 1;
    }

    public void addAll(LinkedListGenerica list) {
        Node currentNode = list.head;
        if (list.head != null) {
            while (currentNode != null) {
                this.aniadirFinal((E) currentNode.getDato());
                currentNode = (Node) currentNode.getDato();
            }
        }
    }

    public void aniadirFinal(E ultimo) {
        Node<E> ultimoNodo = new Node<E>(ultimo);

        if (tail == null) {
            head = ultimoNodo;
            tail = ultimoNodo;
            return;
        }
        tail.setNext(ultimoNodo);
        tail = ultimoNodo;
        size++;
    }

    public void aniadirInicio(E primero) {
        Node<E> primeroNodo = new Node<>(primero);

        if (tail == null) {
            head = primeroNodo;
            tail = primeroNodo;
            return;
        }

        primeroNodo.setNext(head);
        head = primeroNodo;
        size++;
    }

    public void aniadirEnPosicion(int posicion, E nuevo) {
        size++;
        Node<E> nodoActual = head;
        Node<E> nuevoNodo = new Node<>(nuevo);

        if (tail == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
            return;
        }

        if (posicion == 0) {
            aniadirInicio(nuevo);
            return;
        }

        for (int i = 0; i < posicion - 1; i++) {
            if (nodoActual == null) {
                return; // Evita Null
            }
            nodoActual = nodoActual.getNext();
        }

        if (nodoActual != null) {
            nuevoNodo.setNext(nodoActual.getNext());
            nodoActual.setNext(nuevoNodo);
            if (nuevoNodo.getNext() == null) {
                tail = nuevoNodo;
            }
        }
    }

    public void eliminarInicio() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }

    public void eliminarFinal() {
        if (head == null) {
            return;
        }
        size--;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node<E> nodoActual = head;
        while (nodoActual.getNext() != tail) {
            nodoActual = nodoActual.getNext();
        }
        nodoActual.setNext(null);
        tail = nodoActual;
    }

    public void imprimirLista() {
        Node<E> nodoActual = head;
        while (nodoActual != null) {
            System.out.println(nodoActual.getDato().toString());
            nodoActual = nodoActual.getNext();
        }
    }

    public void removeData(E data) {
        Node<E> currentNode = head;
        Node<E> previousNode = null;

        if (currentNode == null) {
            return;
        }

        size--;
        if (head.getDato().equals(data)) {
            head = head.getNext();
            return;
        }

        while (currentNode != null) {
            if (currentNode.getNext().getDato().equals(data)) {
                previousNode = currentNode;
                previousNode.setNext(currentNode.getNext().getNext());
                break;
            }
            currentNode = currentNode.getNext();
        }
    }

    public boolean contains(E data) {
        Node<E> currentNode = head;
        boolean contains = false;

        if (head.getDato().equals(data) || tail.getDato().equals(data)) {
            return true;
        } else {
            while (currentNode != null) {
                if (currentNode.getDato().equals(data)) {
                    contains = true;
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
        return contains;
    }

    public void updateData(E old, E now) {
        Node<E> nodoActual = head;

        while (nodoActual != null) {
            if (nodoActual.getDato().equals(old)) {
                nodoActual.setDato(now);
                break;
            }
            nodoActual = nodoActual.getNext();
        }
    }

    public void makeVoid() {
        head = null;
        tail = null;
    }

    public void imprimir() {
        Node<E> aux;
        aux = head;
        while (head != null) {
            System.out.println("Dato: " + aux.getDato());
            aux = aux.getNext();
        }
    }

    /**
     * @return the head
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Node<E> head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public Node<E> getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Node<E> tail) {
        this.tail = tail;
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
