package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ConvertArrayListToListTest {

    @Test
    public void whenAddArraysToListThenGetOneList() {
        ConvertArrayListToList list = new ConvertArrayListToList();
        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[] {1, 2});
        arrays.add(new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert(arrays);
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expect));
    }
}
