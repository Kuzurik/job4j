package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    public E delete() {
        if (this.size == 0) {
          throw new NoSuchElementException();
        }
        Node<E> values = this.first;
        this.first = this.first.next;
        values.next = null;
        size--;
        return values.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
      Node(E data) {
          this.data = data;
      }
    }
}