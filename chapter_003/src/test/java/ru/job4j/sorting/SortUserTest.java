package ru.job4j.sorting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class SortUserTest {
    @Test
    public void whenSortingUsers() {
        SortUser user = new SortUser();
        List<User> list = List.of(new User("Arkadiy", 47),
                                  new User("Sergey", 31),
                                  new User("Mikhail", 20));
        Set<User> result = user.sort(list);
        Set<User> expected = Set.of(new User("Mikhail", 20),
                                      new User("Sergey", 31),
                                      new User("Arkadiy", 47));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortingNameLength() {
        SortUser user = new SortUser();

        User user1 = new User("Alex", 25);
        User user2 = new User("Mikhail", 47);
        User user3 = new User("Sergey", 31);
        List<User> list = List.of(user1, user2, user3);
        List<User> result = user.sortNameLength(list);
        List<User> expected =List.of(user1, user3, user2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortingAllFields() {
        SortUser user = new SortUser();
        User user1 = new User("Alex", 31);
        User user2 = new User("Mikhail", 47);
        User user3 = new User("Alex", 25);
        User user4 = new User("Mikhail", 22);
        List<User> list = List.of(user1, user2, user3, user4);
        List<User> result = user.sortByAllFields(list);
        List<User> expected = List.of(user3, user1, user4, user2);
        assertThat(result, is(expected));
    }
}
