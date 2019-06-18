package ru.job4j.array;

/**
 * check matrix true or false on the diagonal
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {

    /**
     * check matrix true or false
     * @param data matrix for check
     * @return result true or false
     */
    public boolean mono(boolean[][] data) {
    boolean result = true;
        for (int out = 0; out != data.length - 1; out++) {
            if (data[out][out] != data[out + 1][out + 1] || data[data.length - 1 - out][out] != data[data.length - 2 - out][out + 1]) {
                result = false;
            }
        }
        return result;
    }


}
