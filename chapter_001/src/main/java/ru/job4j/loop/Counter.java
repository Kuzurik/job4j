package ru.job4j.loop;

/**
 * Counting even numbers in a range.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */



public class Counter {

    /**
     *  Counting even numbers in a range.
     * @param start Beginning of range.
     * @param finish End of range.
     * @return The sum of even numbers.
     */

    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
