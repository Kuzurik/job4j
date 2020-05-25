package ru.job4j.map;


import java.util.Objects;

public class User {
    private String name;
    private int children;
    private int birthday;

    public User(String name, int children, int birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hashName = name != null ? name.hashCode() : 0;
        return 31 * hashName * children * birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && birthday == user.birthday
                && Objects.equals(name, user.name);
    }
}
