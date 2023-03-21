package org.example;

public class Nodes {
    private Nodes() {}

    /**
     * Creates new instance of {@link Node} that holds provided element
     * @param element any element of type T
     * @return a new instance of {@link Node}
     * @param <T> generic type
     */
    public static <T> Node<T> create(T element) {
        return new Node<>(element);
    }

    /**
     * Creates a connection between two instances of provided {@link Node} elements, assigns the first element a reference to the second
     * @param frstElement any {@link Node} object
     * @param scndElement any {@link Node} object
     * @param <T> generic type
     */
    public static <T> void link(Node<T> frstElement, Node<T> scndElement) {
        frstElement.nextElement = scndElement;
    }

    /**
     * Creates two new {@link Node} objects and assigns the first element a reference to the second
     * @param frstElement any element of type T
     * @param scndElement any element of type T
     * @return a reference to the first node
     * @param <T> generic type
     */
    public static <T> Node<T> pairOf(T frstElement, T scndElement) {
        Node<T> firstE = new Node<>(frstElement);
        firstE.nextElement = new Node<>(scndElement);
        return firstE;
    }

    /**
     * Creates two new {@link Node} objects and connects them together
     * @param frstElement any element of type T
     * @param scndElement any element of type T
     * @return a reference to the first node
     * @param <T> generic type
     */
    public static <T> Node<T> closedPairOf(T frstElement, T scndElement) {
        Node<T> firstE = new Node<>(frstElement);
        Node<T> secondE = new Node<>(scndElement);
        firstE.nextElement = secondE;
        secondE.nextElement = firstE;
        return firstE;
    }

    /**
     * Creates a linked chain of {@link Node} objects based of provided elements.
     * @param elements an array of elements of type T
     * @return a reference to the first element of chain
     * @param <T> generic type
     */
    public static <T> Node<T> chainOf(T... elements) {
        Node<T> firstE = new Node<>(elements[0]);
        Node<T> currentE = firstE;
        for (int i = 1; i < elements.length; i++) {
            currentE.nextElement = new Node<>(elements[i]);
            currentE = currentE.nextElement;
        }
        return firstE;
    }

    /**
     * Creates a closed linked chain of {@link Node} objects based of provided elements.
     * @param elements an array of elements of type T
     * @return a reference to the first element of chain
     * @param <T> generic type
     */
    public static <T> Node<T> closedChainOf(T... elements) {
        Node<T> firstE = new Node<>(elements[0]);
        Node<T> currentE = firstE;
        for (int i = 1; i < elements.length; i++) {
            currentE.nextElement = new Node<>(elements[i]);
            currentE = currentE.nextElement;
        }
        currentE.nextElement = firstE;
        return firstE;
    }

}
