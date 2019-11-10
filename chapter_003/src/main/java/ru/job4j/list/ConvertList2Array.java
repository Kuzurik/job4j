package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
            int cells = rows;
            int row = 0;
            int col = 0;
            int[][] array = new int[rows][cells];
            for (int value : list) {
                array[row][col] = value;
                col++;
                if (col == cells) {
                    col = 0;
                    row++;
                }
            }
            return array;
        }
    }

