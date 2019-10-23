package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayListToList {
    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
            for (int[] arrays : list) {
                for (int value : arrays) {
                    result.add(value);
                }
            }
        return result;
    }
}
