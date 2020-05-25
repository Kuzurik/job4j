package ru.job4j.simplelinkedlist;

public class SimpleStack<E> {
    private LinkedListSimple<E> linked = new LinkedListSimple<>();
    private int size = 0;
    public E poll() {
        this.size--;
        return linked.delete();

    }

    public void push(E value) {
        linked.add(value);
        this.size++;
    }

    public int getSize() {
        return size;
    }
}
