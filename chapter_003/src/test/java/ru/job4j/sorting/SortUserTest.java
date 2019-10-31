package ru.job4j.sorting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class SortUserTest {
    @Test
    public void whenSortingUsers() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(new User("Arkadiy", 47),
                                 new User("Sergey", 31),
                                 new User("Mikhail", 20)
                                 ));
        Set<User> result = user.sort(list);
        Set<User> expected = new TreeSet<>();
        expected.addAll(Arrays.asList(new User("Mikhail", 20),
                                      new User("Sergey", 31),
                                      new User("Arkadiy", 47)
                ));
        assertThat(result, is(expected));
    }
}
