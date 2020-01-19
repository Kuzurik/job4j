package ru.job4j.streamApiUpgrade;

import org.junit.Test;
import ru.job4j.stremApiUpgrade.Filter;
import ru.job4j.stremApiUpgrade.Student;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FilterTest {
    @Test
    public void whenListReturnSortingList() {
        Filter filter = new Filter();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", 14));
        students.add(new Student("Nikita", 50));
        students.add(new Student("Valera", 30));
        students.add(null);
        List<Student> result = filter.levelOf(students, 20);
       List<Student> expected = List.of(new Student("Valera", 30),new Student("Nikita", 50));
       assertThat(result, is(expected));
    }
}
