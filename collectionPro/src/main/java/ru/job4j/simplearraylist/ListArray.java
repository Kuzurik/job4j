package simpleArrayList;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListArray<E> implements Iterable<E>{
    private Object[] container;
    private final static int DEFAULT_CAPACITY = 10;
    private int position = 0;
    private int modCount = 0;

    public ListArray(){
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public void add(E model) {
        if (this.container.length == this.position) {
            this.container = Arrays.copyOf(this.container, this.position * 2);
        }
        this.container[position++] = model;
        modCount++;
    }

    public E get(int index) {
        if (index > this.container.length) {
            throw new IndexOutOfBoundsException();
        }
        return (E) container[index];
    }

    public void remove(int index) {
        if (index > this.container.length) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(this.container, index + 1, this.container, index, this.container.length - 1 - index );
        position--;
        modCount++;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[cursor++];
            }
        };
    }
}
