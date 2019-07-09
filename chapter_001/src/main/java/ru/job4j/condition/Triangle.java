package ru.job4j.condition;


/**
 * Calculation triangle area
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point a, Point b, Point c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }


    /**
     *  Method of calculating the half-perimeter by side length
     * @param a distance between points a b.
     * @param b distance between points a c.
     * @param c distance between points b c.
     * @return half-perimeter.
     */

   public double period(double a, double b, double c) {
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
          return a + b > c  && a + c > b  && b + c > a;
    }


     public double area(Point first, Point second, Point third) {
        double rsl;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
             if (this.exist(a, b, c)) {
                rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            } else {
                rsl = -1;
            }
        return rsl;
    }
}
