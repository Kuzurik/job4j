package ru.job4j.list;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListToMap() {
        User first = new User(0, "Alex", "Minsk");
        User second = new User(1, "Peter", "Bryansk");
        List<User> list = List.of(first, second);
        Map<Integer, User> result = new UserConvert().process(list);
        Map<Integer, User> expected = Map.of(0, first, 1, second);
        assertThat(result, is(expected));
    }
}
