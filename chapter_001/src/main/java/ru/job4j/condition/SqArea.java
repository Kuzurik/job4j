package ru.job4j.condition;

/**
 * calculate perimeter of a triangle
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */


public class SqArea {

    /**
     * Rectangle area calculation
     * @param p perimeter of a rectangle
     * @param k height * k
     * @return square
     */

    public int square(int p, int k) {
       int w = (p / (2 * k + 2)) * k;
       int h = (p / (2 * k + 2));
        return w * h;
    }
}
