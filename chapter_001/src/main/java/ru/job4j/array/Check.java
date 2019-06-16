package ru.job4j.array;

/**
 * checking array for true or false
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Check {

    /**
     *  checking array for true or false
     * @param data array for check
     * @return result true or false
     */

    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index != data.length; index++) {
                if (!data[index]) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
        }
        return result;
    }
}
