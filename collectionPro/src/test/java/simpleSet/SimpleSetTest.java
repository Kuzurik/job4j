package simpleSet;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleSetTest {
    private SimpleSet<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleSet<>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
    }


    @Test
    public void whenTestIterator() {
        Iterator interList = list.iterator();
        assertThat(interList.hasNext(), is(true));
        assertThat(interList.next(), is(0));
        assertThat(interList.next(), is(1));
        assertThat(interList.next(), is(2));
        assertThat(interList.next(), is(3));
        assertThat(interList.hasNext(), is(false));
    }
}
