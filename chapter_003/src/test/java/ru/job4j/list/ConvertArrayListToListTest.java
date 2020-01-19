package ru.job4j.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ConvertArrayListToListTest {

    @Test
    public void whenAddArraysToListThenGetOneList() {
        ConvertArrayListToList list = new ConvertArrayListToList();
        List<int[]> arrays = List.of(new int[] {1, 2}, new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert(arrays);
        List<Integer> expect =List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
