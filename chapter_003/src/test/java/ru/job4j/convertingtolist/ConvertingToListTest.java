package ru.job4j.convertingToList;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertingToListTest {
    @Test
    public void whenMatrixToList() {
        ConvertingToList convertingToList = new ConvertingToList();
        Integer[][] matrix = new Integer[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> result = convertingToList.collect(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        assertThat(result, is(expected));
    }
}
