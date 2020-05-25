package ru.job4j.simplelinkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListSimple<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public void add(E data) {
        if (this.size == 0) {
            Node<E> newLink = new Node<>(data);
            this.first = newLink;
            this.last = newLink;
        } else {
            Node<E> newLink = new Node<>(data);
            newLink.prev = this.last;
            last.next = newLink;
            this.last = newLink;
        }
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        if (index > this.size) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
                result = result.next;
        }
            return result.item;
    }

    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    Node<E> node(int index) {
        Node<E> node = this.first;
          for (int i = 0; i < index; i++) {
               node = node.next;

        }
        return node;
    }

    public E remove(int index) {
        if (index > this.size) {
            throw new NoSuchElementException();
        }
        return unlink(node(index));
    }

    public E delete() {
        Node<E> result = this.first;
        if (this.size != 0) {
            this.first = result.next;
            size--;
        }
        return result.item;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.item = element;
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> node = first;
            private int expectedModCount = modCount;
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = node.item;
                node = node.next;
                cursor++;
                return result;
            }
        };
    }
}
