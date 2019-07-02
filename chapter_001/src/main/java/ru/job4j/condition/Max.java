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
     * @param left firs number
     * @param right second number
     * @return greater number
     */

    public int max(int left, int right) {
       return left > right ? left : right;
    }
  }
