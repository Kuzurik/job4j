package ru.job4j.condition;

/**
 *  Max number
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     *  Calculation max number
     * @param first firs number
     * @param second second number
     * @return greater number.
     */

    public int max(int first, int second) {
       return first > second ? first : second;
    }

    /**
     *
     * @param first number.
     * @param second number.
     * @param third number.
     * @return greater number.
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    /**
     *
     * @param first number.
     * @param second number.
     * @param third number.
     * @param fourth number.
     * @return greater number.
     */
    public int max(int first, int second, int third, int fourth) {
        return max(first, max(second, max(third, fourth)));
    }

  }
