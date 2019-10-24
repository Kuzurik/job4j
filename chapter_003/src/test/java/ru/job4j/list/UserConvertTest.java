package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListToMap() {
        List<User> list = new ArrayList<>();
        User first = new User(0, "Alex", "Minsk");
        User second = new User(1, "Peter", "Bryansk");
        list.add(first);
        list.add(second);
        HashMap<Integer, User> result = new UserConvert().process(list);
        HashMap<Integer, User> expected = new HashMap<Integer, User>();
        expected.put(0, first);
        expected.put(1, second);
        assertThat(result, is(expected));
    }
}
