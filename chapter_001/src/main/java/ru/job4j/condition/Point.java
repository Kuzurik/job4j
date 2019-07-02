package ru.job4j.condition;

/**
 * Distance calculation
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Point {

    /**
     * Distance calculation
     * @param x1 coordinate
     * @param x2 coordinate
     * @param y1 coordinate
     * @param y2 coordinate
     * @return Distance
     */

    public double distance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
