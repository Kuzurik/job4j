package ru.job4j.convertingtolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertingToList {
    public List<Integer> collect(Integer[][] matrix) {
        return List.of(matrix).stream().flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
