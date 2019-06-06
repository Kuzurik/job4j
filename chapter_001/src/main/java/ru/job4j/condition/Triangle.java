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
     *  Calculation semi-perimeter
     * @param a side triangle
     * @param b side triangle
     * @param c side triangle
     * @return semi-perimeter
     */

    public double period(double a, double b, double c) {

        return (a + b + c) / 2;
    }

    /**
     * Calculate Calculate the ability to create a triangle
     * @param a side triangle
     * @param b side triangle
     * @param c side triangle
     * @return true or false
     */

    private  boolean exist(double a, double b, double c) {

        return a + b >= c  && a + c >= b  && b + c >= a;
    }

    /**
     *  Calculate the area of the triangle
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


        double a = new Point().distance(x1, y1, x2, y2);
        double b = new Point().distance(x2, y2, x3, y3);
        double c = new Point().distance(x1, y1, x3, y3);
        double p = period(a, b, c);

            if (this.exist(a, b, c)) {
                rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            } else {
                rsl = -1;
            }


        return rsl;


    }



}
