package implementationSimpleArray;

import generic.implementationSimpleArray.SimpleArray;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    private SimpleArray<Integer> array = new SimpleArray<>(2);
    private Iterator<Integer> integerIterator = array.iterator();

    @Test
    public void whenCheckOperationMethodAdd() {
        array.add(1);
        int expected = 1;
        assertThat(array.get(0), is(expected));
    }

    @Test
    public void whenCheckOperationMethodGet() {
        array.add(1);
        int result = array.get(0);
        int expected = 1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCheckOperationMethodRemove() {
        array.add(1);
        array.add(2);
        array.remove(0);
        int result = array.get(0);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCheckOperationMethodSet() {
        array.add(1);
        array.add(2);
        array.set(0, 10);
        int result = array.get(0);
        int expected = 10;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCheckOperationMethodIterator() {
        array.add(1);
        array.add(2);
        Integer result1 = 1;
        Integer result2 = 2;
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(result1, is(integerIterator.next()));
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(result2, is(integerIterator.next()));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorEmptyTest() {
        assertThat(integerIterator.hasNext(), is(false));
        integerIterator.next();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCheckOperationMethodAddEmptyTest() {
        array.add(1);
        array.add(2);
        array.add(3);
    }
}
