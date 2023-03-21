package org.example.node;

public class Node<T> {
    T element;
    Node<T> nextElement;

    public Node(T element) {
        this.element = element;
    }
}
