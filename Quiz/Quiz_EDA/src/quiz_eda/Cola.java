/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_eda;

/**
 *
 * @author auxiliarsc
 */
public class Cola<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

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
