package simpleSet;

import simpleArrayList.ListArray;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private ListArray<E> values = new ListArray<>();

    public void add(E e) {
        if (contains(e)) {
            this.values.add(e);
        }
     }

     public boolean contains(E e) {
        boolean result = true;
         for (Object value : this.values) {
             if (value.equals(e)) {
                 result = false;
                 break;
             }
         }
         return result;
     }

    @Override
    public Iterator<E> iterator() {
        return values.iterator();
    }
}
