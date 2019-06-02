package ru.job4j.calculator;


/**
 * Calculate.
 * @author Aliaksandr Kuzura.
 * @since 25.05.2019.
 * @version 1.
 */


public class Calculator {


    /**
     *
     * @param first slogan
     * @param second slogan
     * @return add result
     */

    public double add(double first, double second) {
        return first + second;
    }

    /**
     *
     * @param first minuend
     * @param second subtrahend
     * @return subtract result
     */

    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     *
     * @param first dividend
     * @param second divider
     * @return div result
     */

    public double div(double first, double second) {
        return first / second;
    }

    /**
     *
     * @param first factor
     * @param second factor
     * @return multiple result
     */

    public double multiple(double first, double second) {
        return first * second;
    }




}
