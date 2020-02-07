package ru.job4j.DepartmentsTest;

import org.junit.Test;
import ru.job4j.collection.Departments;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);

        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void testAscSort() {
        List<String> dataIn = Arrays.asList("k1/s1/ss3", "k2/s2/ss2");
        List<String> expect = Arrays.asList("k1", "k1/s1", "k1/s1/ss3", "k2", "k2/s2", "k2/s2/ss2");
        List<String> rsl = Departments.fillGaps(dataIn);
        assertThat(rsl, is(expect));
    }

    @Test
    public void testDescSort() {
        List<String> dataIn = List.of("k1/s1/ss3", "k2/s2/ss2");
        List<String> expect = List.of("k2/s2/ss2", "k2/s2", "k2", "k1/s1/ss3", "k1/s1", "k1");
        List<String> rsl = Departments.fillGaps(dataIn);
        Departments.sortDesc(rsl);
        assertThat(rsl, is(expect));
    }
}