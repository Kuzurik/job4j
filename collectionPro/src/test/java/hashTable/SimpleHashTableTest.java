package hashTable;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleHashTableTest {
    private SimpleHashTable<String, String> map = new SimpleHashTable<>();


    @Before
    public void before() {
        map.insert("first","1");
        map.insert("second","2");
        map.insert("third","3");
        map.insert("fourth","4");
        map.insert("fifth","5");
        map.insert("sixth","6");
    }

    @Test
    public void whenInsertFourElements() {
        assertThat(map.size(), is(6));
        assertThat(map.get("fourth"), is("4"));
    }

    @Test
    public void whenDeleteFifthItem() {
        map.delete("third");
        assertThat(map.size(), is(5));
    }

    @Test
    public void whenIterator() {
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(),is(true));
        assertThat(it.hasNext(),is(true));
        assertThat(it.next(),is("6"));
        assertThat(it.next(),is("3"));
        assertThat(it.next(),is("5"));
        assertThat(it.next(),is("4"));
        assertThat(it.next(),is("1"));
        assertThat(it.next(),is("2"));
        assertThat(it.hasNext(),is(false));
    }
}
