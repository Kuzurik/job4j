package list.deleteForList;

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
        Node<E> value = this.first;
        E result = value.data;
        Node<E> nextLink = value.next;
        this.first = nextLink;
        size--;
        return result;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
      Node(E data) {
          this.data = data;
      }
    }
}
