package ru.job4j.array;
import java.util.Arrays;

/**
 * Remove duplicates in an array.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {

    /**
     * compares and swaps the elements of an array and deletes the last element
     * @param array Array for sorting
     * @return Sorted array.
     */

    public String[] remove(String[] array) {
            int index = array.length;
            for (int out = 0; out != index; out++) {
                for (int inner = out + 1; inner != index; inner++) {
                    if (array[out].equals(array[inner])) {
                        array[inner] = array[index - 1];
                        index--;
                        inner--;
                    }
                }
            }
            return Arrays.copyOf(array, index);
    }

}
