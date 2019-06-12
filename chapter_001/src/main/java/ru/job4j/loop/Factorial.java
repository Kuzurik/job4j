package ru.job4j.loop;

/**
 * Create a program that calculates factorial.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {

    /**
     * Calculate factorial
     * @param n end of range.
     * @return factorial or 1
     */

    public int calc(int n) {
        int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
       return result;
    }


}
