package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> {
    private Object[] objects;
    private int position = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        }

        public void add(T model) {
            this.objects[position++] = model;
        }

    public void set(int index, T model) {
       if (index > position) {
           throw new IndexOutOfBoundsException();
       }
        this.objects[index] = model;
    }

    public T get(int index) {
        return (T) this.objects[index];
    }

    public void remove(int index) {
        if (index > this.position) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
        position--;
    }

    public int length() {
        return this.objects.length;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No elements");
                }
                return (T) objects[index++];
            }
        };
    }


}
