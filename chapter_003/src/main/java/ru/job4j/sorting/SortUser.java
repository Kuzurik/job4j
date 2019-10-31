package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort (List<User> users) {
        Set<User> set = new TreeSet<>();
        set.addAll(users);
        return set;
    }
}
