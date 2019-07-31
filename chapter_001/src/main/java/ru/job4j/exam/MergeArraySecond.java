package ru.job4j.exam;

/**
 * Merge two arrays.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MergeArraySecond {

    /**
     * add two arrays
     * @param left the first array.
     * @param right the second array.
     * @return first + second array.
     */

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int length = 0;
        for (int i = 0; i != left.length; i++) {
            if (left[i] < right[i]) {
                result[length] = left[i];
                result[length + 1] = right[i];
                length += 2;
            } else {
                result[length] = right[i];
                result[length + 1] = left[i];
                length += 2;
            }
        }
        return result;

    }
}
