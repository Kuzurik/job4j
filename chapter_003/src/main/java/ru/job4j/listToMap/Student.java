package ru.job4j.listToMap;

import java.util.Objects;

public class Student {
    private String family;
    private int score;

    public Student(String family, int score) {
        this.family = family;
        this.score = score;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public String toString() {
        return "Student{" +
                "family='" + family + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(family, student.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, score);
    }
}
