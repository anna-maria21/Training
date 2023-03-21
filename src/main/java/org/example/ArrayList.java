package org.example;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayList<T> implements List<T> {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 5;
    private int size;

    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public static <T> List<T> of(T... elements) {
        List<T> list = new ArrayList<>();
        Stream.of(elements)
                .forEach(list::add);
        return list;
    }

    @Override
    public void add(T element) {
        resizeIfNeeded();
        elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size+1);
        resizeIfNeeded();
        System.arraycopy(elements, index, element, index+1, size-index);
        elements[index] = element;
        size++;
    }

    private void resizeIfNeeded() {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length*2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        elements[index] = element;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return (T) elements[size-1];
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index+1, elements, index, size-index-1);
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(T element) {
        for(Object e : elements) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }
}
