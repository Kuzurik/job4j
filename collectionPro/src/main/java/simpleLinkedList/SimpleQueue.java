package simpleLinkedList;

public class SimpleQueue<E> {
   private SimpleStack<E> container = new SimpleStack<>();
   private SimpleStack<E> reversContainer = new SimpleStack<>();

   public E poll() {
        while (container.getSize() < 0) {
            reversContainer.push(container.poll());
        }
    return container.poll();
    }

    public void push(E value) {
        this.container.push(value);
    }

}
