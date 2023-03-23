package org.example.node;

public class Node<T> {
    public T element;
    public Node<T> nextElement;

    public Node(T element) {
        this.element = element;
    }
}
