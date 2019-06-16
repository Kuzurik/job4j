package ru.job4j.array;

/**
 * re-sorting program
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {

    /**
     * re-sorting method
     * @param array for re-sort
     * @return array after resort
     */

    public int[] sort(int[] array) {
        // reduces array length
        for (int index = array.length - 1; index != 0; index--) {
            // change numbers
            for (int change = 0; change != index; change++) {
                if (array[change] > array[change + 1]) {
                    int temp = array[change];
                    array[change] = array[change + 1];
                    array[change + 1 ] = temp;
                }
            }
        }

        return array;
    }
}
