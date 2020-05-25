package ru.job4j.listtomap;

import org.junit.Test;

import ru.job4j.listtomap.Converting;
import ru.job4j.listtomap.Student;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertingTest {
    @Test
    public void whenAddListReturnMap() {
        Converting converting = new Converting();
        Student student = new Student("Alex", 30);
        Student student1 = new Student("Max", 60);
        Student student2 = new Student("Igor", 100);
        Student student4 = new Student("Max", 60);
        List<Student> students = List.of(student, student1, student2, student4);
        Map<String, Student> result = converting.convert(students);
        Map<String, Student> expected = Map.of(
                "Alex", student,
                "Max", student1,
                "Igor", student2);
        assertThat(result, is(expected));
    }
}
