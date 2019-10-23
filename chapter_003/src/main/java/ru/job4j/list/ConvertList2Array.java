package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
<<<<<<< HEAD
    public int[][] toArray(List<Integer> list, int rows) {
=======
        public int[][] toArray(List<Integer> list, int rows) {
>>>>>>> origin/master
            int cells = rows;
            int row = 0;
            int col = 0;
            int[][] array = new int[rows][cells];
            for (int value : list) {
<<<<<<< HEAD
                   array[row][col] = value;
                   col++;
                   if (col == cells) {
                       col = 0;
                       row++;
                   }
               }

                for (int[] i : array) {
                    for (int j : i) {
                        System.out.println(j);
                    }
                }
        return array;
    }
=======
                array[row][col] = value;
                col++;
                if (col == cells) {
                    col = 0;
                    row++;
                }
            }
            return array;
        }
>>>>>>> origin/master
}
