package ru.job4j.condition;

/**
 * Distance calculation
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Point {

    private int x;
    private int y;


    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }




    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }

}
