package hashTable;

import java.util.*;


public class SimpleHashTable<K, V> implements Iterable<V> {

    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] items =(Node<K, V>[]) new Node[DEFAULT_CAPACITY];
    private int size = 0;
    private int modCount = 0;


    public boolean insert(K key, V value) {
        int position = findBucket(key);
        if (size == this.items.length) {
            increase();
        }

        if (this.items[position] != null) {
            if (this.items[position].getKey().equals(key)) {
                this.items[position] = new Node<>(key, value);
                return true;
            }
            return false;
        }
        this.items[position] = new Node<>(key, value);
        this.size++;
        this.modCount++;
        return true;
    }

    public int findBucket(K key) {
        return hash(key) & (items.length -1);
    }

    public int hash(K key) {
        int h;
        return (h = key.hashCode()) ^ h >>> 16;
    }

    public V get(K key) {
        return this.items[findBucket(key)].getValue();
    }

    public int size() {
        return this.size;
    }

    public boolean delete(K key) {
        boolean result = false;
        int position = findBucket(key);
        if (this.items[position].getKey().equals(key)){
            this.items[position] = null;
            this.size--;
            this.modCount++;
            result = true;
        }
        return result;
    }

    public void increase() {
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            int cursor = 0;


            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                while (items.length > cursor) {
                    if (items[cursor] != null) {
                        result = true;
                        break;
                    }
                    cursor++;
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return items[cursor++].getValue();
            }
        };
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

}
