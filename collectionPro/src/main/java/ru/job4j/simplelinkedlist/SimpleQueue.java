package simpleLinkedList;

public class SimpleQueue<E> {
   private SimpleStack<E> out = new SimpleStack<>();
   private SimpleStack<E> in = new SimpleStack<>();

   public E poll() {
        while (this.out.getSize() < 0) {
            this.in.push(this.out.poll());
        }
    return this.out.poll();
    }

    public void push(E value) {
        this.out.push(value);
    }

}
