package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
<<<<<<< HEAD

=======
>>>>>>> origin/master
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int[] i : array) {
<<<<<<< HEAD
            for (int j : i) {
                 list.add(index, j);
                index++;
            }
        }

       return list;
=======
            for (int value : i) {
                list.add(index, value);
                index++;
            }
        }
        return list;
>>>>>>> origin/master
    }
}
