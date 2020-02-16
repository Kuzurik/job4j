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
        for(int i = index; i != numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if(!hasNext()) throw new NoSuchElementException();
        while (this.numbers[index] % 2 != 0 && index < numbers.length -1){
                index++;
        }
        return numbers[index++];
    }
}