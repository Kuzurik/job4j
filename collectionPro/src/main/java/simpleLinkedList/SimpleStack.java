package simpleLinkedList;

public class SimpleStack<E> {
    private LinkedListSimple<E> linked = new LinkedListSimple<>();

    public E poll() {
        return linked.delete();
    }

    public void push(E value) {
        linked.add(value);
    }
}
