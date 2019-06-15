package ru.job4j.array;

/**
 * Filling the array with powers of numbers.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Square {

    /**
     * Filling the array with powers of numbers.
     * @param bound array length
     * @return filled array.
     */

    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != bound; i++){
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}
