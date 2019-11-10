package ru.job4j.sorting;

import java.util.*;

public class SortUser {


    public Set<User> sort(List<User> users) {
        Set<User> set = new TreeSet<>();
        set.addAll(users);
        return set;
    }

    public List<User> sortNameLength(List<User> users) {
        Comparator<User> comparator = new UserNameLength();
        List<User> list = new ArrayList<>();
        list.addAll(users);
        Collections.sort(list, comparator);
        return list;
    }

    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> comparator = new UserNameSort().thenComparing(new UserAgeSort());
        List<User> list = new ArrayList<>();
        list.addAll(users);
        Collections.sort(list, comparator);
        return list;
    }
}
