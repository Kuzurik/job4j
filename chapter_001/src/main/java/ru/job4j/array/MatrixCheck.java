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
            for (int inner = 0; inner != data.length - 1; inner++) {
                if (data[out][inner] != data[out + 1][inner + 1]) {
                    result = false;
                }
            }
        }
        return result;
    }


}
