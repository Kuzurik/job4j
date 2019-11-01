package ru.job4j.sorting;

import java.util.Comparator;

public class UserNameLength implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if(o1.getName().length() > o2.getName().length()){
            return 1;
        } else if (o1.getName().length() < o2.getName().length()) {
            return -1;
        }
        return 0;
    }
}
