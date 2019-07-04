package ru.job4j.exam;

/**
 * Merge two arrays.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MergeArray {

    /**
     * add two arrays
     * @param left the first array.
     * @param right the second array.
     * @return first + second array.
     */

    public int[] merge(int[] left, int[] right) {

            int[] result = new int[left.length + right.length];
            int i = 0, j = 0;
            for (int k = 0; k != result.length; k++) {
                if (i > left.length - 1) {
                    result[k] = right[j];
                    j++;
                } else if (j > right.length - 1) {
                    result[k] = left[i];
                    i++;
                } else if (left[i] < right[j]) {
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
            }
            return result;
        }
    }



