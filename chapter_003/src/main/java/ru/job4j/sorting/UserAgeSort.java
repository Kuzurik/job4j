package ru.job4j.sorting;

import java.util.Comparator;

public class UserAgeSort implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
