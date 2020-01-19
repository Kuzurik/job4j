package ru.job4j.streamApiUpgrade;

import org.junit.Test;
import ru.job4j.stremApiUpgrade.Filter;
import ru.job4j.stremApiUpgrade.Student;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FilterTest {
    @Test
    public void whenListReturnSortingList() {
        Filter filter = new Filter();
        List<Student> students = List.of(
                new Student("Alex", 14),
                new Student("Nikita", 50),
                new Student("Valera", 30));
        List<Student> result = filter.levelOf(students, 20);
       List<Student> expected = List.of(new Student("Valera", 30),new Student("Nikita", 50));
       assertThat(result, is(expected));
    }
}
