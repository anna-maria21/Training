package org.example;

import org.example.node.Node;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class LinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public static <T> List<T> of(T... elements) {
        List<T> linkedList = new LinkedList<>();
        Stream.of(elements)
                .forEach(linkedList::add);
        return linkedList;
    }
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.nextElement;
        }
        return current;
    }
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            first = last = newNode;
        } else {
            last.nextElement = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size+1);
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.nextElement = first;
            first = newNode;
        } else if (index == size) {
            last.nextElement = newNode;
            last = newNode;
        } else {
            Node<T> cur = getNodeByIndex(index-1);
            newNode.nextElement = cur.nextElement;
            cur.nextElement = newNode;
        }
        size++;
    }


    public void show() {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            System.out.println(current.element);
            current = current.nextElement;
        }
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size-1);
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.nextElement;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prevE = getNodeByIndex(index-1);
            removedElement = prevE.nextElement.element;
            prevE.nextElement = prevE.nextElement.nextElement;
            if (index == size-1) {
                last = prevE;
            }
        }
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.nextElement;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }
}
