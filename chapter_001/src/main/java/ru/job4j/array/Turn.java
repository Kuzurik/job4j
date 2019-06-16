package ru.job4j.array;

/**
 * flip the array
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */


public class Turn {

    /**
     * flip the array
     * @param array array for coup
     * @return inverted array
     */

    public int[] back(int[] array) {
       for (int index = 0; index != array.length / 2; index++) {
           int tmp = array[index];
           array[index] = array[array.length - index - 1];
           array[array.length - index - 1] = tmp;
        }

        return array;
    }
}
