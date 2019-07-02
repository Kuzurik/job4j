package ru.job4j.array;

/**
 * Two-dimensional array. Multiplication table
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Matrix {

    /**
     * filling number and multiplication
     * @param size size of array
     * @return multiplication and filling array
     */

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out != size; out++) {
            for (int inner = 0; inner != size; inner++) {
                int tmp = (out + 1) * (inner + 1);
                table[out][inner] = tmp;
            }
        }
        return table;
    }

}
