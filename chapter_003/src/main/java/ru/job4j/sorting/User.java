package ru.job4j.sorting;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        return this.age.compareTo(user.age);
    }
}
