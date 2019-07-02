package ru.job4j.condition;

/**
 *  MultiMax number
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MultiMax {

    /**
     * comparison of three numbers
     * @param first number
     * @param second number
     * @param third number
     * @return Max number
     */

    public int max(int first, int second, int third) {
        int result;

        if (first > second && first > third) {
            result = first;
        } else if (second > first && second > third) {
            result = second;

        } else {
            result = third;
        }
        return result;

    }

}
