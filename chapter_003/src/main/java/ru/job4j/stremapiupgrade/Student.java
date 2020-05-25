package ru.job4j.stremApiUpgrade;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private  Integer score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score.compareTo(o.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
