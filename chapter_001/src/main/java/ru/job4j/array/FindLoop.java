package ru.job4j.array;

/**
 * classic brute force search.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class FindLoop {

    /**
     * Find element of array.
     * @param data array
     * @param el search value
     * @return array's index
     */

    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
       return rst;
    }
}
