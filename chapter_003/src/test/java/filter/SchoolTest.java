package filter;

import org.junit.Test;
import ru.job4j.filter.School;
import ru.job4j.filter.Student;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void whenInSeventyToOneHundred() {
        School school = new School();
        List<Student> studentList = List.of(
                new Student(30),
                new Student(70),
                new Student(50),
                new Student(80)
        );
        List<Student> result = school.collect(studentList,score -> score.getScore() >= 70 && score.getScore() < 100);
        List<Student> expected = List.of(
                new Student(70),
                new Student(80)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenInFiftyToSeventy() {
        School school = new School();
        List<Student> studentList = List.of(
                new Student(30),
                new Student(70),
                new Student(50),
                new Student(80),
                new Student(60)
        );
        List<Student> result = school.collect(studentList,score -> score.getScore() >= 0 && score.getScore() <= 50);
        List<Student> expected = List.of(
                new Student(30),
                new Student(50)
                );
        assertThat(result, is(expected));
    }

    @Test
    public void whenInZeroToFifty() {

    }

}
