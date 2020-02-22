package iterator.iteratorForEven;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForEven implements Iterator {
    private final int[] numbers;
    private int index = 0;

    public IteratorForEven(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (this.numbers.length > index) {
            if (this.numbers[index] % 2 == 0) {
                result = true;
                break;
            }
                index++;
        }
        return result;
    }

    @Override
    public Object next() {
        if(!hasNext()) throw new NoSuchElementException();
        return numbers[index++];
    }
}
