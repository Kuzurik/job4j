package ru.job4j.condition;


/**
 * Calculation triangle area
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */



public class Triangle {

    /**
     *  Method of calculating the half-perimeter by side length
     * @param a distance between points a b.
     * @param b distance between points a c.
     * @param c distance between points b c.
     * @return half-perimeter.
     */

    public double period(double a, double b, double c) {
        //calculation half-perimeter.
        return (a + b + c) / 2;
    }

    /**
     * The method checks whether it is possible to construct a triangle with such lengths of the sides.
     * @param a Length from point a b.
     * @param b Length from point a c.
     * @param c Length from point b c.
     * @return true or false
     */

    private  boolean exist(double a, double b, double c) {
        // check the possibility of building a triangle
        return a + b > c  && a + c > b  && b + c > a;
    }

    /**
     *  The method calculates the area of ​​the triangle
     * @param x1 coordinate
     * @param y1 coordinate
     * @param x2 coordinate
     * @param y2 coordinate
     * @param x3 coordinate
     * @param y3 coordinate
     * @return triangle's area
     */

    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl;
        // create side a
        double a = new Point().distance(x1, y1, x2, y2);
        // create side b
        double b = new Point().distance(x2, y2, x3, y3);
        //create side c
        double c = new Point().distance(x1, y1, x3, y3);
        // calculate perimeter
        double p = period(a, b, c);
        // check the possibility of building a triangle.
            if (this.exist(a, b, c)) {
                // calculates the area of ​​the triangle
                rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            } else {
                rsl = -1;
            }
            // return area or -1
        return rsl;


    }



}
